package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "food_category", schema = "", catalog = "foodapp")
public class FoodCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
    private String name;
	@Column(name = "link")
    private String link;
	@Column(name = "link_big")
	private String linkBig;
	
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getLinkBig() {
		return linkBig;
	}

	public void setLinkBig(String linkBig) {
		this.linkBig = linkBig;
	}
}
