package src.main.implementation;

import src.main.interfaces.Order;

import src.main.dto.order.OrderDTO;
import src.main.dto.order.PlateDTO;
import src.main.dto.order.DrinkDTO;

import java.util.List;
import java.util.ArrayList;

import java.rmi.RemoteException;

public class OrderImpl implements Order, OrderService {

    public OrderDTO placeOrder(List<PlateDTO> plates, List<DrinkDTO> drinks, int tableNumber) throws RemoteException {
        OrderDTO orderDTO = new OrderDTO(plates, drinks, tableNumber, false);
        return orderDTO;
    }

    public OrderDTO addDishesToOrder(List<PlateDTO> plates, List<DrinkDTO> drinks, OrderDTO orderDTO) throws RemoteException {
        if(plates != null) {
            orderDTO.getPlates().addAll(plates);
        }

        if(drink != null) {
            orderDTO.getDrinks().addAll(drinks);
        }

        return orderDTO;
    }

    public OrderDTO removeDishesFromOrder(List<PlateDTO> plates, List<DrinkDTO> drinks, OrderDTO orderDTO) throws RemoteException {
        if(plates != null) {
            orderDTO.getPlates().removeAll(plates);
        }

        if(drinks != null) {
            orderDTO.getDrinks().removeAll(drinks);
        }

        return orderDTO;
    }

    public void deleteOrder(OrderDTO orderDTO) throws RemoteException {
        OrderDTO.getOrderDTOList().remove(orderDTO);
    }

    public void payForOrder(OrderDTO orderDTO) throws RemoteException {
        if(!orderDTO.isPayed()) {
            orderDTO.setPayed(true);
        } else {
            System.err.println("Order is already payed.");
        }
    }

    public Context placeOrder(Context context) throws RemoteException, ContextException {
        OrderDTO o = OrderDTO.getOrder(context);
		OrderDTO placedOrder = placeOrder(o.getPlates(), o.getDrinks(), o.getTableNumber());
		context.putValue("order/placed", placedOrder);
		return context;
    }

    public Context addDishesToOrder(Context context) throws RemoteException, ContextException {
        List<OrderDTO> ol = new ArrayList<>();
		for (OrderDTO o : OrderDTO.getOrderDTOList() {
			if (o.getPlates() != null && !o.getPlates().isEmpty() ol.add(o);
		}

		context.putValue("addDishesToOrder", ol);
		return context;
    }

    public Context payForOrder(Context context) throws RemoteException, ContextException {
        OrderDTO o = OrderDTO.getOrder(context);
		boolean isPayed = payForOrder(o);
		context.putValue("order/payed", isPayed);
		return context;
    }


}