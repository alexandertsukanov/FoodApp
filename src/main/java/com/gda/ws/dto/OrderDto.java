package com.gda.ws.dto;

import java.util.Collection;

public class OrderDto {

    private Long id;

    private UserDto user;

    private OrderStatusDto status;

    private OrderInfoDto orderInfo;

    private Collection<HistoryDto> histories;

    private Collection<OrderFoodDto> orderFoods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public OrderStatusDto getStatus() {
        return status;
    }

    public void setStatus(OrderStatusDto status) {
        this.status = status;
    }


    public OrderInfoDto getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoDto orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Collection<HistoryDto> getHistories() {
        return histories;
    }

    public void setHistories(Collection<HistoryDto> histories) {
        this.histories = histories;
    }


    public Collection<OrderFoodDto> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(Collection<OrderFoodDto> orderFoods) {
        this.orderFoods = orderFoods;
    }

}
