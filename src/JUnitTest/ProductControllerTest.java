package JUnitTest;
import control.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import control.CustomerController;
import model.Product;
import tui.TryMe;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: Interatction Test in a JUnit frame. testing the methods 
//of the ProductController.
public class ProductControllerTest {

    private ProductController productController;

    @Before
    public void setUp() throws Exception {
        productController = new ProductController();
        TryMe.addData();
    }

    @Test 
    public void inputProduct() {
        
        assertNotNull(productController.inputProduct("12345678"));
    }
    
    @Test
    public void inputProductHammer() {
        
        assertEquals("Hammer", productController.inputProduct("12345678").getName());
    }
    
    @Test
    public void inputProductNonExistingBarcode() {
    	assertNull(productController.inputProduct("1111"));
    }
}

