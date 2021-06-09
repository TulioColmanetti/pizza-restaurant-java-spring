package br.com.tulio.pizza_restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

	/* Using @ResponseStatus, when this class is called, a BAD_REQUEST will be send to the user.
	 * It means that an error occurred */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidIngredientException extends RuntimeException {

//	Just to eliminate warning about no serial created
	private static final long serialVersionUID = -7156491907250892920L;

}
