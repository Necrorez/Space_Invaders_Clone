package SpaceX05;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Client extends JFrame implements Commons
{

    /**
     * TODO | DOING | DONE
     * DONE
     * Main method to start the game window
     * @param args
     */
    @SuppressWarnings("SSDoc")
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Client().setVisible(true));
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for the Client
     */
    @SuppressWarnings("SSDoc")
    public Client() {
        //Set up panel
        super("Space Invaders");
        final JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        JButton start = new JButton("Begin Co-op");
        JButton exit = new JButton("Exit");
        panel.add(start);
        panel.add(exit);
        this.add(panel);

        //Set up more stuff
        setSize(BOARD_WIDTH, BOARD_WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setIgnoreRepaint(true);

        start.addActionListener(e -> {
            GameCanvas canvas = new GameCanvas(2);
            if (!canvas.isWorked()) {
                dispose();
            } else {
                remove(panel);
                add(canvas);
                setTitle("Space Invaders");
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setSize(BOARD_WIDTH, BOARD_WIDTH);
                setLocationRelativeTo(null);
                setVisible(true);
                setResizable(false);
            }
        });

        exit.addActionListener(e -> System.exit(0));



    }


}