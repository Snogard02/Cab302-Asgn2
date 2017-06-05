package asgn2Tests;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Christopher Dare
 */
public class LogHandlerCustomerTests {
	@Test (expected = LogHandlerException.class)
	public void nonExistantFile() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer("asdasdf");
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_coords() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(".//logs/fileError_wrongFormat_coords.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_name() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(".//logs/fileError_wrongFormat_name.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_phone() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(".//logs/fileError_wrongFormat_phone.txt");
	}
	
}
