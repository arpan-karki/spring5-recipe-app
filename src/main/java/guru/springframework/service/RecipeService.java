package guru.springframework.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;

public interface RecipeService {

	public Set<Recipe> getRecipes();
	public Recipe findById(Long l);
}
