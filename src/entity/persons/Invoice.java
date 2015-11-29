package entity.persons;

import java.util.ArrayList;
import java.util.Date;

import logic.DatabaseLogic;

public class Invoice {
	private ArrayList<Expense> payments;
	private Date start_date;
	private Date end_date;
	
	public Invoice(String start_date, String end_date) {
		this.start_date=convertDate(start_date);
		this.end_date=convertDate(end_date);
		payments = new ArrayList<Expense>();
	}
	public void registerExpense(String describtion, double price, int numberofitems) {
		payments.add(new Expense(describtion, price, numberofitems));
	}
	public void registerTenancyExpense(String describtion, double price_offseason, double price_highseason, int numberofitems) {
		double price = 0;
		double offseasondays = 0;
		double highseasondays = 0;
		String highseason_start = DatabaseLogic.getHighseasonStart();
		String highseason_end = DatabaseLogic.getHighseasonEnd();
		
		}
	
	public ArrayList<Expense> getPayments() {
		return payments;
	}
	public double getPrice(int index) {
		return payments.get(index).getPrice();
	}
	public String getDescribtion(int index) {
		return payments.get(index).getDescribtion();
	}
	public Date getStartdate() {
		return start_date;
	}
	public Date getEnddate() {
		return end_date;
	}
	private Date convertDate(String date) {
		String day = ""+date.indexOf(0)+date.indexOf(1);
		String  month = ""+date.indexOf(3)+date.indexOf(4);
		String year = ""+date.indexOf(6)+date.indexOf(7)+date.indexOf(8)+date.indexOf(9);
		return new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
	}
}
