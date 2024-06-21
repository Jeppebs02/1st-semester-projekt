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

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: Interatction Test in a JUnit frame. testing the 
//methods of the OrderController. 
public class OrderControllerTest {

	private OrderController orderController;
	
	
	@Before
	public void setUp() throws Exception {
        orderController = new OrderController();
        TryMe.addData();
        orderController.createOffer();
    }
	
	
	@Test
	public void saveOffer() {
		Product obj1 = orderController.inputProduct("99008800", 10);
		 
		assertTrue(orderController.saveOffer());
		
	}
	
	
}
