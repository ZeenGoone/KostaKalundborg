package entity.persons;

public class CampChief extends Employee {
	boolean administrator = true;
	
	CampChief(String name, String phonenumber, String password) {
		super(name, phonenumber, password);
	}
	public boolean getAdministrator(){
		return administrator;
	}

}
