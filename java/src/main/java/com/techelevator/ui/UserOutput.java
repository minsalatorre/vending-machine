package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.VendableItem;
import com.techelevator.models.VendingMachineModels;

import java.math.BigDecimal;
import java.util.*;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        displayVendingMachineArt();
    }

    public static void displayInventoryItems(VendingMachineModels vendingMachineModels){

        Map<String, VendableItem> slots = vendingMachineModels.getSlots();

        List<String> slotsNumber = new ArrayList<>();
        for (String itemSelection : slots.keySet()){
            slotsNumber.add(itemSelection);
        }

        Collections.sort(slotsNumber);

        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s%-18s%-6s%-8s%s\n", "Slot", "Item", " Price", "  Type", "  Quantity");
        System.out.println("--------------------------------------------------");
        for(String itemSelection : slotsNumber){
            VendableItem item = slots.get(itemSelection);

            System.out.printf("%-8s%-18s%s%-6.2f%-8s%3s%d\n", "[" + itemSelection + "]    ", item.getName(), " $", item.getPrice(), item.getType(), "   ", item.getQuantity());

        }
        displayCurrentBalance(vendingMachineModels);
        System.out.println();

    }

    public static void displayPurchaseMenuItems(){
        System.out.println();
        System.out.println("-----PURCHASE-MENU-----");
        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayCashMenu(VendingMachineModels vendingMachineModels){
        System.out.println();
        System.out.println("-----INSERT-CASH-----");
        System.out.println("A) $1");
        System.out.println("B) $5");
        System.out.println("C) $10");
        System.out.println("D) $20");
        System.out.println("E) Exit");
        System.out.println();
        System.out.println("        $" + vendingMachineModels.getCurrentBalance());
        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayCurrentBalance(VendingMachineModels vendingMachineModels){
        System.out.println();
        System.out.println("         Current Balance: $" + vendingMachineModels.getCurrentBalance());
    }

    public static void displayOutOfStock(){
        System.out.println("Item is out of stock.");
    }

    public static void displayInvalidSlot(){
        System.out.println("That slot number does not exist, please select a valid slot number.");
    }

    public static void displayTransactionReport(String itemName, BigDecimal transactionCost, BigDecimal currentBalance, String itemMessage){
        System.out.println("*******************************");
        System.out.println();
        System.out.println(itemMessage);
        System.out.println();
        System.out.println("Item purchased:       " + itemName);
        System.out.println("Item cost:            $" + transactionCost);
        System.out.println("Remaining Balance:    $" + currentBalance);


    }

    public static void displayInsufficientFunds(){
        System.out.println("Insufficient funds, please feed more money");
    }

    public static void displayChange(VendingMachineModels vendingMachineModels){
        Map<String, Integer> change = vendingMachineModels.getChange();
        System.out.println();
        System.out.println("-----DISPENSING-CHANGE-----");
        System.out.println("Dollars: " + change.get("dollar"));
        System.out.println("Quarters: " + change.get("quarter"));
        System.out.println("Dimes: " + change.get("dime"));
        System.out.println("Nickels: " + change.get("nickel"));
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("    Thank you for using Our Vending Machine!");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
        displayVendingMachineArt();
    }

    public static void displayVendingMachineArt(){
        System.out.println("                  ___________");
        System.out.println("                 | --------- |");
        System.out.println("                 | |.@.@.@.| |");
        System.out.println("                 | |.@.@.@.| |");
        System.out.println("                 | |.@.@.@.| |");
        System.out.println("                 | |.@.@.@.| |");
        System.out.println("                 | |.@.@.@.| |");
        System.out.println("                 | --------- |");
        System.out.println("                 |   [   ]   |");
        System.out.println("                 |___________| ");
        System.out.println("***************************************************");
        System.out.println(" Welcome to Minerva's and Chris's Vending Machine!");
        System.out.println("***************************************************");
        System.out.println();

    }

    public static void displayItemSelectionPrompt(){
        System.out.print("Please select a slot number: ");
    }

}
