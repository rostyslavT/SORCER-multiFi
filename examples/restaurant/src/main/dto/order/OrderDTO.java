package src.main.dto.order;

import java.util.List;
import java.util.ArrayList;

public class OrderDTO {

    private static List<OrderDTO> orderDTOList = new ArrayList<>();

    private List<PlateDTO> plates;
    private List<DrinkDTO> drinks;
    private int tableNumber;
    private boolean payed;

    public OrderDTO(List<PlateDTO> plates, List<DrinkDTO> drinks, int tableNumber, boolean payed) {
        this.plates = plates;
        this.drinks = drinks;
        this.tableNumber = tableNumber;
        this.payed = payed;

        orderDTOList.add(this);
    }

    public List<PlateDTO> getPlates() {
        return plates == null ? new ArrayList() : plates;
    }

    public void setPlates(List<PlateDTO> plates) {
        this.plates = plates;
    }

    public List<DrinkDTO> getDrinks() {
        return drinks == null ? new ArrayList() : drinks;
    }

    public void setDrinks(List<DrinkDTO> drinks) {
        this.drinks = drinks;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public static List<OrderDTO> getOrderDTOList() {
        return orderDTOList;
    }
}