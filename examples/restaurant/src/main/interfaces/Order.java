package src.main;

import src.main.dto.order.OrderDTO;
import src.main.dto.order.PlateDTO;
import src.main.dto.order.DrinkDTO;

import java.util.List;
import java.util.ArrayList;

import java.rmi.RemoteException;


public interface Order  {

    public OrderDTO placeOrder(List<PlateDTO> plates, List<DrinkDTO> drinks, int tableNumber) throws RemoteException;

    public OrderDTO addDishesToOrder(List<PlateDTO> plates, List<DrinkDTO> drinks, OrderDTO orderDTO) throws RemoteException;

    public OrderDTO removeDishesFromOrder(List<PlateDTO> plates, List<DrinkDTO> drinks, OrderDTO orderDTO) throws RemoteException;

    public void deleteOrder(OrderDTO orderDTO) throws RemoteException;

    public void payForOrder(OrderDTO orderDTO) throws RemoteException;

}