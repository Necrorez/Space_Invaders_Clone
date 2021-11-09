package SpaceX05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Client extends JFrame implements Commons
{
    BufferStrategy strategy;
    Container c = getContentPane();

    public static void main(String[] args) throws IOException
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    public Client(){
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

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



    }
   /* public JPanel multiplayer() {
        JPanel panel = new JPanel();
        JLabel jlabel = new JLabel("This is a label");
        jlabel.setFont(new Font("Verdana",1,20));
        panel.add(jlabel);
        panel.setBackground(Color.BLACK);
        this.add(panel);
        return panel;
    }
    private static void networkSetup(){
        try {
            sock = new Socket("localhost", 4444);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Networking Established");

        } catch (IOException ex) {System.out.println("No network access");}
    }
    public static class IncomingReader implements Runnable {
        public void run() {
            try {
                while (reader.readLine() != null) {
                    System.out.println(reader.readLine());
                    writer.println("Test");
                }
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }*/

}