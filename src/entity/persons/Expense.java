package entity.persons;

public class Expense {
	private String describtion;
	private double price;
	private int numberofitems;
	
	public Expense(String describtion, double price, int numberofitems) {
		this.describtion=describtion;
		this.price=price;
		this.numberofitems=numberofitems;
	}
	public String toString() {
		return describtion+": "+price;
	}
	public String getDescribtion() {
		return describtion;
	}
	public double getPrice() {
		return price;
	}
	public int getNumberofitems() {
		return numberofitems;
	}
	

}
