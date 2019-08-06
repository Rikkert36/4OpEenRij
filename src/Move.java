import java.util.ArrayList;

public class Move {

    String player; //player that makes the move
    int column; //column of disc
    int row;
    Board boardA; //Initial board before move
    Board boardB; //Board after move

    //Whether this move makes four in a row
    boolean winningMove = false;

    Move(String player, int column, Board boardA) {
        this.player = player;
        this.column = column;
        this.boardA = boardA;
        computeBoardB();
    }

    /**
     * Set BoardB with boardA and move
     */
    void computeBoardB() {
        boardB = boardA.copyBoard();
        boardB.board[boardB.progress[column]][column] = player;
        row = boardB.progress[column];
        boardB.progress[column]--;
        computeWhetherWinningMove();
    }

    /**
     * Checks whether board is winning by checking all four directions
     */
    void computeWhetherWinningMove() {
        computeWinningVertical();
        computeWinningHorizontal();
        computeWinningDL_UR();
        computeWinningUL_DR();
    }

    private void computeWinningVertical() {
        int counter = 0;
        int rows = boardB.rows;
        String[][] board = boardB.board;

        for (int i = 0; i < rows; i++) {
            if (board[i][column] == player) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 4) winningMove = true;
        }
    }

    private void computeWinningHorizontal() {
        int counter = 0;
        int columns = boardB.columns;
        String[][] board = boardB.board;

        for (int j = 0; j < columns; j++) {
            if (board[row][j] == player) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 4) winningMove = true;
        }
    }

    private void computeWinningUL_DR(){
        int counter = 0;
        int columns = boardB.columns;
        int rows = boardB.rows;
        String[][] board = boardB.board;
        ArrayList<String> line = new ArrayList<>();

        line.add(board[row][column]);

        int i = row - 1;
        int j = column - 1;
        while (i >= 0 && j >= 0) {
            line.add(0, board[i][j]);
            i--;
            j--;
        }
        int x = row + 1;
        int y = column + 1;
        while (x < rows && y < columns) {
            line.add(board[x][y]);
            x++;
            y++;
        }

        int lineLength = line.size();
        for (int q = 0; q < lineLength; q++ ) {
            if (line.get(q) == player) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 4) winningMove = true;
        }
    }

    private void computeWinningDL_UR(){
        int counter = 0;
        int columns = boardB.columns;
        int rows = boardB.rows;
        String[][] board = boardB.board;
        ArrayList<String> line = new ArrayList<>();

        line.add(board[row][column]);

        int i = row + 1;
        int j = column - 1;
        while (i < rows && j >= 0) {
            line.add(0, board[i][j]);
            i++;
            j--;
        }
        int x = row - 1;
        int y = column + 1;
        while (x >= 0 && y < columns) {
            line.add(board[x][y]);
            x--;
            y++;
        }

        int lineLength = line.size();
        for (int q = 0; q < lineLength; q++ ) {
            if (line.get(q) == player) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 4) winningMove = true;
        }
    }


}
