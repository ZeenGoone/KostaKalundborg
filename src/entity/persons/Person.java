package entity.persons;

public abstract class Person {
	protected String phonenumber;
	protected String name;
	
	public Person(String name, String phonenumber) { 
		this.name=name; 
		this.phonenumber=phonenumber; 
	}

	public String getPhonenumber() {return phonenumber;}
	public String getName() {return name;}
}
