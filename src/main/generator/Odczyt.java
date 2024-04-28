package main.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import main.wzor.PatternGenerator;

public class Odczyt {
    private static String filePath;

    public Odczyt(String filePath) {
        this.filePath = filePath;
    }

    public static int[][] reader() {
        int[][] sudokuGrid = new int[9][9];

        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            System.out.println("Wczytywanie cyfr Sudoku z pliku...");

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (fileScanner.hasNextInt()) {
                        sudokuGrid[i][j] = fileScanner.nextInt();
                    } else {
                        System.err.println("Błąd: Niewystarczająca liczba cyfr w pliku.");
                        System.exit(1);
                    }
                }
            }

            // Set the patternSudoku in PatternGenerator using the setter
            PatternGenerator.setPatternSudoku(sudokuGrid);

            return sudokuGrid;

        } catch (FileNotFoundException e) {
            System.err.println("Błąd: Nie znaleziono pliku.");
            e.printStackTrace();
            //return null; // Zwróć null w przypadku błędu
        }return null;
    }
}
