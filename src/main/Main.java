package main;

import main.generator.*;
import main.wzor.BacktrackingSolver;
import main.wzor.PatternGenerator;

import java.util.Arrays;
import java.util.Scanner;


import static main.generator.Generator.mat;

public class Main {
    public static void main(String[] args) {
        int N = 9; //  9x9 Sudoku
        int K = 20;
        Odczyt odczyt = new Odczyt("generator/sudoku_input.txt");
        Scanner sc = new Scanner(System.in);

        System.out.println("Type - 1 if you want to play your own puzzle, type - other number if you want to play random puzzle");
        int y = sc.nextInt();
        sc.nextLine();
        Generator sudokuGenerator = new Generator(N, K);
        if(y == 1) {
            mat = Odczyt.reader();
            int [][] mat1 = new int[mat.length][];
            for (int i = 0; i < mat.length; i++) {
                mat1[i] = Arrays.copyOf(mat[i], mat[i].length);
            }
            PatternGenerator.printSudokuToTerminal(mat);
            BacktrackingSolver.solver(mat1);
            PatternGenerator.setPatternSudoku(mat1);

        } else {
            sudokuGenerator.fillValues();
            System.out.println("Choose level:");
            System.out.println("1 - Easy difficulty");
            System.out.println("2 - Medium difficulty");
            System.out.println("3 - Hard difficulty");
            int x = sc.nextInt();
            sc.nextLine();
            if (x > 0 && x < 4) {
                Levels.restrict(x, sudokuGenerator);
                System.out.println("\nModified Sudoku Puzzle (Difficulty Level " + x + "):");
                PatternGenerator.printSudokuToTerminal(mat);
            }
        }

        System.out.println("Type - 1 if you want to try it yourself, type - 2 if you need a solution, type 3 to save sudoku in a file: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            SudokuGame.playGame(mat);
        } else if (choice == 2) {
            sudokuGenerator.solveSudoku();
        }
        else if (choice == 3) {
            Zapis.writeSudokuToFile("src/main/solved1.txt", mat);
            System.out.println("Sudoku was saved successfully");
        }
    }
}

