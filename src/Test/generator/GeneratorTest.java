import main.generator.Generator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void fillValues() {
        // Dane wejściowe
        int N = 9; // Ustaw pożądany rozmiar planszy Sudoku
        int K = 20; // Ustaw ilość brakujących cyfr

        // Wykonanie
        Generator generator = new Generator(N, K);
        generator.fillValues();
        assertNotNull(Generator.mat);
        assertEquals(N, Generator.mat.length);
        assertEquals(N, Generator.mat[0].length);
        // Dodaj więcej asercji w oparciu o Twoje wymagania.
    }

    @Test
    void removeKDigits() {
        // Dane wejściowe
        int N = 9; // Ustaw pożądany rozmiar planszy Sudoku
        int K = 20; // Ustaw ilość cyfr do usunięcia
        Generator generator = new Generator(N, K);

        // Wykonanie
        generator.fillValues(); // Możesz musieć wywołać fillValues() przed usunięciem cyfr
        generator.removeKDigits(K);

        // Sprawdzenie
        // \ czy liczba niezerowych komórek jest równa N*N - K.
        int nonZeroCount = countNonZeroCells(Generator.mat);
        assertEquals(N * N - K, nonZeroCount);
        // Dodaj więcej asercji w oparciu o Twoje wymagania.
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

    @Test
    void printSudoku() {
        // Dane wejściowe
        int N = 9; // Ustaw pożądany rozmiar planszy Sudoku
        int K = 20; // Ustaw ilość brakujących cyfr
        Generator generator = new Generator(N, K);
        generator.fillValues();

        // Wykonanie
        // Zakładając, że masz metodę do drukowania do pliku, możesz chcieć przetestować tę funkcjonalność.
        // Dla prostoty, sprawdźmy tylko, czy nie występują wyjątki podczas drukowania do konsoli.
        assertDoesNotThrow(() -> generator.printSudoku(false, null));
        // Dodaj więcej asercji w oparciu o Twoje wymagania.
    }

    @Test
    void solveSudoku() {
        // Dane wejściowe
        int N = 9; // Ustaw pożądany rozmiar planszy Sudoku
        int K = 20; // Ustaw ilość brakujących cyfr
        Generator generator = new Generator(N, K);
        generator.fillValues();

        // Wykonanie
        boolean solved = generator.solveSudoku();

        // Sprawdzenie
        // Możesz dodać asercje, aby zweryfikować, czy układanka Sudoku została rozwiązana.
        assertTrue(solved);
        // Dodaj więcej asercji w oparciu o Twoje wymagania.
    }
}
