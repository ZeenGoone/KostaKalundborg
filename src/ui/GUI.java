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
	JPanel panel_caravanList = new JPanel();
	JPanel panel_tentList = new JPanel();
	JPanel panel_hutList = new JPanel();
	JPanel panel_luxuryhutList = new JPanel();
	ArrayList<JButton> caravanButtons;
	ArrayList<JButton> tentButtons;
	ArrayList<JButton> hutButtons;
	ArrayList<JButton> luxuryhutButtons;
	
	JButton button1 = new JButton("Make Reservation");
	JButton button2 = new JButton("Print Invoice");
	JButton button_login = new JButton("Login");
	JTextArea invoicePrint;
	JTextField textfield_phonenumber = new JTextField("phonenumber");
	JTextField textfield_password = new JTextField("password");
	public GUI() {
		super("Kosta Kalundborg");
		setSize(1000,700);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setCaravanList(ArrayList<Integer> caravans) {
		panel_caravanList.setLayout(new GridLayout(caravans.size(),1));
		caravanButtons = new ArrayList<JButton>();
		for (int index:caravans){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode("#208208"));
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			caravanButtons.add(temp);
			}
		for (JButton temp: caravanButtons){panel_caravanList.add(temp);}
	}
	public void setTentList(ArrayList<Integer> tents) {
		panel_tentList.setLayout(new GridLayout(tents.size(),1));
		tentButtons = new ArrayList<JButton>();
		for (int index:tents){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode("#082082"));
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			tentButtons.add(temp);
			}
		for (JButton temp: tentButtons){panel_tentList.add(temp);}
	}
	public void setHutList(ArrayList<Integer> huts) {
		panel_hutList.setLayout(new GridLayout(huts.size(),1));
		hutButtons = new ArrayList<JButton>();
		for (int index:huts){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode("#820820"));
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			hutButtons.add(temp);
			}
		for (JButton temp: hutButtons){panel_hutList.add(temp);}
	}
	public void setLuxuryhutList(ArrayList<Integer> luxuryhuts) {
		panel_luxuryhutList.setLayout(new GridLayout(luxuryhuts.size(),1));
		luxuryhutButtons = new ArrayList<JButton>();
		for (int index:luxuryhuts){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode("#9b394c"));
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			luxuryhutButtons.add(temp);
			}
		for (JButton temp: luxuryhutButtons){panel_luxuryhutList.add(temp);}
	}
	public void finish() {
		panel_main1.add(panel_caravanList);
		panel_main1.add(panel_tentList);
		panel_main1.add(panel_hutList);
		panel_main1.add(panel_luxuryhutList);
		add(panel_main1);
		setVisible(true);
	}
	
//	public void setViewLogin(){
//		panel.setBackground(Color.WHITE);
//		JPanel panel_1 = new JPanel();
//		panel_1.setMaximumSize(new Dimension(300,200));
//		panel_1.setBackground(Color.BLUE);
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		Font font_italic = new Font("Serif", Font.ITALIC, 20);
//		Font font_bold = new Font("Serif", Font.PLAIN, 30);
//		textfield_phonenumber.setFont(font_italic);
//		textfield_password.setFont(font_italic);
//		button_login.setFont(font_bold);
//		textfield_phonenumber.setColumns(20);
//		textfield_password.setColumns(20);
//		textfield_phonenumber.setAlignmentX(CENTER_ALIGNMENT);
//		textfield_password.setAlignmentX(CENTER_ALIGNMENT);
//		button_login.setAlignmentX(CENTER_ALIGNMENT);
//		panel_1.add(textfield_phonenumber);
//		panel_1.add(textfield_password);
//		panel_1.add(button_login);
//		panel.add(panel_1);
//		setVisible(true);
//	}
//	
//	public void setViewMain(ArrayList<Integer> caravans, ArrayList<Integer> tents , 
//			ArrayList<Integer> huts, ArrayList<Integer> luxuryhuts ) {
//		panel_main1.setBackground(Color.WHITE);
//		int largestAmmount = 0;
//		int[] emptyButtonsAmmount = new int[4];
//		if (caravans.size()>largestAmmount) largestAmmount=caravans.size();
//		if (tents.size()>largestAmmount) largestAmmount=tents.size();
//		if (huts.size()>largestAmmount) largestAmmount=huts.size();
//		if (luxuryhuts.size()>largestAmmount) largestAmmount=luxuryhuts.size();
////		emptyButtonsAmmount[0] = largestAmmount - caravans.size();
////		emptyButtonsAmmount[1] = largestAmmount - tents.size();
////		emptyButtonsAmmount[2] = largestAmmount - huts.size();
////		emptyButtonsAmmount[3] = largestAmmount - luxuryhuts.size();
//		panel_main2.setLayout(new GridLayout(largestAmmount, 4));
//		tenancyButtons = new ArrayList<JButton>();
//		for (int temp: caravans){ tenancyButtons.add(new JButton(""+temp).setBackground(Color.GREEN));}
//		for (int temp: tents){ tenancyButtons.add(new JButton(""+temp).setBackground(Color.BLUE));}
//		for (int temp: huts){ tenancyButtons.add(new JButton(""+temp).setBackground(Color.RED)));}
//		for (int temp: luxuryhuts){ tenancyButtons.add(new JButton(""+temp)).setBackground(Color.GREEN));}
//		for (JButton temp: tenancyButtons) { panel_main2.add(temp); }
//		panel_main1.add(panel_main2);
//		add(panel_main1);
//		setVisible(true);
//	}
//	
//	private void testInvoice() {
//		// skal slettes
//		panel.add(button1);
//		panel.add(button2);
//		panel.add(invoicePrint);
//		InvoiceLogic IL = new InvoiceLogic();
//		Customer c = new Customer("Ulrik", "22330056");
//		c.invoices.get(c.currentInvoice).registerExpense("Kamel", 200);
//		c.invoices.get(c.currentInvoice).registerExpense("Frokost på altanen", 500);
//		c.invoices.get(c.currentInvoice).registerExpense("Banan på sengen", 50);
//		c.invoices.get(c.currentInvoice).registerExpense("BJ fra receptionist", 700);
//		invoicePrint = new JTextArea(IL.getInvoice(c));
//	}
}

