package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_info", schema = "", catalog = "foodapp")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String phone;
    @Column(name = "phone")
    private String address;

    public OrderInfo() {
    }

    public OrderInfo(long id, String phone, String address) {
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

    public Long getOrderId() {
        return id;
    }

    public void setOrderId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo that = (OrderInfo) o;

        return Objects.equals(id, that.id);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
