package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendableItem{

    public Gum(String name, BigDecimal price) {
        super(name, price, "Gum");
    }

    @Override
    public String itemMessage() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
