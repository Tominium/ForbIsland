package Tests;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class GridBagLayoutTest extends JFrame implements MouseListener {
    private final GridBagLayout GridBagLayoutgrid;

    public static void main(String[] args) {
        GridBagLayoutTest a = new GridBagLayoutTest();
    }
    public GridBagLayoutTest() {
        GridBagLayoutgrid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(GridBagLayoutgrid);
        setTitle("GridBag Layout Example");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        File dir = new File("C:\\Users\\Cyric\\Downloads\\zones");

        int x =0; int y= 0;
        for(File f: dir.listFiles()){
            if(!f.getName().contains("flood")){
                try{
                    gbc.gridx = x;
                    gbc.gridy = y;
                    this.add(new JLabel(new ImageIcon(ImageIO.read(f))), gbc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(y==2){x++; y=0;}
                else{y++;}
            }
        }
        addMouseListener(this);

        setSize(3840, 2160);
        setPreferredSize(getSize());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("loc is (" + x + ", " + y + ")");
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