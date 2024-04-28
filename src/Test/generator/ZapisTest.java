import main.generator.Zapis;
import main.generator.Zapis;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class ZapisTest {

    @Test
    void writeSudokuToFile() {
        // Dane wejściowe
        String filename = "testfile.txt";
        int[][] sudokuGrid = {
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
        assertDoesNotThrow(() -> Zapis.writeSudokuToFile(filename, sudokuGrid));

        // Sprawdzenie
        // Weryfikacja, czy plik został poprawnie zapisany
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 9) {
                String[] values = line.trim().split("\\s+");
                for (int col = 0; col < 9; col++) {
                    int expectedValue = sudokuGrid[row][col];
                    int actualValue = Integer.parseInt(values[col]);
                    assertEquals(expectedValue, actualValue);
                }
                row++;
            }
        } catch (IOException e) {
            fail("Error reading from file: " + e.getMessage());
        }
    }
}
