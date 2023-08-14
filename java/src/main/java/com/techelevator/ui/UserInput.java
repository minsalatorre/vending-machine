package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.VendingMachineModels;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseStringOption(){
        UserOutput.displayPurchaseMenuItems();
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M"))
        {
            return "Feed Money";
        }
        else if (option.equals("S"))
        {
            return "Select Item";
        }
        else if (option.equals("F"))
        {
            return "Finish Transaction";
        }
        else
        {
            return "";
        }

    }

    public static String getCashStringOption(VendingMachineModels vendingMachineModels){
        UserOutput.displayCashMenu(vendingMachineModels);
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if(option.equals("A")){
            return "1";
        }
        else if(option.equals("B")){
            return "5";
        }
        else if(option.equals("C")){
            return "10";
        }
        else if(option.equals("D")){
            return "20";
        }
        else {
            return "Exit";
        }
    }

    public static String getItemSelectionOption(VendingMachineModels vendingMachineModels){

        UserOutput.displayInventoryItems(vendingMachineModels);
        UserOutput.displayItemSelectionPrompt();
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        if(!vendingMachineModels.getSlots().keySet().contains(option)){
            UserOutput.displayInvalidSlot();
            return "Bad";
        }
        else if(vendingMachineModels.getSlots().get(option).getQuantity() <= 0){
            UserOutput.displayOutOfStock();
            return "Bad";
        }
        else {
            return option;
        }
    }

    
}
