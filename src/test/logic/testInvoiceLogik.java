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
		c.getInvoice().registerExpense("Kamel", 200);
		c.getInvoice().registerExpense("Kamel Frokost på altanen", 500);
		c.getInvoice().registerExpense("Banan på sengen", 50);
		c.getInvoice().registerExpense("Kabel TV", 700);
		double price = 200+500+50+700.0;
		System.out.println(IL.getInvoice(c));
		assertEquals(price,IL.getTotal(c),0.0);
		
	}

}
