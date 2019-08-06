public class Board {

    int rows;
    int columns;

    String[][] board;

    int[] progress;

    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new String[rows][columns];

        //array that keeps track of amount of discs in each column, where 0 = full
        progress = new int[columns];
        fillProgress();
    }

    void fillProgress(){
        for(int i = 0; i < columns; i++) {
            progress[i] = rows - 1;
        }
    }

    /**
     * Function that makes copy of the board
     * @return new copy of the board
     */
    Board copyBoard(){
        Board newBoard = new Board(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                newBoard.board[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < columns; i++) {
            newBoard.progress[i] = progress[i];
        }
        return newBoard;
    }


}
