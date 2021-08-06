package com.server.yogiyo.menu.entity;

import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.orders.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Options extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionsId;

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

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public static Options createOrderOptions(Orders orders,Options options){
        return  Options.builder()
                .status(options.getStatus())
                .menu(options.getMenu())
                .orders(orders)
                .title(options.title)
                .isNecessary(options.isNecessary)
                .name(options.getName())
                .addCost(options.getAddCost())
                .build();
    }

}
