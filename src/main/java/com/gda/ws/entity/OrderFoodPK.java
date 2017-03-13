package com.gda.ws.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderFoodPK implements Serializable {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Id
    @Column(name = "food_id")
    private Long foodId;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderFoodPK that = (OrderFoodPK) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (foodId != null ? !foodId.equals(that.foodId) : that.foodId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (foodId != null ? foodId.hashCode() : 0);
        return result;
    }
}
