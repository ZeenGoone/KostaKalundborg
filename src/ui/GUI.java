package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.persons.Customer;
import logic.InvoiceLogic;

public class GUI extends JFrame{
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Make Reservation");
	JButton button2 = new JButton("Print Invoice");
	JTextArea invoicePrint;
	public GUI() {
		super("Kosta Kalundborg");
		setSize(400,400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.add(button1);
		panel.add(button2);
		testInvoice();
		panel.add(invoicePrint);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	private void testInvoice() {
		// skal slettes
		InvoiceLogic IL = new InvoiceLogic();
		Customer c = new Customer("Ulrik", "22330056");
		c.invoices.get(c.currentInvoice).registerExpense("Kamel", 200);
		c.invoices.get(c.currentInvoice).registerExpense("Frokost på altanen", 500);
		c.invoices.get(c.currentInvoice).registerExpense("Banan på sengen", 50);
		c.invoices.get(c.currentInvoice).registerExpense("BJ fra receptionist", 700);
		invoicePrint = new JTextArea(IL.getInvoice(c));
	}
}

