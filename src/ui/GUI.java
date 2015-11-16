package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.persons.Customer;
import logic.DatabaseLogic;
import logic.InvoiceLogic;

public class GUI extends JFrame{
	JPanel panel = new JPanel();
	JPanel panel_main1 = new JPanel();
	JPanel panel_main2 = new JPanel();
	ArrayList<JButton> tenancyButtons;
	
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
	}
	public static void main(String[] args) {
		new GUI();
	}
	public void setViewLogin(){
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
	
	public void setViewMain(ArrayList<Integer> caravans, ArrayList<Integer> tents , 
			ArrayList<Integer> huts, ArrayList<Integer> luxuryhuts ) {
		panel_main1.setBackground(Color.WHITE);
		int largestAmmount = 0;
		int[] emptyButtonsAmmount = new int[4];
		if (caravans.size()>largestAmmount) largestAmmount=caravans.size();
		if (tents.size()>largestAmmount) largestAmmount=tents.size();
		if (huts.size()>largestAmmount) largestAmmount=huts.size();
		if (luxuryhuts.size()>largestAmmount) largestAmmount=luxuryhuts.size();
//		emptyButtonsAmmount[0] = largestAmmount - caravans.size();
//		emptyButtonsAmmount[1] = largestAmmount - tents.size();
//		emptyButtonsAmmount[2] = largestAmmount - huts.size();
//		emptyButtonsAmmount[3] = largestAmmount - luxuryhuts.size();
		panel_main2.setLayout(new GridLayout(largestAmmount, 4));
		tenancyButtons = new ArrayList<JButton>();
		for (int temp: caravans){ tenancyButtons.add(new JButton(""+temp));}
		for (int temp: tents){ tenancyButtons.add(new JButton(""+temp));}
		for (int temp: huts){ tenancyButtons.add(new JButton(""+temp));}
		for (int temp: luxuryhuts){ tenancyButtons.add(new JButton(""+temp));}
		for (JButton temp: tenancyButtons) {panel_main2.add(temp); }
		panel_main1.add(panel_main2);
		add(panel_main1);
		setVisible(true);
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

