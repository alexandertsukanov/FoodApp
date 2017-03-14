package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "foodapp")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "device_id")
    private String deviceId;

    @OneToMany(mappedBy = "orderUser")
    private Collection<History> histories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Collection<History> getHistories() {
        return histories;
    }

    public void setHistories(Collection<History> histories) {
        this.histories = histories;
    }
}
