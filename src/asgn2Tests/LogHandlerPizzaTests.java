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
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_date() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(".//logs/fileError_wrongFormat_date.txt");
	}
	@Test (expected = LogHandlerException.class)
	public void fileError_wrongFormat_quantity() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(".//logs/fileError_wrongFormat_quantity.txt");
	}
	@Test (expected = PizzaException.class)
	public void fileError_wrongFormat_pizzaCode() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(".//logs/fileError_wrongFormat_pizzaCode.txt");
	}
	@Test (expected = PizzaException.class)
	public void pizzaError_deliveredBerforeMade() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(".//logs/pizzaError_deliveredBerforeMade.txt");
	}
	@Test (expected = PizzaException.class)
	public void pizzaError_thrownOut() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(".//logs/pizzaError_thrownOut.txt");
	}
}
