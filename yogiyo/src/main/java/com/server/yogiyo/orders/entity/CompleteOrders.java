package com.server.yogiyo.orders.entity;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.server.yogiyo.configure.entity.Status.*;
import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CompleteOrders extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long completeId;

    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    private Integer paymentPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMathodType paymentMethod;

    private String accountPhoneNumber;

    private String accountAddress;

    private String requests;

    private String originInform;


    @OneToMany(mappedBy = "completeOrders")
    private List<Orders> ordersList = new ArrayList<>();

    public static CompleteOrders createCompleteOrders(Account account,List<Orders> ordersList, PaymentMathodType paymentMethod, String requests) {
        Integer sum = 0;
        for (Orders orders : ordersList) {
            sum += orders.getTotalPrice();
        }
        Restaurant restaurant = ordersList.get(0).getRestaurant();
        if (restaurant.getDeliveryMinCost() > sum) sum = restaurant.getDeliveryMinCost() + restaurant.getDeliveryCost();
        else sum += restaurant.getDeliveryCost();
        return CompleteOrders.builder()
                .ordersList(ordersList)
                .account(account)
                .status(OrderComplete)
                .restaurant(restaurant)
                .paymentMethod(paymentMethod)
                .paymentPrice(sum)
                .accountPhoneNumber(account.getPhoneNumber())
                .accountAddress(account.getGeneralAddress() +" "+ account.getDetailedAddress())
                .requests(requests)
                .originInform(restaurant.getOriginInform())
                .build();
    }
}
