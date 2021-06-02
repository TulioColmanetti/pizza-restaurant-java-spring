package br.com.tulio.pizza_restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tulio.pizza_restaurant.model.repositories.PizzaRepository;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
//	Ask Spring to instantiate an object of type PizzaRepository and to inject it here 
	@Autowired private PizzaRepository pizzaRepository;

//	public PizzaController() {
//		System.out.println("Created pizza controller");
//	}
	
//	@RequestMapping("/hello/{name}")
//	@ResponseBody
//	public String hello(@PathVariable String name) {
//		return "Olá, " + name;
//	}
	
	/*
	 * Map url for this method, it will be added after class url mapping (e.g. /pizzas/quantity).
	 * Return a body response to the user. If not present, it will generate an error, 
	 * because Spring's default behavior is to look for a View with the same name as the returned value.
	 */
	@RequestMapping("/quantity")
	@ResponseBody
	public String quantityOfPizzas() {
		return "At this moment, there are "+pizzaRepository.count()+" registered!";
	}
}
