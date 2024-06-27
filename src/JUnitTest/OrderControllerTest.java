package JUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import control.CustomerController;
import control.OrderController;
import control.ProductController;
import model.Order;
import model.OrderContainer;
import model.Product;
import tui.TryMe;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: Interatction Test in a JUnit frame. testing the 
//methods of the OrderController. 
public class OrderControllerTest {

	private OrderController orderController;
	private Order currentOffer;
	private String orderNr;
	
	@Before
	public void setUp() throws Exception {
        orderController = new OrderController();
        TryMe.addData();
        currentOffer = orderController.createOffer();
        orderNr = orderController.generateOrderNr();
    }
	
	
	@Test
	public void saveOffer() {
//		Product obj1 = orderController.inputProduct("99008800", 10)
		assertTrue(orderController.saveOffer(orderNr));	
	}
	
	@Test
	public void generateOrderNr() {
		assertNotNull(orderController.generateOrderNr());
	}
	
	@Test
	public void getOrdersByCustomerID() {
		OrderContainer oc = OrderContainer.getInstance();
		assertNotNull(oc.findOrdersByCustomerID("66699666"));
	}
	
	@Test
	public void getOrdersByCustomerIDSpecific() {
        ArrayList<Order> expectedOrders = new ArrayList<>(orderController.getOrdersByName("Rikke denseje"));
        ArrayList<Order> actualOrders = orderController.getOrdersByCustomerID("66699666");

        assertEquals(expectedOrders, actualOrders);
    }
}
