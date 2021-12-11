package SpaceX05.Mediator;

import SpaceX05.GameCanvas;
import SpaceX05.Settings;

import javax.swing.*;
import java.awt.*;

import static SpaceX05.Commons.BOARD_WIDTH;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class GamePanel implements Mediator{
    private StartButton startButton;
    private ExitButton exitButton;
    private SettingsButton settingsButton;
    private JFrame frame;

    private JPanel panel;
    public static JTextArea editTextArea = new JTextArea(GameCanvas.SERVER_IP.get());
    public GamePanel (JFrame jFrame){
        this.frame = jFrame;
        this.panel = new JPanel();
    }
    @Override
    public void startNewGame() {
        GameCanvas canvas = new GameCanvas(2);
        if (!canvas.isWorked()) {
            frame.remove(panel);
            JPanel newPanel = new JPanel();
            JLabel newLabel = new JLabel("Waiting for players");
            newPanel.add(newLabel);
            frame.add(newPanel);
        } else {
            frame.remove(panel);
            frame.add(canvas);
            frame.setTitle("Space Invaders");
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.setSize(BOARD_WIDTH, BOARD_WIDTH);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setResizable(false);
        }
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void saveChanges() {
        frame.remove(panel);
        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(BOARD_WIDTH, BOARD_WIDTH);
        frame.setLocationRelativeTo(null);
        JPanel settingsPanel = new JPanel();
        String settings = String.format("Height: %d",Settings.getInstance().Board_Height);
        JLabel setting = new JLabel(settings);
        setting.setPreferredSize(new Dimension(85,25));
        settingsPanel.add(setting);

        settings = String.format("Width: %d",Settings.getInstance().Board_Width);
        JLabel setting2 = new JLabel(settings);
        setting2.setPreferredSize(new Dimension(85,25));
        settingsPanel.add(setting2);

        JButton returnToMain = new JButton("Return");
        settingsPanel.add(returnToMain);

        editTextArea.setBackground(Color.white);
        editTextArea.setForeground(Color.black);
        editTextArea.setLocation(new Point(200,50));

        editTextArea.setPreferredSize(new Dimension(85,25));
        settingsPanel.add(editTextArea, BorderLayout.CENTER);
        frame.add(settingsPanel);
        frame.setVisible(true);
        returnToMain.addActionListener(e -> {
            settingsPanel.setVisible(false);
            GameCanvas.SERVER_IP.set(editTextArea.getText());
            createMainGui();
            });

    }

    @Override
    public void createMainGui() {

        panel.setBackground(Color.BLACK);
        frame.setSize(BOARD_WIDTH, BOARD_WIDTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setIgnoreRepaint(true);

        startButton.setPreferredSize(new Dimension(85,25));
        settingsButton.setPreferredSize(new Dimension(85,25));
        exitButton.setPreferredSize(new Dimension(85,25));
        panel.add(startButton);
        panel.add(settingsButton);
        panel.add(exitButton);
        frame.add(panel);
    }

    @Override
    public void hideElements(boolean flag) {
        startButton.setVisible(flag);
        exitButton.setVisible(flag);
        settingsButton.setVisible(flag);
    }

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()){
            case "StartButton":
                startButton = (StartButton) component;
                break;
            case "ExitButton":
                exitButton = (ExitButton) component;
                break;
            case "SettingsButton":
                settingsButton = (SettingsButton) component;
                break;

        }
    }
}
