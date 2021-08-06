package com.server.yogiyo.orders;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.menu.entity.Menu;
import com.server.yogiyo.menu.entity.Options;
import com.server.yogiyo.menu.repositroy.MenuRepository;
import com.server.yogiyo.menu.repositroy.OptionsRepository;
import com.server.yogiyo.orders.entity.CompleteOrders;
import com.server.yogiyo.orders.dto.OrdersTableRes;
import com.server.yogiyo.orders.entity.Orders;
import com.server.yogiyo.orders.entity.PaymentMathodType;
import com.server.yogiyo.orders.repository.CompleteOrdersRepository;
import com.server.yogiyo.orders.repository.OrdersRepository;
import com.server.yogiyo.restaurant.RestaurantRepository;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.server.yogiyo.configure.entity.Status.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrdersService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final OrdersRepository ordersRepository;
    private final OptionsRepository optionsRepository;
    private final CompleteOrdersRepository completeOrdersRepository;

    @Transactional
    public Long createOrders(CustomUserDetails customUserDetails, Long restaurantId, Long menuId, List<Long> optionsIdList) {
        Account account = customUserDetails.getAccount();
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByRestaurantIdAndStatus(restaurantId, Valid);
        if (!optionalRestaurant.isPresent()) throw new CustomException(CustomExceptionStatus.Restaurant_NOT_FOUND);
        List<Orders> existOrdersList = ordersRepository.findByAccountAndStatus(account, OrderWaiting);
        existOrdersList =  existOrdersList.stream().filter(o -> !(o.getRestaurant().equals(optionalRestaurant.get()))).collect(Collectors.toList());
        if (existOrdersList.size() > 0) throw new CustomException(CustomExceptionStatus.EXIST_ANOTHER_Restaurant);
        Optional<Menu> optionalMenu = menuRepository.findByMenuIdAndStatus(menuId, Valid);
        if (!optionalMenu.isPresent()) throw new CustomException(CustomExceptionStatus.MENU_NOT_FOUND);
        Orders orders = Orders.createOrders(account, optionalRestaurant.get(), optionalMenu.get());
        Orders save = ordersRepository.save(orders);


        for (Long id : optionsIdList) {
            Optional<Options> optionalOptions = optionsRepository.findByOptionsIdAndStatus(id, Valid);
            if(!optionalOptions.isPresent()) throw new CustomException(CustomExceptionStatus.OPTIONS_NOT_FOUND);
            Options options = Options.createOrderOptions(save, optionalOptions.get());
            orders.addOptions(options);
        }

        return save.getOrdersId();
    }

    @Transactional
    public OrdersTableRes getTableByAccount(CustomUserDetails customUserDetails) {
        Account account = customUserDetails.getAccount();
        List<Orders> orders = ordersRepository.findByAccountAndStatus(account, OrderWaiting);
        if (orders.size() == 0) return null;
        OrdersTableRes ordersTableRes = new OrdersTableRes(orders);
        return ordersTableRes;
    }

    @Transactional
    public Long createCompleteOrdersByAccount(CustomUserDetails customUserDetails, PaymentMathodType paymentMathodType, String requests) {
        Account account = customUserDetails.getAccount();
        List<Orders> orders = ordersRepository.findByAccountAndStatus(account, OrderWaiting);
        if (orders.size() == 0) throw new CustomException(CustomExceptionStatus.NOT_EXIST_ORDERS);
        CompleteOrders completeOrders = CompleteOrders.createCompleteOrders(account, orders, paymentMathodType, requests);
        CompleteOrders save = completeOrdersRepository.save(completeOrders);
        for (Orders order : orders) {
            order.setStatus(OrderComplete);
            order.setCompleteOrders(save);
        }
        return save.getCompleteId();
    }
}
