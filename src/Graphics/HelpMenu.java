package Graphics;
import javax.swing.*;
import java.awt.*;

public class HelpMenu extends JFrame {
    JLabel label = new JLabel();
    private JFrame helpMenu;
    private JTextPane pane;
    private JButton back, pOne, pTwo, pThree, pFour, pFive, pSix, pSeven, pEight;
    private JPanel pgOne, pgTwo, pgThree, pgFour, pgFive, pgSix, pgSeven, pgEight;
    private JLabel heading;
    private static int WIDTH = 800;
    private static int HEIGHT = 1000;

    public HelpMenu() {
        super("Help Menu");

        Container win = getContentPane();
        win.setLayout(null);

        heading = new JLabel("Help Menu");
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
        back.setLocation(30,75);
        win.add(back);

        pOne = new JButton("1");
        pOne.setSize(50,35);
        pOne.setFont(new Font("Calibri", Font.BOLD, 12));
        pOne.setForeground(new Color(98, 98, 103,255));
        pOne.setLocation(100,650);
        win.add(pOne);
        pTwo= new JButton("2");
        pTwo.setSize(50,35);
        pTwo.setFont(new Font("Calibri", Font.BOLD, 12));
        pTwo.setForeground(new Color(98, 98, 103,255));
        pTwo.setLocation(175,650);
        win.add(pTwo);

        pThree = new JButton("3");
        pThree.setSize(50,35);
        pThree.setFont(new Font("Calibri", Font.BOLD, 12));
        pThree.setForeground(new Color(98, 98, 103,255));
        pThree.setLocation(250,650);
        win.add(pThree);

        pFour = new JButton("4");
        pFour.setSize(50,35);
        pFour.setFont(new Font("Calibri", Font.BOLD, 12));
        pFour.setForeground(new Color(98, 98, 103,255));
        pFour.setLocation(325,650);
        win.add(pFour);

        pFive = new JButton("5");
        pFive.setSize(50,35);
        pFive.setFont(new Font("Calibri", Font.BOLD, 12));
        pFive.setForeground(new Color(98, 98, 103,255));
        pFive.setLocation(400,650);
        win.add(pFive);

        pSix = new JButton("6");
        pSix.setSize(50,35);
        pSix.setFont(new Font("Calibri", Font.BOLD, 12));
        pSix.setForeground(new Color(98, 98, 103,255));
        pSix.setLocation(475,650);
        win.add(pSix);

        pSeven = new JButton("7");
        pSeven.setSize(50,35);
        pSeven.setFont(new Font("Calibri", Font.BOLD, 12));
        pSeven.setForeground(new Color(98, 98, 103,255));
        pSeven.setLocation(550,650);
        win.add(pSeven);

        pEight = new JButton("8");
        pEight.setSize(50,35);
        pEight.setFont(new Font("Calibri", Font.BOLD, 12));
        pEight.setForeground(new Color(98, 98, 103,255));
        pEight.setLocation(625,650);
        win.add(pEight);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        //add(new Panel());
        setVisible(true);
    }


}
