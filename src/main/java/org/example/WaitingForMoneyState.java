package org.example;

public class WaitingForMoneyState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Snack already selected. Please insert money.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        vendingMachine.setMoneyInserted(amount);
        if(vendingMachine.getMoneyInserted() >= vendingMachine.getSelectedSnack().getPrice()) {
            vendingMachine.setState(new DispensingSnackState());
        } else {
            System.out.println("Insufficient funds.");
            vendingMachine.setState(new IdleState());
        }
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please insert money first.");
    }
}
