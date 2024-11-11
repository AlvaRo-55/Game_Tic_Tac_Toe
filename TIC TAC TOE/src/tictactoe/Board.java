package tictactoe;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Board extends Canvas implements MouseListener {
    private Image fondo;
    private char[][] grid;
    private boolean xTurn;

    public Board() {
        this.grid = new char[3][3];
        this.xTurn = true;
        addMouseListener(this);
        try {
            fondo = ImageIO.read(new File("C:/Users/alvar/OneDrive/Escritorio/tic tac toe/TIC TAC TOE/res/texture/fondo.jpeg"));
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen de fondo.");
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ((Graphics2D) g).setStroke(new BasicStroke(2)); 

        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }

        int cellSize = Math.min(getWidth(), getHeight()) / 3;

        g.setColor(Color.BLACK);
        for (int i = 1; i < 3; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, getHeight());
            
            g.drawLine(0, i * cellSize, getWidth(), i * cellSize);
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == 'X') {
                    g.setColor(Color.RED);
                    g.drawLine(col * cellSize + 20, row * cellSize + 20, (col + 1) * cellSize - 20, (row + 1) * cellSize - 20);
                    g.drawLine((col + 1) * cellSize - 20, row * cellSize + 20, col * cellSize + 20, (row + 1) * cellSize - 20);
                } else if (grid[row][col] == 'O') {
                    g.setColor(Color.BLUE);
                    g.drawOval(col * cellSize + 20, row * cellSize + 20, cellSize - 40, cellSize - 40);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / (getHeight()/3);
        int col = e.getX() / (getWidth()/3);

        if (grid[row][col] == '\0') {
            grid[row][col] = xTurn ? 'X' : 'O';
            xTurn = !xTurn;
            repaint(); 
            GameLogic logic = new GameLogic(grid);
            char winner = logic.checkWinner();
            
            if (winner != '\0') {
                JOptionPane.showMessageDialog(this, "El ganador es: " + winner );
                resetGame();
            } else if (logic.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "Empate");
                resetGame();
            }
        }
    }

    private void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = '\0';
            }
        }
        xTurn = true;
        repaint();
        }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    }
