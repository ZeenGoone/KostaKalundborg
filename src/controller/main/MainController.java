package controller.main;

import java.util.ArrayList;

import entity.persons.CampChief;
import entity.persons.Customer;
import entity.persons.Receptionist;
import logic.DatabaseLogic;
import logic.LoginLogic;

public class MainController {
	static ArrayList<Customer> customerdb = DatabaseLogic.getCustomers();
	static ArrayList<Receptionist> receptionistdb = DatabaseLogic.getReceptionist();
	static ArrayList<CampChief> campchiefdb = DatabaseLogic.getCampChief();
	static LoginLogic login = new LoginLogic(campchiefdb, receptionistdb);
	
	public static void main(String[] args) {

		

	}

}
