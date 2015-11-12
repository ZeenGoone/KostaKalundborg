package entity.persons;

import java.util.ArrayList;

public class Invoice {
	public ArrayList<Expense> payments;
	public Invoice(){ payments = new ArrayList<Expense>();}
	
	public void registerExpense(String describtion, double price) {
		payments.add(new Expense(describtion, price));
	}
	public double getPrice(int index) {
		return payments.get(index).getPrice();
	}
	public String getDescribtion(int index) {
		return payments.get(index).getDescribtion();
	}
}
