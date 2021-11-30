package Graphics.Components;

import Graphics.GameBoardGraphic;
import Logic.GameState;
import Logic.Pawn;
import Logic.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class GameBoard extends JLayeredPane {

    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;

    public GameBoard(){

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayoutgrid = new GridBagLayout();
        setLayout(GridBagLayoutgrid);
        paintTile();
    }

    public GridBagLayout getGridBagLayoutgrid() {
        return GridBagLayoutgrid;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void paintTile(){
        this.removeAll();
        int x = 2; int y=0; int i =0;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        for(Tile t: GameState.tileLoc){
            gbc.gridx = x;
            gbc.gridy = y;
            t.setLocation(x,y);
            GameBoardGraphic.localTileLoc.put(new Point(x, y), t);
            Image image = t.getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // transform it
            this.add(new JLabel(new ImageIcon(image)), gbc);
            if(i == 0|| i == 5){
                if(x == 3){
                    y++;
                    i++;
                    x = 1;
                }
                else {
                    x++;
                }
            }
            else if(i == 1 || i == 4){
                if(i == 1){
                    if(x == 4){
                        y++;
                        i++;
                        x = 0;
                    }
                    else{
                        x++;
                    }
                }
                else if(x == 4){
                    y++;
                    i++;
                    x = 2;
                }
                else{
                    x++;
                }
            }
            else if(i == 2 || i == 3){
                if(i == 2){
                    if(x == 5){
                        y++;
                        i++;
                        x = 0;
                    }
                    else{
                        x++;
                    }
                }
                else if(x == 5){
                    y++;
                    i++;
                    x = 1;
                }
                else{
                    x++;
                }
            }
        }
        gbc.ipadx = 0;
        gbc.ipady = 0;

        GameState.setOriginalPlayerLocation();

        HashMap<Point, ArrayList<Integer>> pawnLocs = GameState.pawnLocs();


        for(Point p: pawnLocs.keySet()){
            BufferedImage result = new BufferedImage(120, 120, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = result.createGraphics();
            gbi.drawImage(resize(GameBoardGraphic.localTileLoc.get(p).getImage(),120,120), 0, 0, this);
            gbc.gridx = p.x;
            gbc.gridy = p.y;
            for(int ii: pawnLocs.get(p)){
                Pawn pp = GameState.pawnLoc.get(ii);
                BufferedImage piece = pp.getPiece();
                gbi.drawImage(resize(pp.getPiece(),30,45), (ii+1)*10, 0+(ii*10), this);
            }
            result = resize(result,120,120);
            this.add(new JLabel(new ImageIcon(result)), gbc, 0);
        }

        this.repaint();
        this.revalidate();
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public void moveP(){
        ArrayList<int[]> ret = GameState.coords();
        ArrayList<Point> real = new ArrayList<>();
        for(int[] re: ret){
            real.add(new Point(re[0], re[1]));
        }
        System.out.println(real);

        this.removeAll();
        int x = 2; int y=0; int i =0;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        for(Tile t: GameState.tileLoc){
            gbc.gridx = x;
            gbc.gridy = y;
            t.setLocation(x,y);
            Point temp = new Point(x, y);
            GameBoardGraphic.localTileLoc.put(new Point(x, y), t);
            Image image = t.getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // transform it
            if(real.contains(temp)){
                image = t.getImage().getScaledInstance(115, 115,  Image.SCALE_SMOOTH);
                JLabel test = new JLabel(new ImageIcon(image));
                test.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(134, 3, 148)));
                this.add(test, gbc);
            }
            else{
                this.add(new JLabel(new ImageIcon(image)), gbc);
            }
            if(i == 0|| i == 5){
                if(x == 3){
                    y++;
                    i++;
                    x = 1;
                }
                else {
                    x++;
                }
            }
            else if(i == 1 || i == 4){
                if(i == 1){
                    if(x == 4){
                        y++;
                        i++;
                        x = 0;
                    }
                    else{
                        x++;
                    }
                }
                else if(x == 4){
                    y++;
                    i++;
                    x = 2;
                }
                else{
                    x++;
                }
            }
            else if(i == 2 || i == 3){
                if(i == 2){
                    if(x == 5){
                        y++;
                        i++;
                        x = 0;
                    }
                    else{
                        x++;
                    }
                }
                else if(x == 5){
                    y++;
                    i++;
                    x = 1;
                }
                else{
                    x++;
                }
            }
        }
        gbc.ipadx = 0;
        gbc.ipady = 0;

        GameState.setOriginalPlayerLocation();

        HashMap<Point, ArrayList<Integer>> pawnLocs = GameState.pawnLocs();

        System.out.println(GameState.pawnLoc.get(0).getRole());


        for(Point p: pawnLocs.keySet()){
            BufferedImage result = new BufferedImage(120, 120, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = result.createGraphics();
            gbi.drawImage(resize(GameBoardGraphic.localTileLoc.get(p).getImage(),120,120), 0, 0, this);
            gbc.gridx = p.x;
            gbc.gridy = p.y;
            for(int ii: pawnLocs.get(p)){
                Pawn pp = GameState.pawnLoc.get(ii);
                BufferedImage piece = pp.getPiece();
                gbi.drawImage(resize(pp.getPiece(),30,45), (ii+1)*10, 0+(ii*10), this);
            }
            result = resize(result,120,120);
            this.add(new JLabel(new ImageIcon(result)), gbc, 0);
        }

        this.repaint();
        this.revalidate();

    }
}
