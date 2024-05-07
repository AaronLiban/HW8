package org.example;

public class PepsiDispenseHandler extends SnackDispenseHandler{
    public PepsiDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }
    public void handleRequest(String selectedSnack, VendingMachine vendingMachine) {
        if(selectedSnack.equals("Pepsi")) {
            if(vendingMachine.getInventory().get(selectedSnack).getQuantity() > 0) {
                vendingMachine.getInventory().get(selectedSnack).setQuantity(
                        vendingMachine.getInventory().get(selectedSnack).getQuantity() - 1);
                System.out.println("Dispensed: " + selectedSnack);
            } else {
                System.out.println(selectedSnack + " is out of stock. Please select another snack.");
            }
        } else {
            System.out.println("I was passed from Pepsi.");
            super.handleRequest(selectedSnack, vendingMachine);
        }
    }
}
