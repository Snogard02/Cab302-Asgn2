package asgn2Tests;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	PizzaRestaurant testRestraunt;
	@Test
	public void full_test() throws PizzaException, LogHandlerException, CustomerException{
		testRestraunt = new PizzaRestaurant();
		testRestraunt.processLog("/home/josh/git/asgn2/logs/20170101.txt");
	}
}
