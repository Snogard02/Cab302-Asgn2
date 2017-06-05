package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Joshua Serong
 *
 */
public class RestaurantPizzaTests {
	PizzaRestaurant testRestraunt;
	@Test @Before
	public void setup(){
		testRestraunt = new PizzaRestaurant();
	}
	@Test (expected = LogHandlerException.class)
	public void noFile() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog("asdasdf");
	}
	@Test (expected = PizzaException.class)
	public void indexOutOfBounds() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.getPizzaByIndex(200);
	}
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_date() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog(".//logs/fileError_wrongFormat_date.txt");
	}
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_quantity() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog(".//logs/fileError_wrongFormat_quantity.txt");
	}
	@Test (expected = PizzaException.class)
	public void fileError_wrongFormat_pizzaCode() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog(".//logs/fileError_wrongFormat_pizzaCode.txt");
	}
	@Test (expected = PizzaException.class)
	public void pizzaError_deliveredBerforeMade() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog(".//logs/pizzaError_deliveredBerforeMade.txt");
	}
	@Test (expected = PizzaException.class)
	public void pizzaError_thrownOut() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog(".//logs/pizzaError_thrownOut.txt");
	}
	@Test (expected = PizzaException.class)
	public void returns_false() throws PizzaException, LogHandlerException, CustomerException{
		assertFalse(testRestraunt.processLog(".//logs/pizzaError_deliveredBerforeMade.txt"));
	}
}
