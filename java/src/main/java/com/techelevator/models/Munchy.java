package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends VendableItem{


    public Munchy(String name, BigDecimal price) {
        super(name, price, "Munchy");
    }

    @Override
    public String itemMessage() {
        return "Munchy, Munchy, so Good!";
    }
}
