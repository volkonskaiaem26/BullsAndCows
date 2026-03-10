package com.example.BulsAndCows;

public class BullsCowsResult {
    private int bulls;
    private int cows;

    public BullsCowsResult() {
    }

    public BullsCowsResult(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }
}