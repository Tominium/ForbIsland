package Graphics;

import Logic.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class MainMenuFrame extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 563;
    private Font font;
    private Timer t;
    int x;

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

        JLabel intro = new JLabel("Press anywhere to begin");
        intro.setSize(300, 100);
        //intro.setForeground(new Color(255, 255, 255));
        intro.setLocation(410,400);
        intro.setFont(new Font("Myriad Pro",Font.PLAIN,12));
        intro.setVisible(false);
        win.add(intro);

        JLabel hehe = new JLabel("Enjoy the scenery!");
        hehe.setSize(250,100);
        hehe.setLocation(430,400);
        hehe.setFont(new Font("Myriad Pro",Font.PLAIN,12));
        hehe.setVisible(false);
        win.add(hehe);

        t = new Timer(1000, new ActionListener() {
            int x = 0;
            public void actionPerformed(ActionEvent e) {
                x++;
                if(x<20) {
                    if (x % 2 == 0)
                        intro.setVisible(false);
                    else
                        intro.setVisible(true);
                }
                if(x==20)
                    intro.setVisible(false);
                if(x==21)
                    hehe.setVisible(true);
                if(x==23) {
                    hehe.setVisible(false);
                    t.stop();
                }
            }
        });
        t.setInitialDelay(2000);
        t.start();

        JLabel heading = new JLabel("Forbidden Island");
        heading.setSize(750, 60);
        heading.setFont(font);
        heading.setForeground(new Color(255, 255, 255));
        heading.setLocation(175,40);
        heading.setVisible(false);
        win.add(heading);

        Object[] playerNums = {"Select Number of Players", 2, 3, 4};
        JComboBox list = new JComboBox(playerNums);
        list.setSelectedIndex(0);
        list.setBounds(380, 170,200,35);
        list.setVisible(false);
        win.add(list);

        Object[] waterLevel = {"Select Water Level", "Novice", "Normal", "Elite", "Legendary"};
        JComboBox level = new JComboBox(waterLevel);
        level.setSelectedIndex(0);
        level.setBounds(380, 300,200,35);
        level.setVisible(false);
        win.add(level);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(380, 430, 200, 35);
        startButton.setVisible(false);
        win.add(startButton);
        JFrame frame = this;
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex() != 0 && level.getSelectedIndex() != 0){new GameState((int)list.getSelectedItem(), (String)level.getSelectedItem()); dispose();}
                else if(list.getSelectedIndex()==0 && level.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(frame,
                        "Please Choose The Number Of Players And Select The Water Level",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
                else if(list.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(frame,
                            "Please Choose The Number Of Players",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(frame,
                        "Please Select The Water Level",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton helpButton = new JButton("Help");
        helpButton.setBounds(850, 430, 70, 35);
        helpButton.setVisible(false);
        win.add(helpButton);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpMenu();
            }
        });

        setSize(WIDTH, HEIGHT);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setResizable(false);
        add(new Panel());
        setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/Assets/0001-0250-1.gif"));
        //imgIcon.setImage(imgIcon.getImage().getScaledInstance(1500, 844, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(imgIcon);
        label.setSize(screenSize);
        label.setLocation(-470,-295);
        this.getContentPane().add(label);


        JButton start = new JButton();
        start.setBounds(0,0 , this.WIDTH,this.HEIGHT);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        win.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helpButton.setVisible(true);
                startButton.setVisible(true);
                list.setVisible(true);
                level.setVisible(true);
                heading.setVisible(true);
                intro.setVisible(false);
                t.stop();
            }
        });
    }
}
