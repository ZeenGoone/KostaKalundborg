package controller.main;

import logic.DatabaseLogic;
import logic.LoginLogic;


public class MainController {
	DatabaseLogic dataLogic = new DatabaseLogic();
	LoginLogic loginLogic;
	
	public static void main(String[] args) {
		
		
		
	}
	
	private void createObjects() {
		loginLogic = new LoginLogic(dataLogic);
	}

}
