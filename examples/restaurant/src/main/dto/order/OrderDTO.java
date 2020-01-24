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

    static public OrderDTO getOrder(Context context) throws ContextException {
		OrderDTO o = new OrderDTO();
		try {

            o.getDrinks().addAll((List<DrinkDTO>)context.getValue("drinks"));
            o.getPlates().addAll((List<PlateDTO>)context.getValue("plates"));
            o.tableNumber = (int)context.getValue("tableNumber");
            o.payed = (boolean)context.getValue("payed");

		} catch (RemoteException e) {
			throw new ContextException(e);
		}
		return o;
	}

	static public Context getContext(OrderDTO order) throws ContextException {
		Context cxt = new ServiceContext();
		cxt.putValue("tableNumber", order.getTableNumber());
		cxt.putValue("payed", order.isPayed());
		cxt.putValue("drinks", order.getDrinks();
		cxt.putValue("plates", order.getPlates());
		return cxt;
	}

	public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        OrderDTO that = (OrderDTO) object;
        return java.util.Objects.equals(tableNumber, that.tableNumber) &&
                java.util.Objects.equals(payed, that.payed);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), tableNumber, payed);
    }
}