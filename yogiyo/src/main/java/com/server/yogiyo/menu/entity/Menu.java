package com.server.yogiyo.menu.entity;

import com.server.yogiyo.category.entity.CategoryRelation;
import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.restaurant.entity.RestaurantMenuRelation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Menu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String title;

    private String thumbnail;

    private String name;

    private String subName;

    private String price;

    private String grade;

    private Long reviewCount;

    @OneToMany(mappedBy = "menu")
    private List<Options> optionsList = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<RestaurantMenuRelation> restaurantMenuRelationList = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<CategoryRelation> categoryRelationList = new ArrayList<>();
}
