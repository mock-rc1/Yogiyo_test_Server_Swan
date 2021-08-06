package com.server.yogiyo.orders.entity;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Menu;
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
    private Long OrdersId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    private Integer totalPrice;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "orders")
    private List<Options> optionsList = new ArrayList<>();

    public void addOptions(Options options) {
        this.totalPrice += options.getAddCost();
        this.optionsList.add(options);
        options.setOrders(this);
    }

    public static Orders createOrders(Account account, Restaurant restaurant, Menu menu) {
        Orders orders = new Orders();
        orders.account = account;
        orders.restaurant = restaurant;
        orders.menu = menu;
        orders.totalPrice = menu.getPrice();
        orders.status = Status.OrderWaiting;
        return orders;
    }

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "completeOrdersId")
    private CompleteOrders completeOrders;

    public void setCompleteOrders(CompleteOrders completeOrders) {
        this.completeOrders = completeOrders;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
