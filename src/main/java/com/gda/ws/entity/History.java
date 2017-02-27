package com.gda.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	
	@Id
    private Long id;
	
	@Column(name = "order_id")
    private Long orderId;
	
	@Column(name = "order_user_id1")
    private Long orderUserId;
	
	@Column(name = "order_order_status_id")
    private Long orderOrderStatusId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(Long orderUserId) {
		this.orderUserId = orderUserId;
	}

	public Long getOrderOrderStatusId() {
		return orderOrderStatusId;
	}

	public void setOrderOrderStatusId(Long orderOrderStatusId) {
		this.orderOrderStatusId = orderOrderStatusId;
	}
}
