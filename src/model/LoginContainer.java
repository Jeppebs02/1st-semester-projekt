package model;

public class LoginContainer {
	
	private Employee loginUser;
	private static LoginContainer instance;

	private LoginContainer() {
		
		// insert potential employee stuff here
	}
	
	public static LoginContainer getInstance() {
		if (instance==null) {
			instance = new LoginContainer();
		}
		return instance;
	}
	
	public void setLoginUser(Employee user) {
		if(user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		this.loginUser=user;
		
	}
	
	public Employee getLoginUser() {
		return loginUser;
	}
	
	

}
