package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class History {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "order_user_id", referencedColumnName = "id", nullable = false)
    private User orderUser;

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

    public User getUser() {
        return orderUser;
    }

    public void setUser(User orderUser) {
        this.orderUser = orderUser;
    }
}
