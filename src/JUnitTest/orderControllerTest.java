package JUnitTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import control.CustomerController;
import control.OrderController;
import control.ProductController;
import model.Order;
import model.Product;
import tui.TryMe;
public class orderControllerTest {

	private OrderController orderController;
	
	@Before
	public void setUp() throws Exception {
        orderController = new OrderController();
        ProductController productController = new ProductController();
        TryMe.addData();
        orderController.createOffer();
    }
	
	
	@Test
	public void saveOffer() {
		Product obj1 = orderController.inputProduct("99008800", 10);
		 
		assertTrue(orderController.saveOffer());
		
	}
	
//	@Test
//	public void inputProduct1() {
//		assertNotNull(orderController.inputProduct("99008800",10));
//	}
	
}
