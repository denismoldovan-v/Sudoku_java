package main.wzor;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class PatternGenerator {
    private static final int givens = 11;
    private static int[][] patternSudoku;

    public static int[][] createPattern() {
        int[][] emptyGrid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        boolean underTimeLimit = false;
        BoardState board = new BoardState(emptyGrid);

        while (!underTimeLimit) {
            int randomRow;
            int randomCol;
            int trialNum;

            int[] validNums;
            boolean validTrial;
            int givensCount = 0;
            while (givensCount < givens) {
                randomRow = ThreadLocalRandom.current().nextInt(0, 9);
                randomCol = ThreadLocalRandom.current().nextInt(0, 9);
                trialNum = ThreadLocalRandom.current().nextInt(1, 10);

                validNums = board.getValidNumbers(randomRow, randomCol);

                validTrial = false;
                for (int n : validNums) {
                    if (n == trialNum) {
                        validTrial = true;
                        break;
                    }
                }

                if (validTrial) {
                    board.grid[randomRow][randomCol] = trialNum;
                    givensCount++;
                }
            }

            boolean solutionFound = BacktrackingSolver.gridSolver(board.grid);

            if (solutionFound) {
                underTimeLimit = true;
            }
        }
        patternSudoku = new int[board.grid.length][];
        for (int i = 0; i < board.grid.length; i++) {
            patternSudoku[i] = Arrays.copyOf(board.grid[i], board.grid[i].length);
        }
        return patternSudoku;
    }

    public static void printSudokuToTerminal(int[][] sudoku) {
        int N = sudoku.length;

        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("  ");
                }
                System.out.print(sudoku[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] getPatternSudoku() {
        int[][] copy = new int[patternSudoku.length][];
        for (int i = 0; i < patternSudoku.length; i++) {
            copy[i] = Arrays.copyOf(patternSudoku[i], patternSudoku[i].length);
        }
        return copy;

    }
    public static void setPatternSudoku(int[][] sudoku) {
        patternSudoku = new int[sudoku.length][];
        for (int i = 0; i < sudoku.length; i++) {
            patternSudoku[i] = Arrays.copyOf(sudoku[i], sudoku[i].length);
        }
    }
}
