import java.util.ArrayList;

/**
 * Abstract player class
 */
abstract class Player {
    String symbol;
    CurrentState currentState;
    String name;

    Player(String symbol, CurrentState currentState) {
        this.symbol = symbol;
        this.currentState = currentState;
    }

    boolean checkIfValidMove(int column) {
        return column >= 0 && column < currentState.board.columns && currentState.board.progress[column] >= 0;
    }

    abstract int determineMove(Board board);
}
