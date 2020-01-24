package src.main;

import src.main.dto.order.OrderDTO;
import src.main.dto.order.PlateDTO;
import src.main.dto.order.DrinkDTO;

import java.util.List;
import java.util.ArrayList;

import java.rmi.RemoteException;


public interface OrderService  {

    public Context placeOrder(Context context) throws RemoteException, ContextException;

    public Context addDishesToOrder(Context context) throws RemoteException, ContextException;

    public Context payForOrder(Context context) throws RemoteException, ContextException;

}