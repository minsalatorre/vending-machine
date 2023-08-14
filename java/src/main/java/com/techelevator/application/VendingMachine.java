package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    private final String FILE1 = "catering.csv";
    private final String FILE2 = "catering1.csv";
    private final String AUDITFILE = "Audit.txt";

    int transactionCounter = 0;

    public void run()
    {
        VendingMachineModels vendingMachineModels = new VendingMachineModels(getStock());
        File auditFile = new File(AUDITFILE);
        // we did some research to create this DateFormat https://www.benchresources.net/java-8-how-to-get-date-time-with-am-pm-marker-and-zone/
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
        UserOutput.displayHomeScreen();
        while(true)
        {


            String choice = UserInput.getHomeScreenOption();


            if(choice.equals("display"))
            {
                UserOutput.displayInventoryItems(vendingMachineModels);


            }
            else if(choice.equals("purchase"))
            {
                while(true)
                {
                   String purchaseChoice = UserInput.getPurchaseStringOption();

                   if(purchaseChoice.equals("Feed Money")){

                       feedMoney(vendingMachineModels, dateFormat, auditFile);
//
                   }
                   else if(purchaseChoice.equals("Select Item")) {

                       selectItem(vendingMachineModels, dateFormat, auditFile);
//
                   }
                   else {
                       transactionCounter = 0;
                       try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(auditFile, true))){
                           printWriter.printf("%-50s%s%-10.2f%s%.2f%n", dateFormat.format(new Date()) + " CHANGE GIVEN:",  "$",vendingMachineModels.getCurrentBalance(),  "$", new BigDecimal("0.00"));
                       } catch (FileNotFoundException e) {
                           e.printStackTrace();
                       }
                       UserOutput.displayChange(vendingMachineModels);

                       break;
                   }
                }

            }
            else if(choice.equals("exit"))
            {
                // goodbye
                break;
            }
        }
    }


    public Map<String, VendableItem> getStock() {
        File inventoryFile = new File(FILE2);
        Map<String, VendableItem> inventory = new HashMap<>();

        try(Scanner scanner = new Scanner(inventoryFile)) {
          while(scanner.hasNextLine()) {

              VendableItem vendableItem;
              String nextItem = scanner.nextLine();
              String[] itemInfo = nextItem.split(",");

              String slot = itemInfo[0];
              String name = itemInfo[1];
              BigDecimal price = new BigDecimal(itemInfo[2]);
              String type = itemInfo[3];
              if(type.equals("Gum")){
                  vendableItem = new Gum(name, price);
              }
              else if(type.equals("Munchy")){
                  vendableItem = new Munchy(name, price);
              }
              else if(type.equals("Drink")){
                  vendableItem = new Drink(name, price);
              }
              else {
                  vendableItem = new Candy(name, price);
              }

              inventory.put(slot, vendableItem);
          }

          return inventory;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void feedMoney(VendingMachineModels vendingMachineModels, DateFormat dateFormat, File auditFile){
        String cashSelection = UserInput.getCashStringOption(vendingMachineModels);

        if(cashSelection.equals("1")){

            setBalanceAndAppendAuditFile(dateFormat, auditFile, vendingMachineModels, "1.00");
        }
        else if(cashSelection.equals("5")){

            setBalanceAndAppendAuditFile(dateFormat, auditFile, vendingMachineModels, "5.00");
        }
        else if(cashSelection.equals("10")){

            setBalanceAndAppendAuditFile(dateFormat, auditFile, vendingMachineModels, "10.00");
        }
        else if(cashSelection.equals("20")){

            setBalanceAndAppendAuditFile(dateFormat, auditFile, vendingMachineModels, "20.00");
        }

    }

    private void setBalanceAndAppendAuditFile(DateFormat dateFormat, File auditFile, VendingMachineModels vendingMachineModels, String dollars){

        vendingMachineModels.setCurrentBalance(new BigDecimal(dollars));

        try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(auditFile, true))){
            printWriter.printf("%-50s%s%-10.2f%s%.2f%n", dateFormat.format(new Date()) + " MONEY FED:",  "$", new BigDecimal(dollars),  "$", vendingMachineModels.getCurrentBalance());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void selectItem(VendingMachineModels vendingMachineModels, DateFormat dateFormat, File auditFile){

        String selection = UserInput.getItemSelectionOption(vendingMachineModels);
        if (selection.equals("Bad")){
        }
        else {
            VendableItem currentItem = vendingMachineModels.getSlots().get(selection);
            if (vendingMachineModels.getCurrentBalance().compareTo(currentItem.getPrice()) < 0) {
                UserOutput.displayInsufficientFunds();
            } else {

                transactionCounter++;

                Transaction transaction = new Transaction(vendingMachineModels.getCurrentBalance(), currentItem, transactionCounter);
                vendingMachineModels.subtractFromCurrentBalance(transaction.getTransactionCost());
                UserOutput.displayTransactionReport(currentItem.getName(), transaction.getTransactionCost(), vendingMachineModels.getCurrentBalance(), currentItem.itemMessage());

                try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(auditFile, true))){
                    printWriter.printf("%-45s%-5s%s%-10.2f%s%.2f%n", dateFormat.format(new Date()) + " " + currentItem.getName(),  selection,  "$", vendingMachineModels.getCurrentBalance().add(transaction.getTransactionCost()),  "$", vendingMachineModels.getCurrentBalance());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                vendingMachineModels.getSlots().get(selection).setQuantity();
                //option stuff here
            }
        }
    }
}
