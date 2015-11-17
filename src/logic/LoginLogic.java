package logic;
import java.util.ArrayList;

import entity.persons.CampChief;
import entity.persons.Employee;
import entity.persons.Receptionist;

public class LoginLogic {
	private ArrayList<Receptionist> receptionistlist = new ArrayList<Receptionist>();
	private ArrayList<CampChief> campchieflist = new ArrayList<CampChief>();

	public LoginLogic(ArrayList<CampChief> campchieflist, ArrayList<Receptionist> receptionistlist){
		this.campchieflist = campchieflist;
		this.receptionistlist = receptionistlist;
	}

	public Employee verifyUser(String phonenumber, String password){

		for(Receptionist r : receptionistlist){
			if(phonenumber == r.getPhonenumber() && password == r.getPassword())
				return r;
		}
		for(CampChief c : campchieflist){
			if(phonenumber == c.getPhonenumber() && password == c.getPassword()){
				return c;
			}
		}
		return null;
	}
}
