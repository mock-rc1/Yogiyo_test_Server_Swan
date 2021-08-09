package com.server.yogiyo.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.dto.LookupMenuRes;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.server.yogiyo.configure.entity.Status.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailRestaurantRes {

    private Long restaurantId;

    private Status status;

    private Long managerAccountId;

    private String thumbnail;

    private String name;

    private Float grade;

    private Integer deliveryTime;

    private Integer deliveryMinCost;

    private Integer deliveryCost;

    private Float distance;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String infoImage1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String infoImage2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String infoImage3;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String infoImage4;

    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    private Boolean isLike;

    List<HoursRes> hoursList = new ArrayList<>();

    List<LookupMenuRes> menuList = new ArrayList<>();

    public void setLike(Boolean like) {
        isLike = like;
    }

    public DetailRestaurantRes(Restaurant restaurant) {

        this.restaurantId = restaurant.getRestaurantId();
        this.status = restaurant.getStatus();
        this.managerAccountId = restaurant.getAccount().getAccountId();
        this.thumbnail = restaurant.getThumbnail();
        this.name = restaurant.getName();
        this.grade = restaurant.getGrade();
        this.deliveryTime = restaurant.getDeliveryTime();
        this.deliveryMinCost = restaurant.getDeliveryMinCost();
        this.deliveryCost = restaurant.getDeliveryCost();
        this.distance = restaurant.getDistance();
        this.infoImage1 = restaurant.getInfoImage1();
        this.infoImage2 = restaurant.getInfoImage2();
        this.infoImage3 = restaurant.getInfoImage3();
        this.infoImage4 = restaurant.getInfoImage4();
        this.infoContents = restaurant.getInfoContents();
        this.phoneNumber = restaurant.getPhoneNumber();
        this.generalAddress = restaurant.getGeneralAddress();
        this.detailedAddress = restaurant.getDetailedAddress();
        this.yogiyoPayment = restaurant.getYogiyoPayment();
        this.onSitePayment = restaurant.getOnSitePayment();
        this.cardPayment = restaurant.getCardPayment();
        this.cashPayment = restaurant.getCashPayment();
        this.businessName = restaurant.getBusinessName();
        this.registrationNumber = restaurant.getRegistrationNumber();
        this.originInform = restaurant.getOriginInform();
        this.likeCount = restaurant.getLikeCount();
        this.isExpress = restaurant.getIsExpress();
        this.reviewCount = restaurant.getReviewCount();
        this.discountValue = restaurant.getDiscountValue();
        this.orderQuantity = restaurant.getOrderQuantity();
        this.cesco = restaurant.getCesco();
        this.focusAD = restaurant.getFocusAD();
        this.hoursList =
                restaurant.getHoursList().stream().filter(h -> h.getStatus() != Deleted).map(HoursRes::new).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());

        this.menuList =
                restaurant.getMenuRelations().stream().filter(m -> m.getStatus() != Deleted).map(LookupMenuRes::new).collect(Collectors.toList());
    }

}
