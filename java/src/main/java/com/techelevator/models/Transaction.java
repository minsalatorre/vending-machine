package com.techelevator.models;

import java.math.BigDecimal;

public class Transaction {

    private final BigDecimal DISCOUNT = new BigDecimal("1.00");

    private BigDecimal amountReceived = new BigDecimal("0.00");
    private BigDecimal amountOfChange = new BigDecimal("0.00");
    private BigDecimal transactionCost = new BigDecimal("0.00");
    private boolean applyDiscount = false;

    public Transaction(BigDecimal amountReceived, VendableItem item, int counter) {
        this.amountReceived = amountReceived;
        this.transactionCost = item.getPrice();
        if (counter%2 == 0){
            applyDiscount = true;
        }
    }

    public BigDecimal getTransactionCost(){
        if (applyDiscount){
            return transactionCost.subtract(DISCOUNT);
        }
        return transactionCost;
    }
}
