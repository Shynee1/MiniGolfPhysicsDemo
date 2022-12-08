import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OutputWindow extends JFrame  {

    OutputWindow(){
        this.setSize(1000, 1000);
        this.setName("Mini Golf");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        GameWindow game = new GameWindow();

        this.add(game);

        this.setVisible(true);

        game.startGame();

    }




}
