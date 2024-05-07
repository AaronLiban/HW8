package org.example;

public interface StateOfVendingMachine {
    void selectSnack(VendingMachine vendingMachine, String snackName);
    void insertMoney(VendingMachine vendingMachine, double amount);
    void dispenseSnack(VendingMachine vendingMachine);
}