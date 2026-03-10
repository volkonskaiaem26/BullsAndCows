package com.example.BulsAndCows.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="numbers")
public class NumberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private NumberInt number;

    @Column
    private int bulls;

    @Column
    private int cows;

    @Column
    private int result;

    public NumberInfo(NumberInt number){
        this.number = number;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public NumberInt getNumber() {
        return number;
    }

    public void setNumber(NumberInt number) {
        this.number = number;
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
