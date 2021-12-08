package Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HelpMenu extends JFrame implements ActionListener {
    private JButton back, pOne, pTwo, pThree, pFour, pFive, pSix, pSeven, pEight, n1;
    private JLabel heading, page, general,navigation;
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 900;

    public HelpMenu() {
        super("Help Menu");
        Container win = getContentPane();
        win.setLayout(null);

        heading = new JLabel("Help Menu");heading.setSize(750, 60);heading.setFont(new Font("Impact", Font.BOLD, 50));heading.setForeground(new Color(98, 98, 103, 255));heading.setHorizontalAlignment(JLabel.CENTER);heading.setVerticalAlignment(JLabel.CENTER);
        win.add(heading);

        page = new JLabel();page.setSize(500, 700);page.setLocation(150,100);
        win.add(page);
        ImageIcon icon = new ImageIcon("src/Assets/HelpPages/pOne.png");
        page.setIcon(icon);

        back = new JButton("Back");
        back.setSize(100,45);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(new Color(98, 98, 103,255));
        back.setLocation(30,75);
        back.addActionListener(this);
        win.add(back);

        general = new JLabel("General Rules");general.setSize(100,50);general.setLocation(700,50);general.setFont(new Font("Arial", Font.BOLD, 14));
        win.add(general);

        navigation=new JLabel("Navigating our game");navigation.setSize(150,50);navigation.setLocation(850,50);navigation.setFont(new Font("Arial", Font.BOLD, 14));
        win.add(navigation);

        pOne = new JButton("1");pOne.setSize(50,35);pOne.setFont(new Font("Arial", Font.BOLD, 12));pOne.setForeground(new Color(98, 98, 103,255));pOne.setLocation(725,100);
        pOne.addActionListener(this);
        win.add(pOne);

        pTwo= new JButton("2");pTwo.setSize(50,35);pTwo.setFont(new Font("Arial", Font.BOLD, 12));pTwo.setForeground(new Color(98, 98, 103,255));pTwo.setLocation(725,175);
        pTwo.addActionListener(this);
        win.add(pTwo);

        pThree = new JButton("3");pThree.setSize(50,35);pThree.setFont(new Font("Arial", Font.BOLD, 12));pThree.setForeground(new Color(98, 98, 103,255));pThree.setLocation(725,250);
        pThree.addActionListener(this);
        win.add(pThree);

        pFour = new JButton("4");pFour.setSize(50,35);pFour.setFont(new Font("Arial", Font.BOLD, 12));pFour.setForeground(new Color(98, 98, 103,255));pFour.setLocation(725,325);
        pFour.addActionListener(this);
        win.add(pFour);

        pFive = new JButton("5");pFive.setSize(50,35);pFive.setFont(new Font("Arial", Font.BOLD, 12));pFive.setForeground(new Color(98, 98, 103,255));pFive.setLocation(725,400);
        pFive.addActionListener(this);
        win.add(pFive);

        pSix = new JButton("6");pSix.setSize(50,35);pSix.setFont(new Font("Arial", Font.BOLD, 12));pSix.setForeground(new Color(98, 98, 103,255));pSix.setLocation(725,475);
        pSix.addActionListener(this);
        win.add(pSix);

        pSeven = new JButton("7");pSeven.setSize(50,35);pSeven.setFont(new Font("Arial", Font.BOLD, 12));pSeven.setForeground(new Color(98, 98, 103,255));pSeven.setLocation(725,550);
        pSeven.addActionListener(this);
        win.add(pSeven);

        pEight = new JButton("8");pEight.setSize(50,35);pEight.setFont(new Font("Arial", Font.BOLD, 12));pEight.setForeground(new Color(98, 98, 103,255));pEight.setLocation(725,625);
        pEight.addActionListener(this);
        win.add(pEight);

        n1 = new JButton("1");n1.setSize(50,35);n1.setFont(new Font("Arial", Font.BOLD, 12));n1.setForeground(new Color(98, 98, 103,255));n1.setLocation(900,100);
        n1.addActionListener(this);
        win.add(n1);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = "/Assets/HelpPages/" ;
        if(e.getSource()==pOne){
            link+="pOne.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pTwo){
            link+="pTwo.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pThree){
            link+="pThree.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pFour){
            link+="pFour.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pFive){
            link+="pFive.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pSix){
            link+="pSix.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pSeven){
            link+="pSeven.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pEight){
            link+="pEight.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==back){
            dispose();
        }
        else if(e.getSource()==n1){
            link+="new1.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(HelpMenu.class.getResource(link)));
            page.setIcon(icon);
        }
    }
}
