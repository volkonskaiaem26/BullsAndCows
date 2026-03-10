package com.example.BulsAndCows.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "numbers")
public class NumberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private NumberInt number;

    @Column
    private int bulls;

    @Column
    private int cows;

    @Column
    private int result;

    public NumberInfo() {}

    public NumberInfo(NumberInt number) {
        this.number = number;
    }

    // геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public NumberInt getNumber() { return number; }
    public void setNumber(NumberInt number) { this.number = number; }
    public int getBulls() { return bulls; }
    public void setBulls(int bulls) { this.bulls = bulls; }
    public int getCows() { return cows; }
    public void setCows(int cows) { this.cows = cows; }
    public int getResult() { return result; }
    public void setResult(int result) { this.result = result; }
}