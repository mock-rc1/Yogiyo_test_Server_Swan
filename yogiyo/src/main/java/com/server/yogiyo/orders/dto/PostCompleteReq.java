package com.server.yogiyo.orders.dto;

import com.server.yogiyo.orders.entity.PaymentMathodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCompleteReq {

    private PaymentMathodType paymentMathodType;
    private String requests;
}
