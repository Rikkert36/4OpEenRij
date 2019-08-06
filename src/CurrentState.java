import java.util.ArrayList;

public class CurrentState {

    Board board;
    ArrayList<Move> moves;
    int lastMove;

    CurrentState(Board board, ArrayList<Move> moves) {
        this.board = board;
        this.moves = moves;
    }

    void doMove(String player, int column) {
        Move move = new Move(player, column, board);
        board = move.boardB;
        moves.add(move);
    }
}
