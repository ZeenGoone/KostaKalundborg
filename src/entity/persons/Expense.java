package entity.persons;

public class Expense {
	private String describtion;
	private double price;
	
	public Expense(String describtion, double price) {
		this.describtion=describtion;
		this.price=price;
	}
	public String toString() {
		return describtion+": "+price;
	}

}
