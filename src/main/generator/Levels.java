package main.generator;

import java.util.Random;

public class Levels {
    private static int total;
    private static int bound;

    public static void restrict(int level, Generator sudoku) {
        Random random = new Random();
        int totalMin;
        int totalMax;

        switch (level) {
            case 1:
                totalMin = 20;
                totalMax = 30;
                break;

            case 2:
                totalMin = 30;
                totalMax = 40;
                break;

            case 3:
                totalMin = 40;
                totalMax = 50;
                break;

            default:
                totalMin = 20;
                totalMax = 30;
                break;
        }

        total = random.nextInt((totalMax - totalMin) + 1) + totalMin;
        bound = total;

        sudoku.removeKDigits(total);
    }
}
