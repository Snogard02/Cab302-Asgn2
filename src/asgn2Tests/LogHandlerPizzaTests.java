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
	@Test (expected = LogHandlerException.class)
	public void nonExistantFile() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("asdasdf");
	}
	//make a bunch of faulty log files to test whether PizzaExceptions get pased correctly
}
