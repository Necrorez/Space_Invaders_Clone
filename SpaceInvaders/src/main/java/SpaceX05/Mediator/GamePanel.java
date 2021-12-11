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

        String settings = String.format("Height: %d",Settings.getInstance().Board_Height);
        JLabel setting = new JLabel(settings);
        setting.setPreferredSize(new Dimension(85,25));
        panel.add(setting);

        settings = String.format("Width: %d",Settings.getInstance().Board_Width);
        JLabel setting2 = new JLabel(settings);
        setting2.setPreferredSize(new Dimension(85,25));
        panel.add(setting2);

        JButton returnToMain = new JButton("Return");
        panel.add(returnToMain);
        frame.add(panel);
        frame.setVisible(true);
        returnToMain.addActionListener(e -> {
            frame.remove(panel);
            panel.remove(setting);
            panel.remove(setting2);
            panel.remove(returnToMain);
            frame.add(panel);
            frame.setVisible(true);
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
