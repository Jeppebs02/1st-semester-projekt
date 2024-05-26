package control;

import model.Employee;
import model.LoginContainer;

public class LoginController {
	
	//Maybe not used, we dont know yet
	private Employee currentUser;

	public LoginController() {
		
	}
	
	public Employee getLoginUser() {
		LoginContainer lc = LoginContainer.getInstance();
		currentUser = lc.getLoginUser();
		return currentUser;
	}
	

}
