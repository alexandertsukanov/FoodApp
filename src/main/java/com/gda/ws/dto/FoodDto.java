package com.gda.ws.dto;

import com.gda.ws.entity.FoodCategory;
import com.gda.ws.entity.OrderFood;

import java.util.Collection;

public class FoodDto {

    private Long id;

    private String title;

    private String description;

    private String imageLink;

    private String weight;

    private String ingredients;

    private String price;

    private String calories;

    private FoodCategory category;

    private Collection<OrderFood> orderFoods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    public Collection<OrderFood> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(Collection<OrderFood> orderFoods) {
        this.orderFoods = orderFoods;
    }
}
