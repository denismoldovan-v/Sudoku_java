import main.generator.Generator;
import main.generator.Levels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelsTest {

    @Test
    void restrict() {
        // Dane wejściowe
        int level = 1; // Możesz zmienić poziom, aby przetestować różne przedziały
        Generator sudoku = new Generator(9, 0); // Ustaw wymiary planszy Sudoku

        // Wykonanie
        Levels.restrict(level, sudoku);

        // Sprawdzenie
        // Możesz dodać asercje, aby zweryfikować, czy ilość usuniętych cyfr mieści się w oczekiwanym przedziale.
        int nonZeroCount = countNonZeroCells(Generator.mat);
        assertTrue(nonZeroCount >= 20 && nonZeroCount <= 30); // Dla poziomu 1
        // Możesz dostosować asercje do oczekiwanego przedziału dla innych poziomów.
    }

    private int countNonZeroCells(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
