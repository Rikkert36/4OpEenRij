import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {


    HumanPlayer(String symbol, CurrentState currentState) {
        super(symbol, currentState);
        name = "Human Player";
    }

    @Override
    int determineMove(Board board) {
        int column;
        while (true) {

            currentState.lastMove = -1;
            System.out.println("we gaan kijken");
            while (currentState.lastMove < 0) {
                System.out.println("wacht op input");
            }
            column = currentState.lastMove;
            if (checkIfValidMove(column)) {

                break;
            }
        }
        return column;
    }





}
