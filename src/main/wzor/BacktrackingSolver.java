package main.wzor;

public class BacktrackingSolver {

    public static boolean gridSolver(int[][] grid) {
        int N = grid.length;
        int SRN = (int) Math.sqrt(N);

        // Znajdź pustą komórkę
        int[] emptyCell = findEmptyCell(grid, N);
        int row = emptyCell[0];
        int col = emptyCell[1];

        // Jeśli nie ma pustych komórek, to plansza jest wypełniona
        if (row == -1 && col == -1) {
            return true;
        }

        // Spróbuj wypełnić komórkę od 1 do N
        for (int num = 1; num <= N; num++) {
            if (isValidMove(grid, row, col, num, N, SRN)) {
                // Jeśli ruch jest dozwolony, to ustaw wartość i rekurencyjnie rozwiązuj resztę planszy
                grid[row][col] = num;

                if (gridSolver(grid)) {
                    return true;  // Jeśli rozwiązanie znalezione, zwróć true
                }

                // Jeśli rozwiązanie nie zostało znalezione, cofnij ruch
                grid[row][col] = 0;
            }
        }

        // Brak rozwiązania dla danej planszy
        return false;
    }
    public static int[][] solver(int[][] grid) {
        int N = grid.length;
        int SRN = (int) Math.sqrt(N);

        // Znajdź pustą komórkę
        int[] emptyCell = findEmptyCell(grid, N);
        int row = emptyCell[0];
        int col = emptyCell[1];

        // Jeśli nie ma pustych komórek, to plansza jest wypełniona
        if (row == -1 && col == -1) {
            return grid;
        }

        // Spróbuj wypełnić komórkę od 1 do N
        for (int num = 1; num <= N; num++) {
            if (isValidMove(grid, row, col, num, N, SRN)) {
                // Jeśli ruch jest dozwolony, to ustaw wartość i rekurencyjnie rozwiązuj resztę planszy
                grid[row][col] = num;

                if (gridSolver(grid)) {
                    return grid;  // Jeśli rozwiązanie znalezione, zwróć true
                }

                // Jeśli rozwiązanie nie zostało znalezione, cofnij ruch
                grid[row][col] = 0;
            }
        }

        // Brak rozwiązania dla danej planszy
        return grid;
    }

    private static int[] findEmptyCell(int[][] grid, int N) {
        int[] result = {-1, -1};

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    result[0] = row;
                    result[1] = col;
                    return result;
                }
            }
        }

        return result;
    }

    private static boolean isValidMove(int[][] grid, int row, int col, int num, int N, int SRN) {
        // Sprawdź, czy num nie występuje w tej samej kolumnie i wierszu
        for (int x = 0; x < N; x++) {
            if (grid[row][x] == num || grid[x][col] == num) {
                return false;
            }
        }

        // Sprawdź, czy num nie występuje w tym samym podkwadracie SRN x SRN
        int startRow = row - row % SRN;
        int startCol = col - col % SRN;
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
