package pattern;

import main.wzor.BoardState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardStateTest {

    @Test
    void getValidNumbers() {
        // Dane wejściowe
        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 0, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        // Przygotowanie
        BoardState boardState = new BoardState(grid);
        int row = 2;
        int col = 2;

        // Wykonanie
        int[] validNumbers = boardState.getValidNumbers(row, col);

        // Sprawdzenie
        assertNotNull(validNumbers);
        assertEquals(4, validNumbers.length); // Oczekujemy, że dla pozycji (2,2) poprawne będą cyfry: 1, 6, 7, 9
        assertArrayEquals(new int[]{1, 6, 7, 9}, validNumbers);
    }
}
