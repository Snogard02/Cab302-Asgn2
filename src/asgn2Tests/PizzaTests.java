package asgn2Tests;
import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;
/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Joshua Serong
 *
 */
public class PizzaTests {
	VegetarianPizza testPizza;
	@Test (expected = PizzaException.class)
	public void quantity_greater() throws PizzaException{
		testPizza = new VegetarianPizza(11,LocalTime.of(19, 00, 00),LocalTime.of(19, 20, 00));
	}
	@Test (expected = PizzaException.class)
	public void quantity_less() throws PizzaException{
		testPizza = new VegetarianPizza(0,LocalTime.of(19, 00, 00),LocalTime.of(19, 20, 00));
	}
	@Test (expected = PizzaException.class)
	public void time_early() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(6, 00, 00),LocalTime.of(6, 20, 00));
	}
	@Test (expected = PizzaException.class)
	public void time_late() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(23, 10, 00),LocalTime.of(23, 30, 00));
	}
	@Test (expected = PizzaException.class)
	public void not_ready() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(21, 00, 00),LocalTime.of(21, 05, 00));
	}
	@Test (expected = PizzaException.class)
	public void thrown_out() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(21, 10, 00),LocalTime.of(23, 30, 00));
	}
	@Test (expected = PizzaException.class)
	public void deliver_before_order() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(21, 10, 00),LocalTime.of(21, 00, 00));
	}
	
	@Test
	public void containsTopping() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(21, 10, 00),LocalTime.of(21, 40, 00));
		assertTrue(testPizza.containsTopping(PizzaTopping.CHEESE));
	}
	@Test
	public void  getCost() throws PizzaException{
		testPizza = new VegetarianPizza(1,LocalTime.of(21, 10, 00),LocalTime.of(21, 40, 00));
		assertTrue(testPizza.getCostPerPizza() == 5.5);
	}

}
