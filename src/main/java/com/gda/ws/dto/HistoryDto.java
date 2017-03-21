package com.gda.ws.dto;

import com.gda.ws.entity.Order;
import com.gda.ws.entity.User;

public class HistoryDto {

    private Long id;

    private OrderDto order;

    private UserDto orderUser;

    public UserDto getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(UserDto orderUser) {
        this.orderUser = orderUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

}
