package main.generator;

import main.wzor.*;

import java.util.Arrays;
import java.util.Scanner;

public class SudokuGame {
    public static void playGame(int[][] sudoku) {
        Scanner scanner = new Scanner(System.in);
        int currentRow = 0;
        int currentCol = 0;

        while (true) {
            printSudokuWithCursor(sudoku, currentRow, currentCol);

            System.out.println("Enter a value (1-9) or use arrow keys (u/d/l/r) to move, 's' to solve, 'q' to quit:\n" +
                    "Instruction: u stands for Up, d - Down, l - left, r - right");

            String input = scanner.next();
            char firstChar = input.charAt(0);

            if (input.length() == 1 && Character.isDigit(firstChar)) {
                int value = Character.getNumericValue(firstChar);
                if (value >= 1 && value <= 9) {
                    sudoku[currentRow][currentCol] = value;
                }
            } else {
                switch (firstChar) {
                    case 'u':
                        currentRow = Math.max(0, currentRow - 1);
                        break;
                    case 'd':
                        currentRow = Math.min(8, currentRow + 1);
                        break;
                    case 'l':
                        currentCol = Math.max(0, currentCol - 1);
                        break;
                    case 'r':
                        currentCol = Math.min(8, currentCol + 1);
                        break;
                    case 's':
                        checkSudokuSolution(sudoku);
                        return;
                    case 'q':
                        return;
                }
            }
        }
    }

    private static void printSudokuWithCursor(int[][] sudoku, int currentRow, int currentCol) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("  ");
                }
                if (i == currentRow && j == currentCol) {
                    System.out.print("[" + sudoku[i][j] + "] ");
                } else {
                    System.out.print(sudoku[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void checkSudokuSolution(int[][] userSudoku) {

        System.out.println("\nYour Offered Solution:");
        PatternGenerator.printSudokuToTerminal(userSudoku);

        if (Arrays.deepEquals(PatternGenerator.getPatternSudoku(), userSudoku)) {
            System.out.println("You solved correctly!");
        } else {
            System.out.println("You solved incorrectly!");
        }

        System.out.println("Correct Solution:");
        PatternGenerator.printSudokuToTerminal(PatternGenerator.getPatternSudoku());
        Zapis.writeSudokuToFile("solved.txt", main.wzor.PatternGenerator.getPatternSudoku());
    }
}
