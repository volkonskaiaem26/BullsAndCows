package com.example.BulsAndCows.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NumberInt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int first;
    private int second;
    private int third;
    private int forth;

    public NumberInt(){}

    public NumberInt(int number){
        this.first = number/1000;
        this.second = (number%1000)/100;
        this.third = (number%100)/10;
        this.forth = number%10;
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
        if((a==first && ID==1) || (a==second && ID==2) || (a==third && ID==3) || (a==forth && ID==4)){
            bulls = 1;
        }
        return bulls;
    }
}

