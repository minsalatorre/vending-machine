package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void candy_message_is_correct(){
        Candy candyTest = new Candy("test", new BigDecimal("2.00"));
        String candyMessage = "Sugar, Sugar, so Sweet!";

        assertEquals(candyMessage, candyTest.itemMessage());

    }

    @Test
    public void candy_name_is_correct(){
        Candy candyTest = new Candy("test", new BigDecimal("2.00"));
        assertEquals("test", candyTest.getName());
    }

    @Test
    public void candy_price_is_correct(){
        Candy candyTest = new Candy("test", new BigDecimal("2.00"));
        assertEquals(new BigDecimal("2.00"), candyTest.getPrice());
    }

    @Test
    public void candy_type_is_correct(){
        Candy candyTest = new Candy("test", new BigDecimal("2.00"));
        assertEquals("Candy", candyTest.getType());
    }
}