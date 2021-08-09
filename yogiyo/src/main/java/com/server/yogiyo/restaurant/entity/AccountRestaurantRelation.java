package com.server.yogiyo.restaurant.entity;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.server.yogiyo.configure.entity.Status.*;
import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AccountRestaurantRelation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    private Boolean isLike;

    public void setLike(Boolean like) {
        isLike = like;
    }

    public AccountRestaurantRelation(Account account, Restaurant restaurant) {
        this.status = Valid;
        this.account = account;
        this.restaurant = restaurant;
        this.isLike = true;
        restaurant.addLikeCount();
    }
}
