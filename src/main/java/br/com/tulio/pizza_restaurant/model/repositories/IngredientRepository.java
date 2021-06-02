package br.com.tulio.pizza_restaurant.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tulio.pizza_restaurant.model.entities.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{

}
