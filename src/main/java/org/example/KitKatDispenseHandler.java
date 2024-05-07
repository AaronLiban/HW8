package org.example;

public class KitKatDispenseHandler extends SnackDispenseHandler{
    public KitKatDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }
    public void handleRequest(String selectedSnack, VendingMachine vendingMachine) {
        if(selectedSnack.equals("KitKat")) {
            if(vendingMachine.getInventory().get(selectedSnack).getQuantity() > 0) {
                vendingMachine.getInventory().get(selectedSnack).setQuantity(
                        vendingMachine.getInventory().get(selectedSnack).getQuantity() - 1);
                System.out.println("Dispensed: " + selectedSnack);
            } else {
                System.out.println(selectedSnack + "is out of stock. Please select another snack.");
            }
        } else {
            System.out.println("I was passed from KitKat");
            super.handleRequest(selectedSnack, vendingMachine);
        }
    }
}
