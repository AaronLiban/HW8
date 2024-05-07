package org.example;

import javax.swing.plaf.nimbus.State;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine state;
    private Map<String, Snack> inventory;
    private Snack selectedSnack;
    private double moneyInserted;
    private SnackDispenseHandler dispenseHandler;

    public VendingMachine(Map<String, Snack> inventory) {
        this.inventory = inventory;
        this.state = new IdleState();
        this.dispenseHandler = new CokeDispenseHandler(new PepsiDispenseHandler(new CheetosDispenseHandler(new DoritosDispenseHandler(new KitKatDispenseHandler(new SnickersDispenseHandler(null))))));
    }

    public void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }

    public void insertMoney(double amount) {
        state.insertMoney(this, amount);
    }

    public void dispenseSnack() {
        state.dispenseSnack(this);
    }

    public StateOfVendingMachine getState() {
        return state;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public Map<String, Snack> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Snack> inventory) { //remove later
        this.inventory = inventory;
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void setSelectedSnack(String selectedSnack) {
        this.selectedSnack = inventory.get(selectedSnack);
    }

    public double getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(double moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    public SnackDispenseHandler getDispenseHandler() {
        return dispenseHandler;
    }

    public void setDispenseHandler(SnackDispenseHandler dispenseHandler) {
        this.dispenseHandler = dispenseHandler;
    }
}
