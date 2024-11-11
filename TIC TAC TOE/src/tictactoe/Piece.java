package tictactoe;
import java.awt.Graphics;
import java.awt.Point;
public class Piece {
    private char type;

    public Piece(Point position, char type) {
        this.type = type;
    }

    public void draw(Graphics g) {
    }

    public char getType() {
            return type;
    }
}
