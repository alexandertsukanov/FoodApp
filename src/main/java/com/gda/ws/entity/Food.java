package com.gda.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "food", schema = "", catalog = "foodapp")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "category_id")
    private Long categoryId;
	@Column(name = "title")
    private String title;
	@Column(name = "description")
    private String description;
	@Column(name = "image_link")
    private String imageLink;
	@Column(name = "weight")
	private String weight;
	@Column(name = "ingredients")
	private String ingredients;
	@Column(name = "price")
	private String price;
	@Column(name = "calories")
	private String calories;

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

	@Override
	public String toString() {
		return "Food{" +
				"calories='" + calories + '\'' +
				", id=" + id +
				", categoryId=" + categoryId +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", imageLink='" + imageLink + '\'' +
				", weight='" + weight + '\'' +
				", ingredients='" + ingredients + '\'' +
				", price='" + price + '\'' +
				'}';
	}
}
