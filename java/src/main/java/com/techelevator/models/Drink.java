package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends VendableItem{

    public Drink(String name, BigDecimal price) {

        super(name, price, "Drink");
    }

    @Override
    public String itemMessage() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
