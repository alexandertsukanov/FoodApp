package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "", catalog = "foodapp")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "device_id")
    private String deviceId;
	
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
}
