package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.VegetarianPizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Joshua Serong
 * 
 */
public class PizzaFactoryTests {
	@Test (expected = PizzaException.class)
	public void invalidType() throws PizzaException{
		PizzaFactory.getPizza("PZH",2,LocalTime.of(21, 00, 00),LocalTime.of(21, 20, 00));
	}
	@Test (expected = PizzaException.class)
	public void delivredBeforeOrdered() throws PizzaException{
		PizzaFactory.getPizza("PZL",2,LocalTime.of(21, 00, 00),LocalTime.of(20, 00, 00));
	}
	@Test (expected = PizzaException.class)
	public void thrownOut() throws PizzaException{
		PizzaFactory.getPizza("PZL",2,LocalTime.of(21, 00, 00),LocalTime.of(23, 00, 00));
	}
	@Test (expected = PizzaException.class)
	public void deliveredToSoon() throws PizzaException{
		PizzaFactory.getPizza("PZL",2,LocalTime.of(21, 00, 00),LocalTime.of(21, 02, 00));
	}
	@Test (expected = PizzaException.class)
	public void qtyMore() throws PizzaException{
		PizzaFactory.getPizza("PZL",11,LocalTime.of(21, 00, 00),LocalTime.of(21, 20, 00));
	}
	@Test (expected = PizzaException.class)
	public void qtyLess() throws PizzaException{
		PizzaFactory.getPizza("PZL",0,LocalTime.of(21, 00, 00),LocalTime.of(21, 20, 00));
	}
	
	
}
