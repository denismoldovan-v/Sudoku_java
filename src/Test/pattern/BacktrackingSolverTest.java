package pattern;

import main.wzor.BacktrackingSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingSolverTest {

    @Test
    void gridSolver() {
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

        // Wykonanie
        boolean result = BacktrackingSolver.gridSolver(grid);

        // Sprawdzenie
        assertTrue(result);

        // Dodaj więcej asercji w zależności od oczekiwań.
    }

    @Test
    void solver() {
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

        // Wykonanie
        int[][] result = BacktrackingSolver.solver(grid);

        // Sprawdzenie
        // Możesz dodać asercje, aby zweryfikować poprawność wyniku w zależności od oczekiwań.
        assertNotNull(result);

        // Dodaj więcej asercji w zależności od oczekiwań.
    }
}
