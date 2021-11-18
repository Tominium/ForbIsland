package Graphics;
import javax.swing.*;
import java.awt.*;

public class HelpMenu extends JFrame {
    JLabel label = new JLabel();
    private JFrame helpMenu;
    private JTextPane pane;
    private JButton back;
    private JPanel pgOne, pgTwo, pgThree, pgFour, pgFive, pgSix, pgSeven, pgEight;
    private JLabel helpTitle;
    private static int WIDTH = 800;
    private static int HEIGHT = 1000;

    public HelpMenu() {
        super("Help Menu");

        Container win = getContentPane();
        win.setLayout(null);

        helpTitle = new JLabel("Help Menu");
        JLabel heading = new JLabel("Help Menu");
        heading.setSize(750, 60);
        heading.setFont(new Font("Calibri", Font.BOLD, 50));
        heading.setForeground(new Color(98, 98, 103, 255));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        win.add(heading);

        back = new JButton("Back");
        back.setSize(100,45);
        back.setFont(new Font("Calibri", Font.BOLD, 14));
        back.setForeground(new Color(98, 98, 103,255));
        back.setLocation(30,45);
        win.add(back);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        //add(new Panel());
        setVisible(true);
    }


}
