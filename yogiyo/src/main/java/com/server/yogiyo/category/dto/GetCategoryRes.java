package com.server.yogiyo.category.dto;

import com.server.yogiyo.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryRes {

    private Integer categoryId;

    private String name;

    private String image;

    private Boolean isFood;


    public GetCategoryRes(Category category) {

        this.categoryId = category.getCategoryId();
        this.name = category.getName();
        this.image = category.getImage();
        this.isFood = category.getIsFood();

    }

}
