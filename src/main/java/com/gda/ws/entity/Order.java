package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "order", schema = "", catalog = "foodapp")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "user_id")
    private Long userId;

    @Basic
    @Column(name = "status_id")
    private Long statusId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_info_id", referencedColumnName = "id")
    private OrderInfo orderInfoByOrderInfoId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (statusId != null ? !statusId.equals(order.statusId) : order.statusId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        return result;
    }

    public OrderInfo getOrderInfoByOrderInfoId() {
        return orderInfoByOrderInfoId;
    }

    public void setOrderInfoByOrderInfoId(OrderInfo orderInfoByOrderInfoId) {
        this.orderInfoByOrderInfoId = orderInfoByOrderInfoId;
    }

}
