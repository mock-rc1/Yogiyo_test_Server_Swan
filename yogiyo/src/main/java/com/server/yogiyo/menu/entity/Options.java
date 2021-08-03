package com.server.yogiyo.menu.entity;

import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Menu;
import com.server.yogiyo.orders.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Options extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menuId")
    private Menu menu;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "orderId")
    Orders orders;

    private String title;

    private Boolean isNecessary;

    private String name;

    private Integer addCost;


}
