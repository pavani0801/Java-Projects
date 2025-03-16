import java.util.Scanner;

public class Connect4 {

    private static void intro() {
        System.out.println("Welcome to Connect4!");
        System.out.println("Instructions: Out of two players , each one of them will get the opportunity to choose the column inorder to drop their disc.");
        System.out.println("The first player to connect four discs in a row, column, or diagonal wins!");
    }
    private static void initializeGrid(int[][] grid) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = 0;
            }
        }
    }

    private static int readMove(int currentPlayer) {
        Scanner kbd = new Scanner(System.in);
        int column;
        System.out.println("Player " + currentPlayer + ", choose from 1-7");
        column = kbd.nextInt() - 1;
        return column;
    }

    private static void performMove(int column, int[][] grid, int currentPlayer) {
        for (int i = 5; i >= 0; i--) {
            if (grid[i][column] == 0) {
                grid[i][column] = currentPlayer;
                break;
            }

        }
    }

    private static boolean checkEndgame(int[][] grid) {
        // Check rows
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j] && grid[i][j] == grid[i + 2][j] && grid[i][j] == grid[i + 3][j]) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i][j + 1] && grid[i][j] == grid[i][j + 2] && grid[i][j] == grid[i][j + 3]) {
                    return true;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j + 1] && grid[i][j] == grid[i + 2][j + 2] && grid[i][j] == grid[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 3; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j - 1] && grid[i][j] == grid[i + 2][j - 2] && grid[i][j] == grid[i + 3][j - 3]) {
                    return true;
                }
            }
        }

        // Check if grid is full
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }

            }
        }
        return true;
    }

    private static void displayGrid(int[][] grid) {
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                if (grid[i][j] == 1) {
                    System.out.print(" X ");
                } else if (grid[i][j] == 2) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+------------------------+");
    }
    private static void credits()
    {
        System.out.println("Thankyou for playing Connect4 Game!!!");
        System.out.println("Developed by Pavani Parasuramuni");
        System.out.println("Course :- Software Development | , course number:- CMPT_220L_112_24S");
        System.out.println("Semester 1");
    }

    public static void main(String args[]) {
        intro();
        int[][] grid = new int[6][7];
        int currentPlayer = 1;

        initializeGrid(grid);
        while (true) {
            int column = readMove(currentPlayer);
            performMove(column, grid, currentPlayer);
            displayGrid(grid);
            if (checkEndgame(grid)) {
                if (currentPlayer == 1) {
                    System.out.println("Player 1 wins");
                } else if(currentPlayer==2){
                    System.out.println("Player 2 Wins");
                }
                else {
                    System.out.println("It's a draw");
                }
                break;
            }
            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
        }
        credits();
    }
}
