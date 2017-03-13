package com.gda.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gda.ws.forms.FoodForm;

import javax.persistence.*;

@Entity
@Table(name = "food", schema = "", catalog = "foodapp")
public class Food {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "calories")
    private String calories;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "weight")
    private String weight;

    @Column(name = "price")
    private String price;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private FoodCategory foodCategoryByCategoryId;

    public Food() {
    }

    public Food(FoodForm form) {
        this.setId(form.getId());
        this.setCategoryId(form.getCategoryId());
        this.setTitle(form.getTitle());
        this.setDescription(form.getDescription());
        this.setCalories(form.getCalories());
        this.setIngredients(form.getIngredients());
        this.setWeight(form.getWeight());
        this.setPrice(form.getPrice());
        this.setImageLink(form.getImageLink());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


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

    public FoodCategory getFoodCategoryByCategoryId() {
        return foodCategoryByCategoryId;
    }

    public void setFoodCategoryByCategoryId(FoodCategory foodCategoryByCategoryId) {
        this.foodCategoryByCategoryId = foodCategoryByCategoryId;
    }
}
