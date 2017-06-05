package asgn2Tests;
import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.CustomerException;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Customers.DroneDeliveryCustomer;
/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Christopher Dare
 */
public class CustomerFactoryTests {
	
	// CustomerFactory Exception
	@Test (expected = CustomerException.class)
	public void IncorrectCode() throws CustomerException{
		CustomerFactory.getCustomer("aaa","a","0123456789",5,5);
	}
	
	
	// Customer Exceptions being passed
	// This shows that the different exceptions are being passed up as expected
	
	@Test (expected = CustomerException.class)
	public void PhoneGreaterThan10() throws CustomerException{
		CustomerFactory.getCustomer("PUC","a","01234567899",5,5);
	}
	
	@Test (expected = CustomerException.class)
	public void YTooLow() throws CustomerException{
		CustomerFactory.getCustomer("PUC","a","0123456789",5,-50);
	}
	
	@Test (expected = CustomerException.class)
	public void NameOnlyWhitespace() throws CustomerException{
		CustomerFactory.getCustomer("PUC","   ","0123456789",5,5);
	}
}
