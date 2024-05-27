package JUnitTest;
import control.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import control.CustomerController;
import model.Customer;
import model.Product;
import tui.TryMe;

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

