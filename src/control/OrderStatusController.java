package control;

import model.Order;
import model.OrderContainer;
import model.OrderStatus;

public class OrderStatusController {

	private Order order;
	
	public OrderStatusController() {
		
		
	}
	
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
