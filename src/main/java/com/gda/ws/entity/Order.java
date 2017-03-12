package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Order {
    private Long id;
    private Long userId;
    private Long statusId;
    private Long orderInfoId;
    private Collection<OrderFood> orderFoodsById;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "status_id")
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "order_info_id")
    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (statusId != null ? !statusId.equals(order.statusId) : order.statusId != null) return false;
        if (orderInfoId != null ? !orderInfoId.equals(order.orderInfoId) : order.orderInfoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (orderInfoId != null ? orderInfoId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "orderByOrderId")
    public Collection<OrderFood> getOrderFoodsById() {
        return orderFoodsById;
    }

    public void setOrderFoodsById(Collection<OrderFood> orderFoodsById) {
        this.orderFoodsById = orderFoodsById;
    }
}
