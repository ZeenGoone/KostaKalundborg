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
		c.invoices.get(c.currentInvoice).registerExpense("Kamel", 200);
		c.invoices.get(c.currentInvoice).registerExpense("Frokost på altanen", 200);
		c.invoices.get(c.currentInvoice).registerExpense("Frokost på altanen", 500);
		
	}

}
