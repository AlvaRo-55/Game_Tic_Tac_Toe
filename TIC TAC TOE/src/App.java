
import javax.swing.*;
import tictactoe.Board;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe ");
        Board board = new Board();
        frame.add(board);
        frame.setSize(400, 400);
        board.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


