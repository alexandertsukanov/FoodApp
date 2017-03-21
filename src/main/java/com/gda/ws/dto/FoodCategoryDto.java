package com.gda.ws.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gda.ws.entity.Food;

import java.util.Collection;

public class FoodCategoryDto {

    private Long id;
    private String name;
    private String link;
	private String linkBig;

	@JsonIgnore
	private Collection<FoodDto> foods;

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

	public Collection<FoodDto> getFoods() {
		return foods;
	}

	public void setFoods(Collection<FoodDto> foods) {
		this.foods = foods;
	}
}
