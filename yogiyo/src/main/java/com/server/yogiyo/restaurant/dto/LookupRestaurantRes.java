package com.server.yogiyo.restaurant.dto;

import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LookupRestaurantRes {

    private Long restaurantId;

    private String thumbnail;

    private Integer discountValue;

    private String name;

    private Float grade;

    private Long reviewCount;

    private Integer deliveryTime;

    private Boolean isExpress;

    private Boolean cesco;

    public LookupRestaurantRes(Restaurant restaurant) {
        this.restaurantId = restaurant.getRestaurantId();
        this.thumbnail = restaurant.getThumbnail();
        this.discountValue = restaurant.getDiscountValue();
        this.name = restaurant.getName();
        this.grade = restaurant.getGrade();
        this.reviewCount = restaurant.getReviewCount();
        this.deliveryTime = restaurant.getDeliveryTime();
        this.isExpress = restaurant.getIsExpress();
        this.cesco = restaurant.getCesco();
    }

}
