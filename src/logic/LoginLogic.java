package logic;
import java.util.ArrayList;

import entity.persons.CampChief;
import entity.persons.Employee;
import entity.persons.Receptionist;

public class LoginLogic {
	private DatabaseLogic dataLogic;		
	public LoginLogic(DatabaseLogic dataLogic){
		this.dataLogic=dataLogic;
	}

	public Employee verifyUser(Employee client){
		boolean output = false;
		for (Employee e:dataLogic.employeeBase){
			if (client.getPhonenumber().equals(e.getPhonenumber()) && client.getPassword().equals(e.getPassword())) return e;
		}
		return null;
	}
}
