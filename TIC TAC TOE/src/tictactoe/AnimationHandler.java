package tictactoe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AnimationHandler {
    private Timer timer;
    private Point currentPos;
    private Point targetPos;

    public AnimationHandler(Point start, Point end) {
        this.currentPos = start;
        this.targetPos = end;
        this.timer = new Timer(5, new AnimationListener());
        this.timer.start();
    }

    private class AnimationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Lógica para mover la ficha hacia la posición objetivo con animación
            if (currentPos.equals(targetPos)) {
                timer.stop();
            }
        }
    }
}
