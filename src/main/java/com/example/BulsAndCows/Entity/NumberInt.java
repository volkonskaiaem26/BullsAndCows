package com.example.BulsAndCows.Entity;

import jakarta.persistence.*;

@Entity
public class NumberInt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int first;
    @Column(nullable = false)
    private int second;
    @Column(nullable = false)
    private int third;
    @Column(nullable = false)
    private int forth;

    public NumberInt() {}

    public NumberInt(int number) {
        if (number < 0 || number > 9999) {
            throw new IllegalArgumentException("Число должно быть от 0 до 9999");
        }
        this.first = number / 1000;
        this.second = (number % 1000) / 100;
        this.third = (number % 100) / 10;
        this.forth = number % 10;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getFirst() { return first; }
    public void setFirst(int first) { this.first = first; }
    public int getSecond() { return second; }
    public void setSecond(int second) { this.second = second; }
    public int getThird() { return third; }
    public void setThird(int third) { this.third = third; }
    public int getForth() { return forth; }
    public void setForth(int forth) { this.forth = forth; }


    public int[] toArray() {
        return new int[]{first, second, third, forth};
    }
}