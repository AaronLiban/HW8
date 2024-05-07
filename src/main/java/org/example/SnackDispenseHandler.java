package org.example;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;
    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }
    public void handleRequest(String selectedSnack, VendingMachine vendingMachine) {
        if (next != null) {
            next.handleRequest(selectedSnack, vendingMachine);
        }
    }

    public SnackDispenseHandler getNext() {
        return next;
    }
}
