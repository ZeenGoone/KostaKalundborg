package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame{
	JPanel panel = new JPanel();
	JPanel panel_mainBottom = new JPanel();
	JPanel panel_mainTop = new JPanel();
	JPanel panel_caravanList = new JPanel();
	JPanel panel_tentList = new JPanel();
	JPanel panel_hutList = new JPanel();
	JPanel panel_luxuryhutList = new JPanel();
	JPanel panel_caravanField = new JPanel();
	JPanel panel_tentField = new JPanel();
	JPanel panel_hutField = new JPanel();
	JPanel panel_luxuryhutField = new JPanel();
	GridBagConstraints c = new GridBagConstraints();
	JTextField textfield_caravans = new JTextField("Campingvogne");
	JTextField textfield_tents = new JTextField("Telte");
	JTextField textfield_huts = new JTextField("Hytter");
	JTextField textfield_luxuryhuts = new JTextField("Luksus Hytter");
	ArrayList<JButton> caravanButtons;
	ArrayList<JButton> tentButtons;
	ArrayList<JButton> hutButtons;
	ArrayList<JButton> luxuryhutButtons;
	Font font_titles = new Font(Font.DIALOG, Font.BOLD, 20);
	Font font_buttons = new Font("Serif", Font.BOLD, 15);
	String color_caravan = "#208208";
	String color_tent = "#082082";
	String color_hut = "#820820";
	String color_luxuryhut = "#9b394c";
	
	
	JButton button1 = new JButton("Make Reservation");
	JButton button2 = new JButton("Print Invoice");
	JButton button_login = new JButton("Login");
	JTextArea invoicePrint;
	JTextField textfield_phonenumber = new JTextField("phonenumber");
	JTextField textfield_password = new JTextField("password");
	public GUI() {
		super("Kosta Kalundborg");
		setSize(1250, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setCaravanList(ArrayList<Integer> caravans) {
		panel_caravanList.setLayout(new GridLayout(caravans.size()/3,caravans.size()));
		caravanButtons = new ArrayList<JButton>();
		for (int index:caravans){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode(color_caravan));
			temp.setFont(font_buttons);
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			caravanButtons.add(temp);
			}
		for (JButton temp: caravanButtons){panel_caravanList.add(temp);}
	}
	public void setTentList(ArrayList<Integer> tents) {
		panel_tentList.setLayout(new GridLayout(tents.size()/3,tents.size()));
		tentButtons = new ArrayList<JButton>();
		for (int index:tents){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode(color_tent));
			temp.setFont(font_buttons);
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			tentButtons.add(temp);
			}
		for (JButton temp: tentButtons){panel_tentList.add(temp);}
	}
	public void setHutList(ArrayList<Integer> huts) {
		panel_hutList.setLayout(new GridLayout(huts.size()/3,huts.size()));
		hutButtons = new ArrayList<JButton>();
		for (int index:huts){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode(color_hut));
			temp.setFont(font_buttons);
			temp.setContentAreaFilled(false);
            temp.setOpaque(true);
			hutButtons.add(temp);
			}
		for (JButton temp: hutButtons){panel_hutList.add(temp);}
	}
	public void setLuxuryhutList(ArrayList<Integer> luxuryhuts) {
		panel_luxuryhutList.setLayout(new GridLayout(luxuryhuts.size()/3,luxuryhuts.size()));
		luxuryhutButtons = new ArrayList<JButton>();
		for (int index:luxuryhuts){ 
			JButton temp = new JButton(Integer.toString(index));
			temp.setBackground(Color.decode(color_luxuryhut));
			temp.setFont(font_buttons);
			temp.setContentAreaFilled(true);
            temp.setOpaque(true);
			luxuryhutButtons.add(temp);
			}
		for (JButton temp: luxuryhutButtons){panel_luxuryhutList.add(temp);}
	}
	public void finish() {
		panel_caravanField.add(panel_caravanList);
		panel_tentField.add(panel_tentList);
		panel_hutField.add(panel_hutList);
		panel_luxuryhutField.add(panel_luxuryhutList);
		panel_mainBottom.setAlignmentY(BOTTOM_ALIGNMENT);
		panel_mainBottom.setAlignmentX(CENTER_ALIGNMENT);
		panel_mainBottom.setLayout(new FlowLayout());
		panel_mainBottom.add(panel_caravanField);
		panel_mainBottom.add(panel_tentField);
		panel_mainBottom.add(panel_hutField);
		panel_mainBottom.add(panel_luxuryhutField);
		panel.setMaximumSize(new Dimension(1200, 700));
		panel_mainBottom.repaint();
		panel.add(panel_mainTop);
		panel.add(panel_mainBottom);
		add(panel);
		setVisible(true);
	}
	public void before() {
		textfield_caravans.setFont(font_titles);
		textfield_tents.setFont(font_titles);
		textfield_huts.setFont(font_titles);
		textfield_luxuryhuts.setFont(font_titles);
		textfield_caravans.setEditable(false);
		textfield_tents.setEditable(false);
		textfield_huts.setEditable(false);
		textfield_luxuryhuts.setEditable(false);
		panel_caravanField.setLayout(new BoxLayout(panel_caravanField, BoxLayout.Y_AXIS));
		panel_tentField.setLayout(new BoxLayout(panel_tentField, BoxLayout.Y_AXIS));
		panel_hutField.setLayout(new BoxLayout(panel_hutField, BoxLayout.Y_AXIS));
		panel_luxuryhutField.setLayout(new BoxLayout(panel_luxuryhutField, BoxLayout.Y_AXIS));
		panel_mainBottom.setBackground(Color.GRAY);
		panel_mainBottom.setOpaque(true);
		panel_caravanField.setAlignmentY(TOP_ALIGNMENT);
		panel_tentField.setAlignmentY(TOP_ALIGNMENT);
		panel_hutField.setAlignmentY(TOP_ALIGNMENT);
		panel_luxuryhutField.setAlignmentY(TOP_ALIGNMENT);
		panel_caravanField.add(textfield_caravans);
		panel_tentField.add(textfield_tents);
		panel_hutField.add(textfield_huts);
		panel_luxuryhutField.add(textfield_luxuryhuts);
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

