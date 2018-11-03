package com.bsalponia.unittestapp.degreeUtil;

public class DegreeConverter {

    public double celsiusToFahrenheit(double celsius){
        double fahrenheit= celsius*9/5 + 32;
        return fahrenheit;
    }

    public double fahrenheitToCelsius(double fahrenheit){
        double celsius= (fahrenheit-32)*5/9;
        return celsius;
    }
}
