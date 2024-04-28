package main.generator;
import main.generator.Zapis;


import main.generator.Odczyt;
import main.wzor.BacktrackingSolver;
import main.wzor.PatternGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Generator {
   public static int[][] mat; //Sudoku board
    int[][] initialMat; // Store the initial Sudoku state
    int N; // number of columns/rows.
    int SRN; // square root of N
    int K; // No. Of missing digits

    // Konstruktor
    public Generator(int N, int K) {
        this.N = N;
        this.K = K;

        // Oblicza pierwiastek kwadratowy z N
        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();

        mat = new int[N][N];
    }

    // poczatkowy wzor sudoku
    public void fillValues() {
        PatternGenerator terminalGenerator = new PatternGenerator();
        initialMat = terminalGenerator.createPattern();
        mat = new int[initialMat.length][];
        for (int i = 0; i < initialMat.length; i++) {
            mat[i] = Arrays.copyOf(initialMat[i], initialMat[i].length);
        }
    }

    // usuwa K liczb z planszy
    // kompletna gra
    public void removeKDigits(int total) {
        int count = total;
        while (count != 0) {
            int cellId = randomGenerator(N * N) - 1;

            int i = cellId / N; //indeks wiersza i
            int j = cellId % N;//indeks kolumny j
            if (j != 0)
                j = j - 1;

            if (mat[i][j] != 0) {
                count--;
                mat[i][j] = 0;// jeśli wartość w punkcie nie jest równa 0 to ustawia ją na 0
            }
        }
    }

    // Random generator
    private int randomGenerator(int num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    // Print sudoku
    public void printSudoku(boolean printToFile, String fileName) {
        if (!solveSudoku()) {
            System.out.println("Error: Unable to solve Sudoku.");
            return;
        }

        if (printToFile) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writeSudokuToFile(writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Solved Sudoku Puzzle:");
            PatternGenerator.printSudokuToTerminal(mat);
        }
    }

    public boolean solveSudoku() {
        BacktrackingSolver solver = new BacktrackingSolver();
        if (BacktrackingSolver.gridSolver(mat)) {
            System.out.println("Sudoku Puzzle is Solvable:");
            PatternGenerator.printSudokuToTerminal(mat);
            //Zapis.writeSudokuToFile("solved.txt",mat);
        } else {
            System.out.println("Error: Unable to solve Sudoku.");
        }
        return BacktrackingSolver.gridSolver(mat);
    }

    private void writeSudokuToFile(PrintWriter writer) {
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                writer.println();
            }
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0 && j != 0) {
                    writer.print("  ");
                }
                writer.print(mat[i][j] + "  ");
            }
            writer.println();
        }
    }
}
