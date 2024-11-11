package tictactoe;

public class GameLogic {
    private char[][] grid;

    public GameLogic(char[][] grid) {
        this.grid = grid;
    }

    public char checkWinner() {

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != '\0' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return grid[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[0][i] != '\0' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return grid[0][i];
            }
        }
        if (grid[0][0] != '\0' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0];
        }
        if (grid[0][2] != '\0' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2];
        }

        return '\0';
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
