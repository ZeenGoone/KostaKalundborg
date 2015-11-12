package entity.persons;

public class Employee extends Person{

	public String password;
	
	Employee (String name, String phonenumber, String password){
		super(phonenumber, name);
		this.password=password;
	}
	
}
