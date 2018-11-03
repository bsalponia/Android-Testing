package com.bsalponia.unittestapp.degreeUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DegreeConverterTest {

    private DegreeConverter obj;

    @Before
    public void setUp() throws Exception {
        obj= new DegreeConverter();
    }

    @Test
    public void celsiusToFahrenheit() {

        double input= 37;
        double output= obj.celsiusToFahrenheit(input);

        double expected= 98.6;
        double delta= .1;

        assertEquals(expected, output, delta);
    }

    @Test
    public void fahrenheitToCelsius() {

        double input= 98.6;
        DegreeConverter obj= new DegreeConverter();
        double output= obj.fahrenheitToCelsius(input);

        double expected= 37;
        double delta= 0;

        assertEquals(expected, output, delta);
    }

    @After
    public void tearDown() throws Exception {
        obj= null;
    }
}