package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final RecipeRepository recipeRepository;
	private final CategoryRepository categoryRepository;

	public RecipeBootstrap(UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository,
			CategoryRepository categoryRepository) {
		super();
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		recipeRepository.saveAll(getRecipes());
	}

	private List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();

		Optional<UnitOfMeasure> ounceUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("OUNCE");
		if (!ounceUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("OUNCE UOM not found");
		}

		Optional<UnitOfMeasure> tableSpoonUnitOfMeasureOptional = unitOfMeasureRepository
				.findByDescription("TABLE SPOON");
		if (!tableSpoonUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("TABLE SPOON not found");
		}
		Optional<UnitOfMeasure> teaSpoonUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("TEA SPOON");
		if (!teaSpoonUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("TEA SPOON not found");
		}
		Optional<UnitOfMeasure> dashUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("DASH");
		if (!dashUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("DASH UOM not found");
		}
		Optional<UnitOfMeasure> pinchUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("PINCH");
		if (!pinchUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("PINCH UOM not found");
		}

		Optional<UnitOfMeasure> cupUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("CUP");
		if (!cupUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("CUPS UOM not found");
		}

		Optional<UnitOfMeasure> eachUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("EACH");
		if (!eachUnitOfMeasureOptional.isPresent()) {
			throw new RuntimeException("EACH UOM not found");
		}

		UnitOfMeasure cupUnitOfMeasure = cupUnitOfMeasureOptional.get();
		UnitOfMeasure teaSpoonUnitOfMeasure = teaSpoonUnitOfMeasureOptional.get();
		UnitOfMeasure tableSpoonUnitOfMeasure = tableSpoonUnitOfMeasureOptional.get();
		UnitOfMeasure pinchUnitOfMeasure = pinchUnitOfMeasureOptional.get();
		UnitOfMeasure dashUnitOfMeasure = dashUnitOfMeasureOptional.get();
		UnitOfMeasure ounceUnitOfMeasure = ounceUnitOfMeasureOptional.get();
		UnitOfMeasure eachUnitOfMeasure = eachUnitOfMeasureOptional.get();

		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("AMERICAN");
		if (!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("AMERICAN category not found");
		}
		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("MEXICAN");
		if (!mexicanCategoryOptional.isPresent()) {
			throw new RuntimeException("MEXICAN category not found");
		}
		Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("ITALIAN");
		if (!italianCategoryOptional.isPresent()) {
			throw new RuntimeException("ITALIAN category not found");
		}
		Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("FAST FOOD");
		if (!fastFoodCategoryOptional.isPresent()) {
			throw new RuntimeException("FAST FOOD category not found");
		}

		Category americanCategory = americanCategoryOptional.get();
		Category mexicanCategory = mexicanCategoryOptional.get();
		Category italianCategory = italianCategoryOptional.get();
		Category fastFoodCategory = fastFoodCategoryOptional.get();

		// new guac recipe
		Recipe guacRecipe = new Recipe();
		guacRecipe.setDescription("Perfect Guacamole");
		guacRecipe.setCookTime(10);
		guacRecipe.setPrepTime(0);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections(
				"1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\r\n"
						+ "\r\n"
						+ "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\r\n"
						+ "\r\n"
						+ "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n"
						+ "\r\n"
						+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n"
						+ "\r\n"
						+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\r\n"
						+ "\r\n"
						+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\r\n"
						+ "\r\n"
						+ "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes(
				"Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\r\n"
						+ "\r\n"
						+ "The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\r\n"
						+ "\r\n" + "You can store the guacamole in the fridge this way for up to three days.\r\n"
						+ "\r\n"
						+ "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn’t very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.");
		
		guacNotes.setRecipe(guacRecipe);
		guacRecipe.setRecipeNotes(guacNotes);
		
		guacRecipe.getIngredients()
				.add(new Ingredient("Ripe avocados", new BigDecimal(2), eachUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("Teaspoon of salt", new BigDecimal(.5), teaSpoonUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("Fresh Lime Juice", new BigDecimal(2), tableSpoonUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("Red/Green onion", new BigDecimal(2), tableSpoonUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("No seed Serano Chilly", new BigDecimal(2), eachUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("Freshly grated black pepper", new BigDecimal(2), dashUnitOfMeasure, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("Ripe tomatoes", new BigDecimal(.5), eachUnitOfMeasure, guacRecipe));

		guacRecipe.getCategories().add(americanCategory);
		guacRecipe.getCategories().add(mexicanCategory);

		recipes.add(guacRecipe);

		return recipes;

	}

}
