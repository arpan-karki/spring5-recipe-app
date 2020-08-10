package guru.springframework.domain;

import java.util.Set;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return description;
	}

	public void setCategoryName(String categoryName) {
		this.description = categoryName;
	}

	public Set<Recipe> getRecipies() {
		return recipes;
	}

	public void setRecipies(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

}
