import java.util.Random;

/**
 * A testplayer that will do random moves
 */
public class RandomPlayer extends Player {
    Random r = new Random();

    RandomPlayer(String symbol, CurrentState currentState) {
        super(symbol, currentState);
        name = "Random Player";
    }

    @Override
    int determineMove(Board board) {
        int min = 0;
        int max = currentState.board.columns;
        int column = r.nextInt(max) + min;
        while (currentState.board.progress[column] < 0) {
            column = r.nextInt(max) + min;
        }

        return column;
    }
}
