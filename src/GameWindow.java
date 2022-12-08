import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWindow extends JPanel implements MouseListener {

    Ball ball;
    ScheduledExecutorService exec;

    GameWindow(){
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setLayout(null);
        this.addMouseListener(this);

        exec = Executors.newSingleThreadScheduledExecutor();

        ball = new Ball(100, 100, 25, 25);
    }

    public void startGame(){
        exec.scheduleAtFixedRate(() -> {
            ball.updatePos();
            repaint();
        }, 0, 30, TimeUnit.MILLISECONDS);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        ball.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        ball.initialPosX = e.getX();
        ball.initialPosY = e.getY();
        ball.canMove = false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ball.mouseX = e.getX();
        ball.mouseY = e.getY();
        ball.canMove = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
