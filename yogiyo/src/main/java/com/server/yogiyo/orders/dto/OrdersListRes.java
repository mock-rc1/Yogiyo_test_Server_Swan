package com.server.yogiyo.orders.dto;

import com.server.yogiyo.menu.entity.Options;
import com.server.yogiyo.orders.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersListRes {

    private String MenuName;
    private Integer price;
    private String menuOptions;
    private Integer cnt;

    public OrdersListRes(Orders orders) {
        this.price = orders.getTotalPrice();
        this.MenuName = orders.getMenu().getName();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (Options options : orders.getOptionsList()) {
            idx++;
            if (idx == orders.getOptionsList().size()) sb.append(options.getName());
            else sb.append(options.getName() + ", ");

        }
        this.menuOptions = sb.toString();
    }


    @Override
    public int hashCode() {
        return (this.getMenuName().hashCode() + this.getPrice().hashCode() + this.getMenuOptions().hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrdersListRes) {
            OrdersListRes temp = (OrdersListRes) obj;
            if (this.getMenuName().equals(temp.getMenuName()) && this.getMenuOptions().equals(temp.getMenuOptions()) && this.getPrice().equals(temp.getPrice())) {
                return true;
            }
        }
        return false;
    }
}
