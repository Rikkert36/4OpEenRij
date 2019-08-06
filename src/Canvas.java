import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas extends JPanel implements MouseListener {

    CurrentState currentState;
    int discSize = 80;
    int upSpace = 50;
    int leftSpace = 100;
    int borderThickness = 5;

    int rows;
    int columns;
    int height;
    int length;

    Canvas(CurrentState currentState) {
        this.currentState = currentState;
        rows = currentState.board.rows;
        columns = currentState.board.columns;

        height = rows* discSize;
        length = columns * discSize;

        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDiscs(g);
        drawBoard(g);

        repaint();
    }


    private void drawBoard(Graphics g) {


        g.setColor(Color.black);
        g.fillRect(leftSpace, upSpace, borderThickness, height);
        g.fillRect(leftSpace,upSpace + height, length + borderThickness, borderThickness);

        for (int i = 0; i < columns; i++) {
            g.fillRect(leftSpace + discSize * (i+1), upSpace, borderThickness, height );
        }
    }

    private void drawDiscs(Graphics g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (currentState.board.board[i][j] == "x") {
                    g.setColor(Color.red);
                    g.fillOval(leftSpace +  j*discSize + (int)(borderThickness/1.45), upSpace +  i * discSize +
                                    (int)(borderThickness/1.45), (int)(discSize * 0.95), (int)(discSize * 0.95));
                } else if (currentState.board.board[i][j] == "o") {
                    g.setColor(Color.blue);
                    g.fillOval(leftSpace+ j*discSize + (int)(borderThickness/1.45), upSpace +  i * discSize +
                            (int)(borderThickness/1.45), (int)(discSize * 0.95), (int)(discSize * 0.95));

                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int column = getColumn(mouseEvent.getX(), mouseEvent.getY());
        currentState.lastMove = column;
        System.out.println(column);
    }

    private int getColumn(int x, int y){
        if (y < upSpace || y > upSpace + height) return -1;
        if (x < leftSpace || x > leftSpace + length) return -1;
        int column = (x-leftSpace)/discSize;
        return column;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
