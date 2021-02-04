package com.example.kahiproject;

public class CigsPassed {

    private long elapsed;
    private int howmuch;
    private double cigspassed;
    private double lifetimeregained;

    public CigsPassed(long elapsed, int howmuch) {
        this.elapsed = elapsed;
        this.howmuch = howmuch;
        this.cigspassed = 0;
        this.lifetimeregained = 0;
    }

    public void passedcigs () {
        double time = (double) this.elapsed;
        double kerroin = time / 86400000;
        this.cigspassed = Math.round ((this.howmuch * kerroin) * 10.0) / 10.0;
    }
    public void lifetimeregained () {
        this.lifetimeregained = Math.round ((this.cigspassed * 0.283333) * 10.0) / 10.0;
    }
    public String toString () {
        return "Polttamatta jääneitä tupakoita " + this.cigspassed + "!";
    }
    public String toString2 () {
        return "Elinaikaa säästetty " + this.lifetimeregained + " tuntia!";
    }
}
