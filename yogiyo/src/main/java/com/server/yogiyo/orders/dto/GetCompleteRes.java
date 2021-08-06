package com.server.yogiyo.orders.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.orders.entity.CompleteOrders;
import com.server.yogiyo.orders.entity.PaymentMathodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCompleteRes {

    private Long completeId;

    private Status status;

    private Long restaurantId;

    private String restaurantName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    private List<OrdersListRes> ordersList = new ArrayList<>();

    public void setOrdersList(List<OrdersListRes> ordersList) {
        this.ordersList = ordersList;
    }

    private Integer paymentPrice;

    private PaymentMathodType paymentMethod;

    private String accountPhoneNumber;

    private String accountAddress;

    private String requests;

    private String originInform;

    public static GetCompleteRes createCompleteRes(CompleteOrders completeOrders) {

        GetCompleteRes build = GetCompleteRes.builder()
                .completeId(completeOrders.getCompleteId())
                .status(completeOrders.getStatus())
                .restaurantId(completeOrders.getRestaurant().getRestaurantId())
                .restaurantName(completeOrders.getRestaurant().getName())
                .createdAt(completeOrders.getCreatedAt())
                .paymentPrice(completeOrders.getPaymentPrice())
                .paymentMethod(completeOrders.getPaymentMethod())
                .accountPhoneNumber(completeOrders.getAccountPhoneNumber())
                .accountAddress(completeOrders.getAccountAddress())
                .requests(completeOrders.getRequests())
                .originInform(completeOrders.getOriginInform())
                .build();

        List<OrdersListRes> ordersList = completeOrders.getOrdersList().stream().map(OrdersListRes::getResultOrderListRes).collect(Collectors.toList());
        HashMap<OrdersListRes, Integer> hashMap = new HashMap<>();
        for (OrdersListRes res :  ordersList) {
            if (hashMap.containsKey(res)) {
                hashMap.put(res, hashMap.get(res) + 1);
            } else hashMap.put(res, 1);
        }
        Iterator<OrdersListRes> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            OrdersListRes nowOrders = iterator.next();
            nowOrders.setCnt(hashMap.get(nowOrders));
            ordersList.add(nowOrders);
        }

        build.setOrdersList(ordersList);

        return build;

    }



}
