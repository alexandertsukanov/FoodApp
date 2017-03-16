package com.gda.ws.dto;

import java.util.Collection;

public class OrderStatusDto {

    private Long id;

    private String name;

    private Collection<OrderDto> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderDto> orders) {
        this.orders = orders;
    }

}
