package br.com.tulio.pizza_restaurant.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tulio.pizza_restaurant.exceptions.InvalidIngredientException;
import br.com.tulio.pizza_restaurant.model.entities.Ingredient;
import br.com.tulio.pizza_restaurant.model.enumerations.IngredientCategory;
import br.com.tulio.pizza_restaurant.model.repositories.IngredientRepository;

//	/app/ingredients (GET method) -> list ingredients
//	/app/ingredients (POST method) -> save ingredient

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
//	Use Spring repository to access data from the database
	@Autowired private IngredientRepository ingredientRepository;
	
//	REST APIs use methods instead of verbs
//	Spring makes the Model objects accessible, which can be used to send attributes to the views
	@RequestMapping(method = RequestMethod.GET)
	public String listIngredients(Model model) {
//		Iterable is similar to a List, the view knows how to handle it
		Iterable<Ingredient> ingredients = ingredientRepository.findAll();
		
//		Send data to the view using model object. Spring automatically inject attributes into the view
		model.addAttribute("title", "Ingredient Listing");
		model.addAttribute("ingredients", ingredients);
//		Send all enumeration options to the view
		model.addAttribute("categories", IngredientCategory.values());
		
//		View location and name: /WEB-INF/ingredient/listing.jsp
		return "ingredient/listing";
	}

	/* Using the @ModelAttribute annotation, the controller can access values from views
	 * Spring will look at the view for input tags with name attributes that match the desired entity class variable names
	 * If they match, Spring validates them and makes available in the current object
	 * Using @Valid annotation allows a better validation of values. If not, a database exception will be thrown (hibernate)
	 * The validation result will be by Spring into an object of BindingResult type
	 * Spring also allows access to previous attributes of view through the object of RedirectAttributes type*/
	@RequestMapping(method = RequestMethod.POST)
	public String saveIngredient(
			@Valid @ModelAttribute Ingredient ingredient,
			BindingResult bindingResult,
			Model model) {

//		Check for validation errors
		if (bindingResult.hasErrors()) {
//			If an error occurs, throw a custom exception.
			throw new InvalidIngredientException();
			
		} else {
//			Access validated inputs from view and save them into database
			ingredientRepository.save(ingredient);
		}
		
		model.addAttribute("ingredients", ingredientRepository.findAll());
		
//		Return only the table page with new data added (SPA), and not the entire page.
		return "/ingredient/table-ingredients";
	}
}
