package com.techelevator.models;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachineModels {

    private Map<String, VendableItem> slots = new HashMap<>();
    private BigDecimal currentBalance = new BigDecimal("0.00");

    public VendingMachineModels(Map<String, VendableItem> slots) {
        this.slots = slots;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = this.currentBalance.add(currentBalance);
    }

    public void subtractFromCurrentBalance(BigDecimal transactionCost){
        this.currentBalance = this.currentBalance.subtract(transactionCost);
    }

    public Map<String, VendableItem> getSlots() {
        return slots;
    }

    public Map<String, Integer> getChange(){
        String dollar = "dollar";
        String quarter = "quarter";
        String dime = "dime";
        String nickel = "nickel";
        Map<String, Integer> currentChange = new HashMap<>();
        currentChange.put(dollar,0);
        currentChange.put(quarter,0);
        currentChange.put(dime,0);
        currentChange.put(nickel,0);

        while (currentBalance.compareTo(new BigDecimal("1.00")) >= 0){
            currentChange.put(dollar, currentChange.get(dollar) + 1);
            currentBalance = currentBalance.subtract(new BigDecimal("1.00"));
        }
        while (currentBalance.compareTo(new BigDecimal("0.25")) >= 0){
            currentChange.put(quarter, currentChange.get(quarter) + 1);
            currentBalance = currentBalance.subtract(new BigDecimal("0.25"));
        }
        while(currentBalance.compareTo(new BigDecimal("0.10")) >= 0){
            currentChange.put(dime, currentChange.get(dime) + 1);
            currentBalance = currentBalance.subtract(new BigDecimal("0.10"));
        }
        while(currentBalance.compareTo(new BigDecimal("0.05")) >= 0){
            currentChange.put(nickel, currentChange.get(nickel) + 1);
            currentBalance = currentBalance.subtract(new BigDecimal("0.05"));
        }

        return currentChange;
    }
}
