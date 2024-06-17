package control;

import model.Employee;
import model.LoginContainer;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the LoginController, 
//enabling userinput from the TUI level to interact with the modellayer, 
//without compromising the architecture. 
public class LoginController {
	
	
	private Employee currentUser;

	public LoginController() {
		
	}
	
	public Employee getLoginUser() {
		LoginContainer lc = LoginContainer.getInstance();
		currentUser = lc.getLoginUser();
		return currentUser;
	}
	
	public void setLoginUser(Employee e) {
		LoginContainer lc = LoginContainer.getInstance();
		lc.setLoginUser(e);
	}
	
	 public boolean authenticateEmployee(String username, String password) {
		 LoginContainer lc = LoginContainer.getInstance();
		 return lc.authenticateEmployee(username, password);
		 
	 }
	
	
	
}
