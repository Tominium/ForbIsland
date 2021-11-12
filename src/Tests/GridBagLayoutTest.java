package Tests;

import Logic.GameState;
import Logic.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class GridBagLayoutTest extends JFrame implements MouseListener {
    private final GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;

    public static void main(String[] args) {
        GridBagLayoutTest a = new GridBagLayoutTest();
    }
    public GridBagLayoutTest() {
        //new GameState(3, "hard");
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.setLayout(GridBagLayoutgrid);
        setTitle("GridBag Layout Example");
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
        addMouseListener(this);

        setSize(3840, 2160);
        setPreferredSize(getSize());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    public void addTiles(){
        this.setLayout(GridBagLayoutgrid);
        gbc.fill = GridBagConstraints.HORIZONTAL;
//        GridBagLayout layout = new GridBagLayout();
//        this.setLayout(layout);

        int x =2; int y=0; int i =0;
        for(Tile t: GameState.tileLoc.keySet()){
            gbc.gridx = x;
            gbc.gridy = y;
            int[] tit = {x, y};
            GameState.tileLoc.put(t, tit);
            Image image = t.getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH); // transform it
            this.add(new JLabel(new ImageIcon(image)), gbc);
            if(x==5){y++; x=0;}
            else{x++;}
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
//        Component a = findComponentAt(e.getPoint());
//        int griX = GridBagLayoutgrid.getConstraints(a).gridx;
//        int griY = GridBagLayoutgrid.getConstraints(a).gridy;
//        System.out.println("(" + griX + ", " + griY + ")");
        int[] loc = {x, y};
        for(Tile t: GameState.tileLoc.keySet()){
            if(GameState.tileLoc.get(t) == loc){
                t.floodTile();
            }
        }
        this.addTiles();
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