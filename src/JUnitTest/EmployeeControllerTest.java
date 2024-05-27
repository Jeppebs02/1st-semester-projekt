package JUnitTest;
import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import control.*;
import tui.*;

public class EmployeeControllerTest {
	
	private LoginController loginController;

	
	  @Before
	    public void setUp() throws Exception {
	        loginController = new LoginController();
	        TryMe.addData();
	    }

	    @Test 
	    public void testloggedin() {
	        
	        assertNotNull(loginController.getLoginUser());
	    }
	    

}
