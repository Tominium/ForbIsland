package Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends JFrame implements ActionListener {
    private JButton back, pOne, pTwo, pThree, pFour, pFive, pSix, pSeven, pEight;
    private JLabel heading, page;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 950;

    public HelpMenu() {
        super("Help Menu");
        Container win = getContentPane();
        win.setLayout(null);

        heading = new JLabel("Help Menu");
        heading.setSize(750, 60);
        heading.setFont(new Font("Impact", Font.BOLD, 50));
        heading.setForeground(new Color(98, 98, 103, 255));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.CENTER);
        win.add(heading);

        page = new JLabel();
        page.setSize(500, 700);
        page.setLocation(150,100);
        win.add(page);

        back = new JButton("Back");
        back.setSize(100,45);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(new Color(98, 98, 103,255));
        back.setLocation(30,75);
        win.add(back);

        pOne = new JButton("1");
        pOne.setSize(50,35);
        pOne.setFont(new Font("Arial", Font.BOLD, 12));
        pOne.setForeground(new Color(98, 98, 103,255));
        pOne.setLocation(100,850);
        pOne.addActionListener(this);
        win.add(pOne);

        pTwo= new JButton("2");
        pTwo.setSize(50,35);
        pTwo.setFont(new Font("Arial", Font.BOLD, 12));
        pTwo.setForeground(new Color(98, 98, 103,255));
        pTwo.setLocation(175,850);
        pTwo.addActionListener(this);
        win.add(pTwo);

        pThree = new JButton("3");
        pThree.setSize(50,35);
        pThree.setFont(new Font("Arial", Font.BOLD, 12));
        pThree.setForeground(new Color(98, 98, 103,255));
        pThree.setLocation(250,850);
        pThree.addActionListener(this);
        win.add(pThree);

        pFour = new JButton("4");
        pFour.setSize(50,35);
        pFour.setFont(new Font("Arial", Font.BOLD, 12));
        pFour.setForeground(new Color(98, 98, 103,255));
        pFour.setLocation(325,850);
        pFour.addActionListener(this);
        win.add(pFour);

        pFive = new JButton("5");
        pFive.setSize(50,35);
        pFive.setFont(new Font("Arial", Font.BOLD, 12));
        pFive.setForeground(new Color(98, 98, 103,255));
        pFive.setLocation(400,850);
        pFive.addActionListener(this);
        win.add(pFive);

        pSix = new JButton("6");
        pSix.setSize(50,35);
        pSix.setFont(new Font("Arial", Font.BOLD, 12));
        pSix.setForeground(new Color(98, 98, 103,255));
        pSix.setLocation(475,850);
        pSix.addActionListener(this);
        win.add(pSix);

        pSeven = new JButton("7");
        pSeven.setSize(50,35);
        pSeven.setFont(new Font("Arial", Font.BOLD, 12));
        pSeven.setForeground(new Color(98, 98, 103,255));
        pSeven.setLocation(550,850);
        pSeven.addActionListener(this);
        win.add(pSeven);

        pEight = new JButton("8");
        pEight.setSize(50,35);
        pEight.setFont(new Font("Arial", Font.BOLD, 12));
        pEight.setForeground(new Color(98, 98, 103,255));
        pEight.setLocation(625,850);
        pEight.addActionListener(this);
        win.add(pEight);
        // buttons
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        //add(new Panel());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = "src/Assets/HelpPages/" ;
        if(e.getSource()==pOne){
            link+="pOne.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pTwo){
            link+="pTwo.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pThree){
            link+="pThree.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pFour){
            link+="pFour.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pFive){
            link+="pFive.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pSix){
            link+="pSix.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pSeven){
            link+="pSeven.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
        else if(e.getSource()==pEight){
            link+="pEight.png";
            ImageIcon icon = new ImageIcon(link);
            page.setIcon(icon);
        }
    }
}
