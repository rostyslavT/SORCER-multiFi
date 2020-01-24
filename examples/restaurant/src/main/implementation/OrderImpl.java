package src.main.implementation;

import src.main.interfaces.Order;

import src.main.dto.order.OrderDTO;
import src.main.dto.order.PlateDTO;
import src.main.dto.order.DrinkDTO;

import java.util.List;
import java.util.ArrayList;

import java.rmi.RemoteException;

public class OrderImpl implements Order {

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

}