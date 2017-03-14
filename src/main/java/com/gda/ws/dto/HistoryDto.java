package com.gda.ws.dto;

import com.gda.ws.entity.Order;
import com.gda.ws.entity.OrderStatus;
import com.gda.ws.entity.User;

public class HistoryDto {

    private Long id;

    private Order order;

    private OrderStatus orderStatus;

    private User orderUser;

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
