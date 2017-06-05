package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.CustomerException;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Customers.DroneDeliveryCustomer;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Christopher Dare 
 *
 */
public class CustomerTests {
	Customer testCustomer;
	
	
	// Name Exceptions
	
	@Test (expected = CustomerException.class)
	public void NameTooShort() throws CustomerException{
		testCustomer = new PickUpCustomer("","0123456789",5,5);
	}
	
	@Test (expected = CustomerException.class)
	public void NameTooLong() throws CustomerException{
		testCustomer = new PickUpCustomer("aaaaaaaaaaaaaaaaaaaaa","0123456789",5,5);
	}
	
	@Test (expected = CustomerException.class)
	public void NameOnlyWhitespace() throws CustomerException{
		testCustomer = new PickUpCustomer("   ","0123456789",5,5);
	}
	
	
	// Location Exceptions
	
	@Test (expected = CustomerException.class)
	public void XTooHigh() throws CustomerException{
		testCustomer = new PickUpCustomer("a","0123456789",50,5);
	}
	@Test (expected = CustomerException.class)
	public void XToLow() throws CustomerException{
		testCustomer = new PickUpCustomer("a","0123456789",-50,5);
	}
	@Test (expected = CustomerException.class)
	public void YTooHigh() throws CustomerException{
		testCustomer = new PickUpCustomer("a","0123456789",5,50);
	}
	
	@Test (expected = CustomerException.class)
	public void YTooLow() throws CustomerException{
		testCustomer = new PickUpCustomer("a","0123456789",5,-50);
	}
	
	
	// MobileNumber Exceptions
	
	@Test (expected = CustomerException.class)
	public void GreaterThan10() throws CustomerException{
		testCustomer = new PickUpCustomer("a","01234567899",5,5);
	}
	
	public void LessThan10() throws CustomerException{
		testCustomer = new PickUpCustomer("a","012345678",5,5);
	}
	
	public void NoLeadingZero() throws CustomerException{
		testCustomer = new PickUpCustomer("a","1123456789",5,5);
	}
}
