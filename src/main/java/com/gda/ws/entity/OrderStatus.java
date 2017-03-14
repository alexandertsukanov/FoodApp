package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "order_status", schema = "foodapp")
public class OrderStatus {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private Collection<Order> orders;

    @OneToMany(mappedBy = "orderStatus")
    private Collection<History> histories;


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

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public Collection<History> getHistories() {
        return histories;
    }

    public void setHistories(Collection<History> histories) {
        this.histories = histories;
    }
}
