package model;

import java.util.ArrayList;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: LoginContainer holds the user that is logged into the system.
public class LoginContainer {
	
	private Employee loginUser;
	private ArrayList<Employee> employees;
	private static LoginContainer instance;

	private LoginContainer() {
		employees = new ArrayList<>();
		// insert potential employee stuff here
	}
	
	public static LoginContainer getInstance() {
		if (instance==null) {
			instance = new LoginContainer();
		}
		return instance;
	}
	
	public void setLoginUser(Employee user) throws IllegalArgumentException {
		if(user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		this.loginUser=user;
		
	}
	
	public Employee getLoginUser() throws NullPointerException {
		if(loginUser == null) {
			throw new NullPointerException("User is set to null");
		}
		return loginUser;
	}
	
	public void addNewEmployee(Employee e) {
		employees.add(e);
	}
	
	public boolean authenticateEmployee(String username, String password) {
        boolean res = false;
		
		for ( Employee emp : employees) {
            if (emp.getUsername().equals(username) && emp.authenticate(password)) {
                res = true;
            }
        }
        return res;
    }

}
