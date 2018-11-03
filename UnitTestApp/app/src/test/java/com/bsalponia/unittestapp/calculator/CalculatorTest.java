package com.bsalponia.unittestapp.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator obj;

    @Mock
    private Multiply multiply;

    @Mock
    private Divide divide;

    @Mock
    private Mod mod;

    //can use this also for respective classes
//    private Multiply multiply= Mockito.mock(Multiply.class);

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        obj= new Calculator(multiply, divide, mod);
    }

    @Test
    public void add() {
        int expected= 9;
        int delta= 1;
        int output= obj.add(4, 5);

        assertEquals(expected, output, delta);
    }

    @Test
    public void subtract() {
        int expected= 11;
        int delta= 1;
        int output= obj.subtract(17, 6);        //actual hai yeh

        assertEquals(expected, output, delta);
    }

    @Test
    public void performMultiply() {
        int expected= 20;
        int delta= 1;

        Mockito.when(multiply.multiply(4, 5)).thenReturn(expected);
        int output= obj.performMultiply(4, 5);

        assertEquals(expected, output, delta);

        Mockito.verify(multiply).multiply(4, 5);
    }

    @Test
    public void performDivide() {
        int expected= 7;
        int delta= 1;

        Mockito.when(divide.divide(21, 3)).thenReturn(expected);
        int output= obj.performDivide(21, 3);

        assertEquals(expected, output, delta);

        Mockito.verify(divide).divide(21, 3);
    }

    @Test
    public void performMod() {
        int expected= 0;
        int delta= 0;

        Mockito.when(mod.mod(9, 3)).thenReturn(0);
        int output= obj.performMod(9 ,3);

        assertEquals(expected, output, delta);

        Mockito.verify(mod).mod(9, 3);
    }

    @After
    public void tearDown() throws Exception {
        obj= null;
        multiply= null;
        divide= null;
        mod= null;
    }
}