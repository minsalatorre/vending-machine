package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendableItem{

    public Candy(String name, BigDecimal price) {
        super(name, price, "Candy");
    }

    @Override
    public String itemMessage() {
        return "Sugar, Sugar, so Sweet!";
    }
}
