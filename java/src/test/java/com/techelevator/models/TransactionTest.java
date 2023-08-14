package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionTest {

    VendableItem testItem = new Candy("testCandy", new BigDecimal("2.00"));

    @Test
    public void get_transaction_cost_with_discount(){
        Transaction testTransaction = new Transaction(new BigDecimal("3.00"), testItem, 2);
        BigDecimal testAmount = new BigDecimal("1.00");

        assertEquals(testAmount, testTransaction.getTransactionCost());
    }

    @Test
    public void get_transaction_cost_without_discount(){
        Transaction testTransaction = new Transaction(new BigDecimal("3.00"), testItem, 1);
        BigDecimal testAmount = new BigDecimal("2.00");

        assertEquals(testAmount, testTransaction.getTransactionCost());
    }

}