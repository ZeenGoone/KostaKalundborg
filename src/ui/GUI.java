package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.persons.Customer;
import logic.InvoiceLogic;

public class GUI extends JFrame{
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Make Reservation");
	JButton button2 = new JButton("Print Invoice");
	JButton button_login = new JButton("Login");
	JTextArea invoicePrint;
	JTextField textfield_phonenumber = new JTextField("phonenumber");
	JTextField textfield_password = new JTextField("password");
	public GUI() {
		super("Kosta Kalundborg");
		setSize(500,500);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// testInvoice();
		setViewLogin();
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	private void setViewLogin(){
		panel.setBackground(Color.WHITE);
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(300,200));
		panel_1.setBackground(Color.BLUE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Font font_italic = new Font("Serif", Font.ITALIC, 20);
		Font font_bold = new Font("Serif", Font.PLAIN, 30);
		textfield_phonenumber.setFont(font_italic);
		textfield_password.setFont(font_italic);
		button_login.setFont(font_bold);
		textfield_phonenumber.setColumns(20);
		textfield_password.setColumns(20);
		textfield_phonenumber.setAlignmentX(CENTER_ALIGNMENT);
		textfield_password.setAlignmentX(CENTER_ALIGNMENT);
		button_login.setAlignmentX(CENTER_ALIGNMENT);
		panel_1.add(textfield_phonenumber);
		panel_1.add(textfield_password);
		panel_1.add(button_login);
		panel.add(panel_1);
	}
	
	private void testInvoice() {
		// skal slettes
		panel.add(button1);
		panel.add(button2);
		panel.add(invoicePrint);
		InvoiceLogic IL = new InvoiceLogic();
		Customer c = new Customer("Ulrik", "22330056");
		c.invoices.get(c.currentInvoice).registerExpense("Kamel", 200);
		c.invoices.get(c.currentInvoice).registerExpense("Frokost på altanen", 500);
		c.invoices.get(c.currentInvoice).registerExpense("Banan på sengen", 50);
		c.invoices.get(c.currentInvoice).registerExpense("BJ fra receptionist", 700);
		invoicePrint = new JTextArea(IL.getInvoice(c));
	}
}

