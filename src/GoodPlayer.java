import java.util.ArrayList;

public class GoodPlayer extends Player {

    GoodPlayer(String symbol, CurrentState currentState){
        super(symbol, currentState);
    }

    @Override
    int determineMove(Board board) {
        return 0;
    }

    /**
     *Get all moves for board, these boards can later be evaluated
     */
    ArrayList<Move> getMoves() {
        for (int i = 0; i < 7; i++) {
            //Move move = new Move()
        }
        return null;

    }

    //TODO Minmax

    //TODO Evaluation

}
