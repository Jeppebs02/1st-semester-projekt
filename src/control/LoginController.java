package control;

import model.Employee;
import model.LoginContainer;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the LoginController, 
//enabling userinput from the TUI level to interact with the modellayer, 
//without compromising the architecture. 
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
