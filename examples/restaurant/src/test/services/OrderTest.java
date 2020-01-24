package src.test.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.core.provider.rendezvous.ServiceJobber;
import sorcer.service.*;
import src.main.dto.order.OrderDTO;
import src.main.implementation.OrderImpl;
import src.main.interfaces.OrderService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sorcer.co.operator.inPaths;
import static sorcer.co.operator.inVal;
import static sorcer.co.operator.val;
import static sorcer.ent.operator.ent;
import static sorcer.eo.operator.*;
import static sorcer.mo.operator.value;
import static sorcer.so.operator.eval;
import static sorcer.so.operator.exec;
import static sorcer.so.operator.exert;

@RunWith(SorcerTestRunner.class)
public class OrderTest {

    private Context espresso, order1, order2, order3;
	private OrderDTO orderDTO;

	@Before
	public void setUp() throws ContextException {

	    PlateDTO plate1 = new PlateDTO();
	    plate1.setName("Plate1");
	    plate1.setAmount(1);
	    plate1.setPrice(5.9);
	    plate1.setDescription("This plate is very tasty and very quick to prepare");


	    PlateDTO plate2 = new PlateDTO();
	    plate2.setName("Plate2");
	    plate2.setAmount(2);
	    plate2.setPrice(13.9);
	    plate2.setDescription("A great alternative to plate1");

	    DrinkDTO drink1 = new DrinkDTO();
	    drink1.setName("Drink1");
	    drink1.setAmount(1);
	    drink1.setPrice(3.7);
	    drink1.setDescription("Cola");
	    drink1.setDrinkVolume(0.5);

	    DrinkDTO drink2 = new DrinkDTO();
	    drink2.setName("Drink2");
	    drink2.setAmount(1);
	    drink2.setPrice(3.7);
	    drink2.setDescription("Fanta");
	    drink2.setDrinkVolume(0.5);

	    List<PlateDTO> plates = new ArrayList<>(Arrays.asList(plate1, plate2);
	    List<DrinkDTO> drinks = new ArrayList<>(Arrays.asList(drink1, drink2);

	    orderDTO = new OrderDTO();
	    orderDTO.setPlates(plates);
	    orderDTO.setDrinks(drinks);
	    orderDTO.setTableNumber(5);
	    orderDTO.setPayed(false);

	    order1 = context(ent("tableNumber", 1), ent("payed", false));
	    order2 = context(ent("tableNumber", 2), ent("payed", true));
	    order3 = context(ent("tableNumber", 3), ent("payed", false));

	}

    @Test
    public void placeOrderTest() {

        Routine cmt = task(sig("placeOrder", Order.class), order1);
		Context out = context(exert(cmt));
		assertEquals(value(out, "order/placed"), orderDTO);

		Routine cmj = job("orders",
			task("order2", sig("placeOrder", OrderService.class), order2),
			task("order3", sig("placeOrder", OrderService.class), order3));

		out = upcontext(exert(cmj));
		assertEquals(value(out, "orders/order3/order/placed"), order3);
		assertEquals(value(out, "orders/order3/order/placed"), order3);
		assertEquals(value(out, "orders/order3/order/placed"), order3);

    }

    @Test
	public void payForOrder() throws Exception {
		Routine cmt = task(sig("payForOrder", Order.class), order1);
		Context out = context(exert(cmt));
		assertEquals(value(out, "order/payed"), orderDTO);
	}

}