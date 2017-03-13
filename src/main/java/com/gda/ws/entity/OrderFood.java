package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_food", schema = "", catalog = "foodapp")
@IdClass(OrderFoodPK.class)
public class OrderFood {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Id
    @Column(name = "food_id")
    private Long foodId;

    @Basic
    @Column(name = "quantity")
    private Long quantity;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

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
}
