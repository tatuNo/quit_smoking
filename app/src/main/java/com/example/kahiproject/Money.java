package com.example.kahiproject;

import android.content.Context;
import android.content.SharedPreferences;

public class Money {
    private long elapsed;
    private int howmuch;
    private int cigsinpack;
    private float packprice;
    private double moneysaved;

    public Money(long elapsed, int howmuch, int cigsinpack, float packprice ) {
        this.elapsed = elapsed;
        this.packprice = packprice;
        this.howmuch = howmuch;
        this.cigsinpack = cigsinpack;
        this.moneysaved = 0;
    }
    public void savedMoney () {
        double time = (double) elapsed;
        double kerroin = time / 86400000;
        double inaday = (this.howmuch / (double) cigsinpack) * this.packprice;
        this.moneysaved = Math.round ((inaday * kerroin)* 100.0) / 100.0;
    }

    public String toString () {
        return "Rahaa säästynyt " + this.moneysaved + " euroa!";
    }
}