package com.example.kahiproject;

public class LongtimeSavings {
    private int howmuch;
    private int cigsinpack;
    private float packprice;
    private double moneysaved;

    public LongtimeSavings(int howmuch, int cigsinpack, float packprice ) {
        this.packprice = packprice;
        this.howmuch = howmuch;
        this.cigsinpack = cigsinpack;
        this.moneysaved = 0;
    }

    public String onemonth(){
        double inaday = (this.howmuch / (double) cigsinpack) * this.packprice;
        this.moneysaved = Math.round ((inaday * 30.41) * 10.0) /10.0;
        return Double.toString(this.moneysaved);
    }

    public String oneyear() {
        double inaday = (this.howmuch / (double) cigsinpack) * this.packprice;
        this.moneysaved = Math.round ((inaday * 365) * 10.0) /10.0;
        return Double.toString(this.moneysaved);
    }

    public String fiveyear () {
        double inaday = (this.howmuch / (double) cigsinpack) * this.packprice;
        this.moneysaved = Math.round ((inaday * 1825) * 10.0) /10.0;
        return Double.toString(this.moneysaved);
    }

    public String tenyears () {
        double inaday = (this.howmuch / (double) cigsinpack) * this.packprice;
        this.moneysaved = Math.round ((inaday * 3650) * 10.0) /10.0;
        return Double.toString(this.moneysaved);
    }


}
