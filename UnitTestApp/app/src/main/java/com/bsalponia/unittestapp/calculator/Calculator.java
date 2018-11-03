package com.bsalponia.unittestapp.calculator;

public class Calculator {

    private Multiply multiply;              //interface
    private Divide divide;                      //class
    private Mod mod;                        //interface

    public Calculator(Multiply multiply, Divide divide, Mod mod){
        this.multiply= multiply;
        this.divide= divide;
        this.mod= mod;
    }

    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int performMultiply(int a, int b){
        return multiply.multiply(a, b);
    }

    public int performDivide(int a, int b){
        return divide.divide(a, b);
    }

    public int performMod(int a, int b){
        return mod.mod(a, b);
    }
}
