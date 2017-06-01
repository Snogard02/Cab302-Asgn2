package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.VegetarianPizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	@Test (expected = PizzaException.class)
	public void invalidType() throws PizzaException{
		PizzaFactory.getPizza("PZH",2,LocalTime.of(21, 00, 00),LocalTime.of(21, 20, 00));
	}
}
