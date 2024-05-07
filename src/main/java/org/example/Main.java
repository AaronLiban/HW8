package org.example;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialize snacks inventory
        Map<String, Snack> inventory = new HashMap<>();
        inventory.put("Coke", new Snack("Coke", 1.5, 5));
        inventory.put("Pepsi", new Snack("Pepsi", 1.5, 3));
        inventory.put("Cheetos", new Snack("Cheetos", 1.0, 10));
        inventory.put("Doritos", new Snack("Doritos", 1.0, 7));
        inventory.put("KitKat", new Snack("KitKat", 1.25, 6));
        inventory.put("Snickers", new Snack("Snickers", 1.25, 0)); // Snickers is out of stock

        // Initialize vending machine
        VendingMachine vendingMachine = new VendingMachine(inventory);

        // Chain of Responsibility: Coke -> Pepsi -> Cheetos -> Doritos -> KitKat -> Snickers
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.0); // Enough money
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(1.0); // Insufficient money
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.5); // Enough money
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(1.5); // Enough money
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(1.25); // Enough money
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers"); // Out of stock
        vendingMachine.insertMoney(1.25); // No money returned
        vendingMachine.dispenseSnack();
    }
}