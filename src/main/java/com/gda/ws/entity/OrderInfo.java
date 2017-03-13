package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity

@Table(name = "order_info", schema = "", catalog = "foodapp")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "orderInfoByOrderInfoId", cascade = CascadeType.ALL)
    private Collection<Order> ordersById;

    public OrderInfo() {

    }

    public OrderInfo(Long id, String phone, String address) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo orderInfo = (OrderInfo) o;

        if (id != null ? !id.equals(orderInfo.id) : orderInfo.id != null) return false;
        if (address != null ? !address.equals(orderInfo.address) : orderInfo.address != null) return false;
        if (phone != null ? !phone.equals(orderInfo.phone) : orderInfo.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
