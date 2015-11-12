package entity.persons;

public abstract class Employee extends Person{

	public String password;
	
	Employee (String name, String phonenumber, String password){
		super(phonenumber, name);
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
