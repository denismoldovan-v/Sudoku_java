package main.wzor;

import java.util.ArrayList;

public class BoardState {//umożliwia sprawdzanie i uzyskiwanie poprawnych cyfr dla danej pozycji na planszy
    public int[][] grid;

    public BoardState(int[][] grid) {
        this.grid = grid;
    }

    public int[] getValidNumbers(int row, int col) { //Zwraca tablicę zawierającą poprawne numery (1-9) dla danej pozycji na planszy
        ArrayList<Integer> validNumbers = new ArrayList<>();

        for (int num = 1; num <= 9; num++) {
            if (isValidMove(row, col, num)) {
                validNumbers.add(num);
            }
        }

        int[] result = new int[validNumbers.size()];
        for (int i = 0; i < validNumbers.size(); i++) {
            result[i] = validNumbers.get(i);
        }

        return result;
    }
    private boolean isValidMove(int row, int col, int num) {//Sprawdza, czy ruch o określonym numerze jest poprawny
        return isValidInRow(row, num) && isValidInColumn(col, num) && isValidInBox(row, col, num);
    }

    private boolean isValidInRow(int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (grid[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInColumn(int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (grid[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInBox(int startRow, int startCol, int num) {
        int boxSize = 3;
        int startRowBox = startRow - startRow % boxSize;
        int startColBox = startCol - startCol % boxSize;

        for (int row = 0; row < boxSize; row++) {
            for (int col = 0; col < boxSize; col++) {
                if (grid[row + startRowBox][col + startColBox] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
