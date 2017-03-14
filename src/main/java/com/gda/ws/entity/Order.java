package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "order", schema = "foodapp")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status_id")
    private Long statusId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_info_id", referencedColumnName = "id")
    private OrderInfo orderInfo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Collection<History> histories;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Collection<OrderFood> orderFoods;

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

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Collection<History> getHistories() {
        return histories;
    }

    public void setHistories(Collection<History> histories) {
        this.histories = histories;
    }


    public Collection<OrderFood> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(Collection<OrderFood> orderFoods) {
        this.orderFoods = orderFoods;
    }
}
