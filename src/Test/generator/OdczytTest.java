import main.generator.Odczyt;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OdczytTest {

    @Test
    void reader() {
        // Przygotowanie
        int[][] expectedSudokuGrid = {
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

        String filePath = "testSudokuFile.txt";
        createTestSudokuFile(filePath, expectedSudokuGrid);

        Odczyt odczyt = new Odczyt(filePath);

        // Wykonanie
        int[][] actualSudokuGrid = Odczyt.reader();

        // Sprawdzenie
        assertNotNull(actualSudokuGrid);
        assertArrayEquals(expectedSudokuGrid, actualSudokuGrid);

        // Usunięcie pliku testowego
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pomocnicza do utworzenia pliku z danymi Sudoku do testów
    private void createTestSudokuFile(String filePath, int[][] sudokuGrid) {
        try {
            File file = new File(filePath);
            file.createNewFile();

            StringBuilder content = new StringBuilder();
            for (int[] row : sudokuGrid) {
                for (int num : row) {
                    content.append(num).append(" ");
                }
                content.append("\n");
            }

            Files.write(Path.of(filePath), content.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
