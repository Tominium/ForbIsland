package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class GameBoardGraphic extends JFrame implements MouseListener {
    private static final int WIDTH = 1350;
    private static final int HEIGHT = 750;
    private Font Font;
    private JButton nextTurn;
    private JButton move;
    private JPanel gameBoard;
    private JPanel heliPanel;
    private JPanel specialAbility;
    private Color limeGreen;
    private final GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;

    public GameBoardGraphic(){
        nextTurn = new JButton("Next Turn");
        move = new JButton("Move");
        gameBoard = new JPanel();
        heliPanel = new JPanel();
        specialAbility= new JPanel();
        limeGreen = new Color(118,218,132);
        nextTurn.setBounds(40,80,WIDTH, HEIGHT);
        nextTurn.setBackground(limeGreen);
        nextTurn.setLocation(150,150);
        move.setBounds(40,80,WIDTH, HEIGHT);
        move.setBackground(limeGreen);
        move.setLocation(300,150);
        addMouseListener(this);



        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.setLayout(GridBagLayoutgrid);
        gbc.fill = GridBagConstraints.HORIZONTAL;
//        GridBagLayout layout = new GridBagLayout();
//        this.setLayout(layout);

        File dir = new File("src/Assets/zones");

        int x =2; int y=0; int i =0;
        for(File f: dir.listFiles()){
            if(!f.getName().contains("flood")){
                try{
                    gbc.gridx = x;
                    gbc.gridy = y;
                    Image image = ImageIO.read(f).getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // transform it
                    this.add(new JLabel(new ImageIcon(image)), gbc);
                    if(x==5){y++; x=0;}
                    else{x++;}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setResizable(false);
        add(new Panel());
        setVisible(true);
    }

    public void movePawn(Object j){}

    public void tradeable(){}

    public void removeCard(){}

    public void sandBag(){}

    public void helicopter(){}

    public void specialAbility(){}

    public void winGraphics(){}

    public void loseGraphics(){}

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Component a = findComponentAt(e.getPoint());
        int griX = GridBagLayoutgrid.getConstraints(a).gridx;
        int griY = GridBagLayoutgrid.getConstraints(a).gridy;
        System.out.println("(" + griX + ", " + griY + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
