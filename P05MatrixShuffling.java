package MultidimensionalArrays.Exc;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeEl = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizeEl[0]);
        int cols = Integer.parseInt(sizeEl[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            matrix[row] = rowInput;
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            String keyWord = command[0];

            if (command.length == 5 && keyWord.equals("swap")) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                if ((row1 >= 0 && row1 < rows) && (row2 >= 0 && row2 < rows)
                        && (col1 >= 0 && col1 < cols) && (col2 >= 0 && col2 < cols)) {
                    assignNewValues(matrix, row1, col1, row2, col2);

                    printMatrix(rows, cols, matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
        
    }

    private static void assignNewValues(String[][] matrix, int row1, int col1, int row2, int col2) {
        String one = matrix[row1][col1];
        String two = matrix[row2][col2];
        matrix[row1][col1] = two;
        matrix[row2][col2] = one;
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
