package com.example.BulsAndCows;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private final Random random = new Random();

    public int[] generateSecret() {
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = random.nextInt(10);
        }
        return digits;
    }

    public BullsCowsResult countBullsAndCows(int[] secret, int[] guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < 4; i++) {
            if (secret[i] == guess[i]) {
                bulls++;
            } else {
                secretCount[secret[i]]++;
                guessCount[guess[i]]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }
        return new BullsCowsResult(bulls, cows);
    }

    public int[] numberToArray(int number) {
        if (number < 0 || number > 9999) {
            throw new IllegalArgumentException("Число должно быть от 0 до 9999");
        }
        int[] digits = new int[4];
        digits[0] = number / 1000;
        digits[1] = (number % 1000) / 100;
        digits[2] = (number % 100) / 10;
        digits[3] = number % 10;
        return digits;
    }
}