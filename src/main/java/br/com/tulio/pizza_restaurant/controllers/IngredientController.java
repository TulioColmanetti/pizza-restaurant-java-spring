package br.com.tulio.pizza_restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tulio.pizza_restaurant.model.entities.Ingredient;
import br.com.tulio.pizza_restaurant.model.repositories.IngredientRepository;

//	/app/ingredients (GET method) -> list ingredients
//	/app/ingredients (POST method) -> save ingredient

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
//	Use Spring repository to access data from the database
	@Autowired private IngredientRepository ingredientRepository;
	
//	REST APIs use methods instead of verbs
	@RequestMapping(method = RequestMethod.GET)
	public String listIngredients(Model model) {
//		Iterable is similar to a List, the view knows how to handle it
		Iterable<Ingredient> ingredients = ingredientRepository.findAll();
		
//		Send data to the view using model object. Spring automatically inject attributes into the view
		model.addAttribute("title", "Ingredient Listing");
		model.addAttribute("ingredients", ingredients);
		
//		View location and name: /WEB-INF/ingredient/listing.jsp
		return "ingredient/listing";
	}
}
