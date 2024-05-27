package JUnitTest;
import control.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import control.CustomerController;
import model.Product;
import tui.TryMe;

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

