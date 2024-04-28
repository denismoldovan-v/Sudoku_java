package main.generator;

import java.io.FileWriter;
import java.io.IOException;

public class Zapis {

    public static void writeSudokuToFile(String filename, int[][] sudokuGrid) {
        try (FileWriter writer = new FileWriter(filename, false)) { // Ustawienie drugiego argumentu na false czysci plik przed zapisem
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 0 && i != 0) {
                    writer.write("\n");
                }
                for (int j = 0; j < 9; j++) {
                    if (j % 3 == 0 && j != 0) {
                        writer.write("  ");
                    }
                    writer.write(sudokuGrid[i][j] + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
