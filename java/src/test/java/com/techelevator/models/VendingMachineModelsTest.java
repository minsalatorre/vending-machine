package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingMachineModelsTest {

    VendingMachine testVendingMachine = new VendingMachine();
    VendingMachineModels testVendingMachineModels = new VendingMachineModels(testVendingMachine.getStock());
    Map<String, Integer> testMap = new HashMap<>();

    @Test
    public void gives_correct_change_5_dollars(){
        testMap.put("dollar", 5);
        testMap.put("quarter",0);
        testMap.put("dime",0);
        testMap.put("nickel",0);

        testVendingMachineModels.setCurrentBalance(new BigDecimal("5.00"));
        assertEquals(testMap, testVendingMachineModels.getChange());
    }

    @Test
    public void gives_correct_change_5_dollars_40_cents(){
        testMap.put("dollar", 5);
        testMap.put("quarter",1);
        testMap.put("dime",1);
        testMap.put("nickel",1);

        testVendingMachineModels.setCurrentBalance(new BigDecimal("5.40"));
        assertEquals(testMap, testVendingMachineModels.getChange());
    }
}