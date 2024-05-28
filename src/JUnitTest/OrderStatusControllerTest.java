package JUnitTest;
import control.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import control.*;
import model.Customer;
import model.Order;
import model.OrderContainer;
import model.Product;
import tui.TryMe;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: Interatction Test in a JUnit frame. testing the methods 
//of the OrderStatusController.
//made during iteration 2 
public class OrderStatusControllerTest {
	
	 private OrderStatusController orderStatusController;
	 private OrderController orderController;
	 private OrderContainer oc;

	    @Before
	    public void setUp() throws Exception {
	        orderStatusController = new OrderStatusController();
	        orderController = new OrderController();
	        
	        TryMe.addData();
	    }

	    @Test 
	    public void findOrderByNr() {
	    	Order order= new Order();
	    	oc = OrderContainer.getInstance();
	    	
	    	oc.saveOffer(order);
	    	
	        
	        assertNotNull(orderStatusController.findOrderByNr("1"));
	    }
	    
	    @Test
	    public void findOrderByNrFalse() {
	    	Order order= new Order();
	    	oc = OrderContainer.getInstance();
	    	
	    	oc.saveOffer(order);
	    	
	        
	        assertNotNull(orderStatusController.findOrderByNr("12"));
	    }
	    
	    @Test
	    public void changestatus() {
	    	Order order= new Order();
	    	oc = OrderContainer.getInstance();
	    	
	    	oc.saveOffer(order);
	    	
	    	orderStatusController.findOrderByNr("1");
	    	
	        assertNotNull(orderStatusController.changeOrderStatus("PAID"));
	    }
	    
	    
	    

}
