package com.server.yogiyo.restaurant.entity;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.category.entity.CategoryRelation;
import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Restaurant extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    private String thumbnail;

    private String name;

    private Float grade;

    private Integer deliveryTime;

    private Integer deliveryMinCost;

    private Integer deliveryCost;

    private Float distance;

    private String infoImage1;

    private String infoImage2;

    private String infoImage3;

    private String infoImage4;

    private String infoContents;

    private String phoneNumber;

    private String generalAddress;

    private String detailedAddress;

    private Boolean yogiyoPayment;

    private Boolean onSitePayment;

    private Boolean cardPayment;

    private Boolean cashPayment;

    private String businessName;

    private String registrationNumber;

    private String originInform;

    private Long likeCount;

    private Boolean isExpress;

    private Long reviewCount;

    private Integer discountValue;

    private Long orderQuantity;

    private Boolean cesco;

    private Boolean focusAD;

    public void addLikeCount() {
        this.likeCount++;
    }

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "restaurant")
    List<Hours> hoursList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    List<RestaurantMenuRelation> menuRelations = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    List<CategoryRelation> categoryRelationList = new ArrayList<>();
}
