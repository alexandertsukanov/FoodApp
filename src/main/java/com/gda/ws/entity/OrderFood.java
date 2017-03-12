package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_food", schema = "", catalog = "foodapp")
@IdClass(OrderFoodPK.class)
public class OrderFood {
    private Long orderId;
    private Long foodId;
    private Long quantity;
    private Food foodByFoodId;
    private Order orderByOrderId;

    @Id
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "food_id")
    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderFood orderFood = (OrderFood) o;

        if (orderId != null ? !orderId.equals(orderFood.orderId) : orderFood.orderId != null) return false;
        if (foodId != null ? !foodId.equals(orderFood.foodId) : orderFood.foodId != null) return false;
        if (quantity != null ? !quantity.equals(orderFood.quantity) : orderFood.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (foodId != null ? foodId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Food getFoodByFoodId() {
        return foodByFoodId;
    }

    public void setFoodByFoodId(Food foodByFoodId) {
        this.foodByFoodId = foodByFoodId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
