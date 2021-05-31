package br.com.tulio.pizza_restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@RequestMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable String name) {
		return "Olá, " + name;
	}
}
