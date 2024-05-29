package JUnitTest;
import model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import control.*;
import tui.*;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: Interatction Test in a JUnit frame. testing the 
//methods of the EmployeeController. 
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
