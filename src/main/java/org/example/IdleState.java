package org.example;

public class IdleState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        vendingMachine.setSelectedSnack(snackName);
        vendingMachine.setState(new WaitingForMoneyState());
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        System.out.println("Please select a snack first.");
    }
}
