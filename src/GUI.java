import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class GUI {

    Canvas canvas;
    JPanel canvasPanel;
    private JPanel panel1;

    int rows = 6;
    int columns = 7;

    GUI() {
        JFrame frame = new JFrame("4 op een rij");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CurrentState currentState = new CurrentState(new Board(rows, columns), new ArrayList<Move>());

        canvas = new Canvas(currentState);
        canvasPanel.setLayout(new BorderLayout(0, 0));
        canvasPanel.add(canvas);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 600);
        frame.setLocation(100, 50);

        Game game = new Game(rows, columns, currentState);

    }



}
