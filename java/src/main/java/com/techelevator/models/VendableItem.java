package com.techelevator.models;

import java.math.BigDecimal;

public abstract class VendableItem {

    private String name = "";
    private BigDecimal price = new BigDecimal("0.00");
    private String type = "";
    private int quantity = 0;

    public VendableItem(String name, BigDecimal price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 6;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity() {

        this.quantity -= 1;
    }

    public abstract String itemMessage();
}
