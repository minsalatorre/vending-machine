package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void drink_message_is_correct(){
        Drink drinkTest = new Drink("test", new BigDecimal("2.00"));
        String drinkMessage = "Drinky, Drinky, Slurp Slurp!";

        assertEquals(drinkMessage, drinkTest.itemMessage());

    }

    @Test
    public void drink_name_is_correct(){
        Drink drinkTest = new Drink("test", new BigDecimal("2.00"));
        assertEquals("test", drinkTest.getName());
    }

    @Test
    public void drink_price_is_correct(){
        Drink drinkTest = new Drink("test", new BigDecimal("2.00"));
        assertEquals(new BigDecimal("2.00"), drinkTest.getPrice());
    }

    @Test
    public void drink_type_is_correct() {
        Drink drinkTest = new Drink("test", new BigDecimal("2.00"));
        assertEquals("Drink", drinkTest.getType());
    }
}