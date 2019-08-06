import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    int rows;
    int columns;
    String winner;

    Player player1;
    Player player2;

    String p1 = "o";
    String p2 = "x";

    ArrayList<Move> moves;
    CurrentState currentState;

    Game(int rows, int columns, CurrentState currentState) {

        this.currentState = currentState;
        player1 = new HumanPlayer(p1, currentState);
        player2 = new RandomPlayer(p2, currentState);
        this.rows = rows;
        this.columns = columns;

        Play();
    }

    void Play() {
        int turn = 0;
        int turns = rows * columns;

        //Loop that will terminate if there is a winner or board is full
        while (true && turn < turns) {

            int move1 = player1.determineMove(currentState.board);
            currentState.doMove(p1, move1);

            if (currentState.moves.get(currentState.moves.size() - 1).winningMove) {
                winner = p1;
                break;
            }

            //Sleep thread that makes sure that bots will not make move instantly
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int move2 = player2.determineMove(currentState.board);
            currentState.doMove(p2, move2);

            if (currentState.moves.get(currentState.moves.size() - 1).winningMove) {
                winner = p2;
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (winner != null) {
            System.out.println("Winner: " + winner);
        } else {
            System.out.println("Draw");
        }
    }




}
