package com.server.yogiyo.menu.dto;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Menu;
import com.server.yogiyo.restaurant.entity.RestaurantMenuRelation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LookupMenuRes {

    private Long menuId;

    private Status status;

    private String thumbnail;

    private String name;

    private String subName;

    private Integer price;

    private String grade;

    private Long reviewCount;

    public LookupMenuRes(RestaurantMenuRelation restaurantMenuRelation) {
        this.menuId = restaurantMenuRelation.getMenu().getMenuId();
        this.status = restaurantMenuRelation.getMenu().getStatus();
        this.thumbnail = restaurantMenuRelation.getMenu().getThumbnail();
        this.name = restaurantMenuRelation.getMenu().getName();
        this.subName = restaurantMenuRelation.getMenu().getSubName();
        this.price = restaurantMenuRelation.getMenu().getPrice();
        this.grade = restaurantMenuRelation.getMenu().getGrade();
        this.reviewCount = restaurantMenuRelation.getMenu().getReviewCount();
    }

    public LookupMenuRes(Menu menu) {
        this.menuId = menu.getMenuId();
        this.status = menu.getStatus();
        this.thumbnail = menu.getThumbnail();
        this.name = menu.getName();
        this.subName = menu.getSubName();
        this.price = menu.getPrice();
        this.grade = menu.getGrade();
        this.reviewCount = menu.getReviewCount();
    }

}
