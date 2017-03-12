package com.gda.ws.entity;

import com.gda.ws.forms.FoodForm;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Food {
    private Long id;
    private Long categoryId;
    private String title;
    private String description;
    private String calories;
    private String ingredients;
    private String weight;
    private String price;
    private String imageLink;
    private FoodCategory foodCategoryByCategoryId;
    private Collection<OrderFood> orderFoodsById;

    public Food() {
    }

    public Food(FoodForm form) {
        this.setCategoryId(form.getCategoryId());
        this.setTitle(form.getTitle());
        this.setDescription(form.getDescription());
        this.setCalories(form.getCalories());
        this.setIngredients(form.getIngredients());
        this.setWeight(form.getWeight());
        this.setPrice(form.getPrice());
        this.setImageLink(form.getImageLink());
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "calories")
    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    @Basic
    @Column(name = "ingredients")
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Basic
    @Column(name = "weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "image_link")
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (id != null ? !id.equals(this.id) : this.id != null) return false;
        if (categoryId != null ? !categoryId.equals(this.categoryId) : this.categoryId != null) return false;
        if (title != null ? !title.equals(this.title) : this.title != null) return false;
        if (description != null ? !description.equals(this.description) : this.description != null) return false;
        if (calories != null ? !calories.equals(this.calories) : this.calories != null) return false;
        if (ingredients != null ? !ingredients.equals(this.ingredients) : this.ingredients != null) return false;
        if (weight != null ? !weight.equals(this.weight) : this.weight != null) return false;
        if (price != null ? !price.equals(this.price) : this.price != null) return false;
        if (imageLink != null ? !imageLink.equals(this.imageLink) : this.imageLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (calories != null ? calories.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (imageLink != null ? imageLink.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public FoodCategory getFoodCategoryByCategoryId() {
        return foodCategoryByCategoryId;
    }

    public void setFoodCategoryByCategoryId(FoodCategory foodCategoryByCategoryId) {
        this.foodCategoryByCategoryId = foodCategoryByCategoryId;
    }

    @OneToMany(mappedBy = "foodByFoodId")
    public Collection<OrderFood> getOrderFoodsById() {
        return orderFoodsById;
    }

    public void setOrderFoodsById(Collection<OrderFood> orderFoodsById) {
        this.orderFoodsById = orderFoodsById;
    }
}
