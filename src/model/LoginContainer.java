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
	
	

}
