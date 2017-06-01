package asgn2Tests;
import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	@Test
	public void full_test() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("/home/josh/git/asgn2/logs/20170101.txt");
	}
}
