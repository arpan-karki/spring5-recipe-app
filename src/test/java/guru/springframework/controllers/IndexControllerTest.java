package guru.springframework.controllers;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
import guru.springframework.service.RecipeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IndexControllerTest {

	IndexController indexController;
	MockMvc mockMvc;

	@Mock
	RecipeService recipeService;

	@Mock
	Model model;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
		this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

	}

	@Test
	public void testGetIndexPage() {

		// given
		HashSet recipes = new HashSet();
		recipes.add(new Recipe());
		Recipe recipe = new Recipe();
		recipe.setId(2L);
		recipes.add(recipe);

		Mockito.when(recipeService.getRecipes()).thenReturn(recipes);
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// when
		String viewName = indexController.getIndexPage(model);

		// then
		assertEquals("index", viewName);
		Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
		Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());

	}

	@Test
	public void testMockMVC() throws Exception{
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
		
	}

}
