package com.server.yogiyo.orders;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Options;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    private Integer totalPrice;

    @OneToMany(mappedBy = "orders")
    private List<Options> optionsList = new ArrayList<>();
}
