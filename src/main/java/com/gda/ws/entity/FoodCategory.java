package com.gda.ws.entity;

import javax.persistence.*;
import java.util.Collection;

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
	private Collection<Food> foodsById;

	@Id
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "link")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Basic
	@Column(name = "link_big")
	public String getLinkBig() {
		return linkBig;
	}

	public void setLinkBig(String linkBig) {
		this.linkBig = linkBig;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FoodCategory that = (FoodCategory) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (link != null ? !link.equals(that.link) : that.link != null) return false;
		if (linkBig != null ? !linkBig.equals(that.linkBig) : that.linkBig != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (link != null ? link.hashCode() : 0);
		result = 31 * result + (linkBig != null ? linkBig.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "foodCategoryByCategoryId")
	public Collection<Food> getFoodsById() {
		return foodsById;
	}

	public void setFoodsById(Collection<Food> foodsById) {
		this.foodsById = foodsById;
	}
}
