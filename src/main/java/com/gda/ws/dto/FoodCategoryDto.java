package com.gda.ws.dto;

import com.gda.ws.entity.Food;

import java.util.Collection;

public class FoodCategoryDto {

    private Long id;
    private String name;
    private String link;
	private String linkBig;
	private Collection<Food> foodsById;

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

	public Collection<Food> getFoodsById() {
		return foodsById;
	}

	public void setFoodsById(Collection<Food> foodsById) {
		this.foodsById = foodsById;
	}
}
