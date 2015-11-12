package test.logic;

import static org.junit.Assert.*;
import logic.InvoiceLogic;

import org.junit.Test;

import entity.persons.Customer;

public class testInvoiceLogik {

	@Test
	public void test() {
		InvoiceLogic IL = new InvoiceLogic();
		Customer c = new Customer("Ulrik", "22330056");
		
		
	}

}
