package entity.persons;

public class Receptionist extends Employee {
	
	boolean administrator = false;
	
	public Receptionist(String name, String phonenumber, String password) {
		super (name, phonenumber, password);
	}
	public boolean getAdministrator(){
		return administrator;
	}
}
