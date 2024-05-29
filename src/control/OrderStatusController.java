package control;

import model.Order;
import model.OrderContainer;
import model.OrderStatus;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the OrderStatusController, 
//enabling userinput from the TUI level to interact with the modellayer, 
//without compromising the architecture.
//Made during iteration 2
public class OrderStatusController {

	private Order order;
	
	public OrderStatusController() {
		
	}
	//Iteration 2
	public Order findOrderByNr(String orderNr) {
		OrderContainer oc = OrderContainer.getInstance();
		Order foundOrder = oc.findOrderByNr(orderNr);
		order = foundOrder;
		return foundOrder;
	}
	
	public OrderStatus changeOrderStatus(String status) {
		
		OrderStatus newStatus = OrderStatus.valueOf(status.toUpperCase());
		
		if(newStatus != null) {
		order.setOrderStatus(newStatus);
		}
		
		return newStatus;
		
	}
	
}
