package com.techelevator.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MunchyTest {

    @Test
    public void munchy_message_is_correct(){
        Munchy munchyTest = new Munchy("test", new BigDecimal("2.00"));
        String munchyMessage = "Munchy, Munchy, so Good!";

        assertEquals(munchyMessage, munchyTest.itemMessage());
    }

    @Test
    public void munchy_name_is_correct() {
        Munchy munchyTest = new Munchy("test", new BigDecimal("2.00"));
        assertEquals("test", munchyTest.getName());
    }

    @Test
    public void munchy_price_is_correct() {
        Munchy munchyTest = new Munchy("test", new BigDecimal("2.00"));
        assertEquals(new BigDecimal("2.00"), munchyTest.getPrice());
    }

    @Test
    public void munchy_type_is_correct() {
        Munchy munchyTest = new Munchy("test", new BigDecimal("2.00"));
        assertEquals("Munchy", munchyTest.getType());
    }
}