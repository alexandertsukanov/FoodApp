package com.gda.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gda.ws.forms.FoodForm;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private FoodCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "food")
    private Collection<OrderFood> orderFoods;

    public Food() {
    }

    public Food(FoodForm form) {
        this.setId(form.getId());
        this.setCategory(form.getCategory());
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

        if (!id.equals(food.id)) return false;
        if (!title.equals(food.title)) return false;
        if (!description.equals(food.description)) return false;
        if (!calories.equals(food.calories)) return false;
        if (!ingredients.equals(food.ingredients)) return false;
        if (!weight.equals(food.weight)) return false;
        if (!price.equals(food.price)) return false;
        if (!imageLink.equals(food.imageLink)) return false;
        if (!category.equals(food.category)) return false;
        return orderFoods.equals(food.orderFoods);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (calories != null ? calories.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (imageLink != null ? imageLink.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", calories='" + calories + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", category=" + category +
                ", orderFoods=" + orderFoods +
                '}';
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
