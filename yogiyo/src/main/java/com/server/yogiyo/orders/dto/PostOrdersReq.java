package com.server.yogiyo.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostOrdersReq {

    Long restaurantId;
    Long menuId;
    Boolean isConfirmed;
    List<Long> optionsIdList = new LinkedList<>();

}
