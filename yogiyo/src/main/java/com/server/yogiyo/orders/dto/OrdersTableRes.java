package com.server.yogiyo.orders.dto;

import com.server.yogiyo.orders.Orders;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersTableRes {


    private String restaurantName;
    private List<OrdersListRes> ordersList = new ArrayList<>();
    private Integer deliveryMinCost;
    private Integer deliveryCost;
    private Integer sum;


    public OrdersTableRes(List<Orders> orders) {
        List<OrdersListRes> ordersListResList = orders.stream().map(OrdersListRes::new).collect(Collectors.toList());
        HashMap<OrdersListRes, Integer> hashMap = new HashMap<>();
        for (OrdersListRes res : ordersListResList) {
            if (hashMap.containsKey(res)) {
                hashMap.put(res, hashMap.get(res) + 1);
            } else hashMap.put(res, 1);
        }
        Iterator<OrdersListRes> iterator = hashMap.keySet().iterator();
        this.sum = 0;
        while (iterator.hasNext()) {
            OrdersListRes nowOrders = iterator.next();
            nowOrders.setCnt(hashMap.get(nowOrders));
            this.ordersList.add(nowOrders);
            this.sum += nowOrders.getCnt() * nowOrders.getPrice();
        }

        Restaurant restaurant = orders.get(0).getRestaurant();
        this.restaurantName = restaurant.getName();
        this.deliveryMinCost = restaurant.getDeliveryMinCost();
        this.deliveryCost = restaurant.getDeliveryCost();
        if (sum < deliveryMinCost) sum = deliveryCost + deliveryMinCost;
        else sum += deliveryCost;
    }
}
