package asgn2Tests;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Christopher Dare
 */
public class RestaurantCustomerTests {
	PizzaRestaurant testRestraunt;
	
	@Test @Before
	public void setup(){
		testRestraunt = new PizzaRestaurant();
	}
	
	@Test (expected = LogHandlerException.class)
	public void noFile() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog("asdasdf");
	}
	
	@Test (expected = CustomerException.class)
	public void indexOutOfBounds() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.getCustomerByIndex(10);
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_name() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt.processLog(".//logs/fileError_wrongFormat_name.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_coords() throws PizzaException, CustomerException, LogHandlerException{
		testRestraunt.processLog(".//logs/fileError_wrongFormat_coords.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_phone() throws PizzaException, CustomerException, LogHandlerException{
		testRestraunt.processLog(".//logs/fileError_wrongFormat_phone.txt");
	}
	
	
}
