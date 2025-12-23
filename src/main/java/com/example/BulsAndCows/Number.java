package com.example.BulsAndCows;

public class Number {

    private int first;
    static int FIRST = 1;
    private int second;
    static int SECOND = 1;
    private int third;
    static int THIRD = 1;
    private int forth;
    static int FORTH = 1;

    public Number(){
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    public int getForth() {
        return forth;
    }

    public void setForth(int forth) {
        this.forth = forth;
    }

    public int getCows(int a){
        int cows = 0;
        if(a==first || a==second || a==third || a==forth){
            cows = 1;
        }
        return cows;
    }

    public int getBulls(int a, int ID){
        int bulls = 0;
        if((a==first && ID==FIRST) || (a==second && ID==SECOND) || (a==third && ID==THIRD) || (a==forth && ID==FORTH)){
            bulls = 1;
        }
        return bulls;
    }
}

