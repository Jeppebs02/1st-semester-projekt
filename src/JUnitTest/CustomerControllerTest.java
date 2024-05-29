package JUnitTest;
import control.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import control.CustomerController;
import model.Customer;
import model.Product;
import tui.TryMe;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: Interatction Test in a JUnit frame. testing the methods 
//of the CustomerController.
public class CustomerControllerTest {

    private CustomerController customerController;

    @Before
    public void setUp() throws Exception {
        customerController = new CustomerController();
        TryMe.addData();
    }

    @Test 
    public void inputCustomerID() {
        
        assertNotNull(customerController.inputCustomerID("22112233"));
    }
    
    @Test
    public void inputCustomerID1() {
        
        assertEquals("Average Joe", customerController.inputCustomerID("44556677").getName());
    }
    
    @Test
    public void inputCustomerNonExistingCustomerID() {
    	assertNull(customerController.inputCustomerID("1111"));
    }
}

