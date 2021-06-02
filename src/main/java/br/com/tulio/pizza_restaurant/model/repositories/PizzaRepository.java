package br.com.tulio.pizza_restaurant.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tulio.pizza_restaurant.model.entities.Pizza;

//	Needs to be an interface, because it does not demands implementation, only method declarations
//	Extending CrudRepository to use standard query methods. If need others, they could be implemented in this interface
@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long>{

}
