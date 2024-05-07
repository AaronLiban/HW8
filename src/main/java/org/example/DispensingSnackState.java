package org.example;

public class DispensingSnackState implements StateOfVendingMachine{
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        System.out.println("Already dispensing a snack.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, double amount) {
        System.out.println("Already dispensing a snack.");
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        String selectedSnack = vendingMachine.getSelectedSnack().getName();
        vendingMachine.getDispenseHandler().handleRequest(selectedSnack, vendingMachine);
        vendingMachine.setState(new IdleState());
    }
}
