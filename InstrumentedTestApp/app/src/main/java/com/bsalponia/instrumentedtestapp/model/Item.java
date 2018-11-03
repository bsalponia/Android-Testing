package com.bsalponia.instrumentedtestapp.model;

public class Item {

    private int count;
    private String date;

    public Item(){}
    public Item(int count, String date){
        this.count= count;
        this.date= date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
