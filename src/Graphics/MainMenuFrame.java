package Graphics;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainMenuFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;
    private Font font;

    public MainMenuFrame(){
        super("Forbidden Island");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Assets/ForbiddenIsle.otf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        Container win = getContentPane();
        win.setLayout(null);

        JLabel heading = new JLabel("Forbidden Island");
        heading.setSize(750, 60);
        heading.setFont(font);
        heading.setForeground(new Color(255, 255, 255));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        win.add(heading);

        Object[] playerNums = {"Select Number of Players", 2, 3, 4};
        JComboBox list = new JComboBox(playerNums);
        list.setSelectedIndex(0);
        list.setBounds(300, 400,200,35);
        win.add(list);

        Object[] waterLevel = {"Select Water Level", "Novice", "Normal", "Elite", "Legendary"};
        JComboBox level = new JComboBox(waterLevel);
        level.setSelectedIndex(0);
        level.setBounds(300, 500,200,35);
        win.add(level);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(300, 600, 200, 35);
        win.add(startButton);

        JButton helpButton = new JButton("Help");
        helpButton.setBounds(300, 700, 200, 35);
        win.add(helpButton);


        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setResizable(false);
        add(new Panel());
        setVisible(true);
    }
}
