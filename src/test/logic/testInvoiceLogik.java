package test.logic;

import static org.junit.Assert.*;
import logic.InvoiceLogic;

import org.junit.Test;

import entity.persons.Customer;

public class testInvoiceLogik {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		InvoiceLogic IL = new InvoiceLogic();
		Customer c = new Customer("Ulrik", "22330056");
		c.invoices.get(c.currentInvoice).registerExpense("Kamel", 200);
		c.invoices.get(c.currentInvoice).registerExpense("Frokost på altanen", 500);
		c.invoices.get(c.currentInvoice).registerExpense("Banan på sengen", 50);
		c.invoices.get(c.currentInvoice).registerExpense("BJ fra receptionist", 700);
		double price = 200+500+50+700.0;
		System.out.println(IL.getInvoice(c));
		assertEquals(price,IL.getTotal(c),0.0);
		
	}

}
