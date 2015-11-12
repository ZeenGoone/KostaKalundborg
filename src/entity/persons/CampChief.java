package entity.persons;

public class CampChief extends Employee {
	boolean administrator = true;
	
	public CampChief(String name, String phonenumber, String password, boolean administrator) {
		super(name, phonenumber, password);
		this.administrator = administrator;
	}
	public boolean getAdministrator(){
		return administrator;
	}

}
