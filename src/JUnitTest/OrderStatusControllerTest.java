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


//iteration 2 
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
