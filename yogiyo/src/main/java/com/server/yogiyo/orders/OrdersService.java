package com.server.yogiyo.orders;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.menu.entity.Menu;
import com.server.yogiyo.menu.entity.Options;
import com.server.yogiyo.menu.repositroy.MenuRepository;
import com.server.yogiyo.menu.repositroy.OptionsRepository;
import com.server.yogiyo.orders.dto.GetCompleteRes;
import com.server.yogiyo.orders.entity.CompleteOrders;
import com.server.yogiyo.orders.dto.OrdersTableRes;
import com.server.yogiyo.orders.entity.Orders;
import com.server.yogiyo.orders.entity.PaymentMathodType;
import com.server.yogiyo.orders.repository.CompleteOrdersRepository;
import com.server.yogiyo.orders.repository.OrdersRepository;
import com.server.yogiyo.restaurant.repository.RestaurantRepository;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
        Restaurant restaurant = restaurantRepository.findByRestaurantIdAndStatus(restaurantId, Valid)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.Restaurant_NOT_FOUND));
        List<Orders> existOrdersList = ordersRepository.findByAccountAndStatus(account, OrderWaiting);
        existOrdersList =  existOrdersList.stream().filter(o -> !(o.getRestaurant().equals(restaurant))).collect(Collectors.toList());
        if (existOrdersList.size() > 0) throw new CustomException(CustomExceptionStatus.EXIST_ANOTHER_RESTAURANT);
        Menu menu = menuRepository.findByMenuIdAndStatus(menuId, Valid)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.MENU_NOT_FOUND));
        Orders orders = Orders.createOrders(account, restaurant, menu);
        Orders save = ordersRepository.save(orders);


        for (Long id : optionsIdList) {
            Options options = optionsRepository.findByOptionsIdAndStatus(id, Valid)
                    .orElseThrow(() -> new CustomException(CustomExceptionStatus.OPTIONS_NOT_FOUND));
            orders.addOptions(options);
        }

        return save.getOrdersId();
    }

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

    public List<GetCompleteRes> getCompleteOrdersByAccount(CustomUserDetails customUserDetails) {
        Account account = customUserDetails.getAccount();
        List<CompleteOrders> completeOrdersList = completeOrdersRepository.findAllByAccount(account);
        List<GetCompleteRes> result = new ArrayList<>();
        for (CompleteOrders completeOrders : completeOrdersList) {
            GetCompleteRes completeRes = GetCompleteRes.createCompleteRes(completeOrders);
            result.add(completeRes);
        }
        return result;
    }
}
