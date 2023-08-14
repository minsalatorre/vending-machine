package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void gum_message_is_correct() {
        Gum gumTest = new Gum("test", new BigDecimal("2.00"));
        String gumMessage = "Chewy, Chewy, Lots O Bubbles!";

        assertEquals(gumMessage, gumTest.itemMessage());
    }

    @Test
    public void gum_name_is_correct() {
        Gum gumTest = new Gum("test", new BigDecimal("2.00"));
        assertEquals("test", gumTest.getName());
    }

    @Test
    public void gum_price_is_correct() {
        Gum gumTest = new Gum("test", new BigDecimal("2.00"));
        assertEquals(new BigDecimal("2.00"), gumTest.getPrice());
    }

    @Test
    public void gum_type_is_correct() {
        Gum gumTest = new Gum("test", new BigDecimal("2.00"));
        assertEquals("Gum", gumTest.getType());
    }
}