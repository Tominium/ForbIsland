package Graphics;
import javax.swing.*;
import java.awt.*;

public class HelpMenu extends JFrame {
    JLabel label = new JLabel();
    private JFrame helpMenu;
    private JTextPane pane;
    private JMenuBar menuBar;
    private JPanel pgOne, pgTwo, pgThree, pgFour, pgFive, pgSix, pgSeven, pgEight;
    private JLabel helpTitle;
    private static int WIDTH = 800;
    private static int HEIGHT = 1000;

    public HelpMenu() {
        super("Help Menu");

        Container win = getContentPane();
        JLabel heading = new JLabel("Help Menu");
        heading.setSize(750, 60);
        heading.setFont(new Font("Calibri", Font.BOLD, 50));
        heading.setForeground(new Color(0, 0, 0));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        win.add(heading);
        helpMenu.getContentPane().add(heading);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        add(new Panel());
        setVisible(true);
    }


}
