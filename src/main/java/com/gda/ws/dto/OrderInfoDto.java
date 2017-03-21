package com.gda.ws.dto;

import java.util.Date;
import java.util.Collection;

public class OrderInfoDto {

    private Long id;

    private String address;

    private String phone;

    private String name;

    private String comment;

    private Date date;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Collection<OrderDto> orders;

    public OrderInfoDto() {

    }

    public OrderInfoDto(Long id, String phone, String address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderDto> orders) {
        this.orders = orders;
    }

}
