import org.example.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    @Test
    public void testInventory() {
        Map<String, Snack> expected = new HashMap<>();
        expected.put("Coke", new Snack("Coke", 1.5, 5));
        expected.put("Pepsi", new Snack("Pepsi", 1.5, 3));
        expected.put("Cheetos", new Snack("Cheetos", 1.0, 10));
        expected.put("Doritos", new Snack("Doritos", 1.0, 7));
        expected.put("KitKat", new Snack("KitKat", 1.25, 6));
        expected.put("Snickers", new Snack("Snickers", 1.25, 0)); // Snickers is out of stock

        VendingMachine vendingMachine = new VendingMachine(expected);
        assertEquals(expected, vendingMachine.getInventory());
    }
    @Test
    public void testIdleState() {
        Map<String, Snack> inventory = new HashMap<>();
        inventory.put("Coke", new Snack("Coke", 1.5, 5));
        inventory.put("Pepsi", new Snack("Pepsi", 1.5, 3));
        inventory.put("Cheetos", new Snack("Cheetos", 1.0, 10));
        inventory.put("Doritos", new Snack("Doritos", 1.0, 7));
        inventory.put("KitKat", new Snack("KitKat", 1.25, 6));
        inventory.put("Snickers", new Snack("Snickers", 1.25, 0)); // Snickers is out of stock

        VendingMachine vendingMachine = new VendingMachine(inventory);
        StateOfVendingMachine actual = vendingMachine.getState();;

        assertInstanceOf(IdleState.class, actual);
    }
    @Test
    public void testWaitingForMoneyState() {
        Map<String, Snack> inventory = new HashMap<>();
        inventory.put("Coke", new Snack("Coke", 1.5, 5));
        inventory.put("Pepsi", new Snack("Pepsi", 1.5, 3));
        inventory.put("Cheetos", new Snack("Cheetos", 1.0, 10));
        inventory.put("Doritos", new Snack("Doritos", 1.0, 7));
        inventory.put("KitKat", new Snack("KitKat", 1.25, 6));
        inventory.put("Snickers", new Snack("Snickers", 1.25, 0)); // Snickers is out of stock

        VendingMachine vendingMachine = new VendingMachine(inventory);
        vendingMachine.selectSnack("Coke");
        StateOfVendingMachine actual = vendingMachine.getState();;

        assertInstanceOf(WaitingForMoneyState.class, actual);
    }    @Test
    public void testDispensingSnackState() {
        Map<String, Snack> inventory = new HashMap<>();
        inventory.put("Coke", new Snack("Coke", 1.5, 5));
        inventory.put("Pepsi", new Snack("Pepsi", 1.5, 3));
        inventory.put("Cheetos", new Snack("Cheetos", 1.0, 10));
        inventory.put("Doritos", new Snack("Doritos", 1.0, 7));
        inventory.put("KitKat", new Snack("KitKat", 1.25, 6));
        inventory.put("Snickers", new Snack("Snickers", 1.25, 0)); // Snickers is out of stock

        VendingMachine vendingMachine = new VendingMachine(inventory);
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.0);
        StateOfVendingMachine actual = vendingMachine.getState();;

        assertInstanceOf(DispensingSnackState.class, actual);
    }
    @Test
    public void testChainOfResponsibilities() {
        Map<String, Snack> inventory = new HashMap<>();
        inventory.put("Coke", new Snack("Coke", 1.5, 5));
        inventory.put("Pepsi", new Snack("Pepsi", 1.5, 3));
        inventory.put("Cheetos", new Snack("Cheetos", 1.0, 10));
        inventory.put("Doritos", new Snack("Doritos", 1.0, 7));
        inventory.put("KitKat", new Snack("KitKat", 1.25, 6));
        inventory.put("Snickers", new Snack("Snickers", 1.25, 0)); // Snickers is out of stock

        VendingMachine vendingMachine = new VendingMachine(inventory);
        vendingMachine.selectSnack("Snickers"); // Out of stock
        vendingMachine.insertMoney(1.25); // No money returned
        vendingMachine.dispenseSnack();
        SnackDispenseHandler actual = vendingMachine.getDispenseHandler().getNext().getNext().getNext().getNext().getNext();

        assertInstanceOf(SnickersDispenseHandler.class, actual);
    }

}
