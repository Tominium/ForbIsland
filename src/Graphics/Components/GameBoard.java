package Graphics.Components;

import Graphics.GameBoardGraphic;
import Logic.GameState;
import Logic.Pawn;
import Logic.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameBoard extends JLayeredPane{

    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private String action;
    private int runCnt;
    private BufferedImage air;
    private BufferedImage eau;
    private BufferedImage feu;
    private BufferedImage terre;

    public GameBoard(){

        action = "";
        gbc = new GridBagConstraints();
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        GridBagLayoutgrid = new GridBagLayout();
        setLayout(GridBagLayoutgrid);
        runCnt = 0;
        try{
            air = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/AIR_clear.png"));
            air = resize(air, 100, 100);
            eau = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/EAU_clear.png"));
            eau = resize(eau, 100, 100);
            feu = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/FEU_clear.png"));
            feu = resize(feu, 100, 100);
            terre = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/TERRE_clear.png"));
            terre = resize(terre, 100, 100);
        }
        catch(IOException e){

        }
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

        if(runCnt==0){GameState.setOriginalPlayerLocation(); runCnt++;}
        HashMap<Point, ArrayList<Integer>> pawnLocs = GameState.pawnLocHash();
        //System.out.println(pawnLocs);


        for(Point p: pawnLocs.keySet()){
            BufferedImage result = new BufferedImage(120, 120, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = result.createGraphics();
            //System.out.println(GameBoardGraphic.localTileLoc.get(p).getName());
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
        gbc.gridx = 1; gbc.gridy = 0; add(new JLabel(new ImageIcon(air)), gbc);
        gbc.gridx = 4; gbc.gridy = 0; add(new JLabel(new ImageIcon(eau)), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(new JLabel(new ImageIcon(feu)), gbc);
        gbc.gridx = 4; gbc.gridy = 5; add(new JLabel(new ImageIcon(terre)), gbc);

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
        action = "move";

        this.removeAll();

        int x = 2; int y=0; int i =0;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        for(Tile t: GameState.tileLoc){
            gbc.gridx = x;
            gbc.gridy = y;
            Point temp = new Point(x, y);
            Image image = t.getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // transform it

            if(GameState.checkMove(t, GameState.pawnLoc.get(GameState.turn))){
                image = t.getImage().getScaledInstance(115, 115,  Image.SCALE_SMOOTH);
                JLabel test = new JLabel(new ImageIcon(image));
                test.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(134, 3, 148), 5));
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


        HashMap<Point, ArrayList<Integer>> pawnLocs = GameState.pawnLocHash();

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
        gbc.gridx = 1; gbc.gridy = 0; add(new JLabel(new ImageIcon(air)), gbc);
        gbc.gridx = 4; gbc.gridy = 0; add(new JLabel(new ImageIcon(eau)), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(new JLabel(new ImageIcon(feu)), gbc);
        gbc.gridx = 4; gbc.gridy = 5; add(new JLabel(new ImageIcon(terre)), gbc);

        this.repaint();
        this.revalidate();

    }

    public void shoreUp(){
        if(!action.equals("engineer")){action = "shore";}


        this.removeAll();

        int x = 2; int y=0; int i =0;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        for(Tile t: GameState.tileLoc){
            gbc.gridx = x;
            gbc.gridy = y;
            Point temp = new Point(x, y);
            Image image = t.getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // transform it
            if((GameState.checkShore(t, GameState.pawnLoc.get(GameState.turn))||temp.equals(new Point(GameState.pawnLoc.get(GameState.turn).getLocation().get(0), GameState.pawnLoc.get(GameState.turn).getLocation().get(1))))&&t.isFlooded()){
                image = t.getImage().getScaledInstance(115, 115,  Image.SCALE_SMOOTH);
                JLabel test = new JLabel(new ImageIcon(image));
                test.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(134, 3, 148), 5));
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


        HashMap<Point, ArrayList<Integer>> pawnLocs = GameState.pawnLocHash();

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
        gbc.gridx = 1; gbc.gridy = 0; add(new JLabel(new ImageIcon(air)), gbc);
        gbc.gridx = 4; gbc.gridy = 0; add(new JLabel(new ImageIcon(eau)), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(new JLabel(new ImageIcon(feu)), gbc);
        gbc.gridx = 4; gbc.gridy = 5; add(new JLabel(new ImageIcon(terre)), gbc);

        this.repaint();
        this.revalidate();

    }

    public void sandBag(){
        action= "sandbag";
        this.removeAll();

        int x = 2; int y=0; int i =0;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        for(Tile t: GameState.tileLoc){
            gbc.gridx = x;
            gbc.gridy = y;
            Image image = t.getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // transform it
            if(t.isFlooded()){
                image = t.getImage().getScaledInstance(115, 115,  Image.SCALE_SMOOTH);
                JLabel test = new JLabel(new ImageIcon(image));
                test.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(134, 3, 148), 5));
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


        HashMap<Point, ArrayList<Integer>> pawnLocs = GameState.pawnLocHash();

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
        gbc.gridx = 1; gbc.gridy = 0; add(new JLabel(new ImageIcon(air)), gbc);
        gbc.gridx = 4; gbc.gridy = 0; add(new JLabel(new ImageIcon(eau)), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(new JLabel(new ImageIcon(feu)), gbc);
        gbc.gridx = 4; gbc.gridy = 5; add(new JLabel(new ImageIcon(terre)), gbc);

        this.repaint();
        this.revalidate();
    }

    public void engineer(){action = "engineer";}
    public String getAction(){return action;}
    public void resetAction(){action="";}

    public void air(){
        try{
            air = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/AIR.png"));
            air = resize(air, 100, 100);
        }
        catch(IOException e){}
    }
    public void eau(){
        try{
            eau = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/EAU.png"));
            eau = resize(eau, 100, 100);
        }
        catch(IOException e){}
    }
    public void feu(){
        try{
            feu = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/FEU.png"));
            feu = resize(feu, 100, 100);
        }
        catch(IOException e){}
    }
    public void terre(){
        try{
            terre = ImageIO.read(Pawn.class.getResource("/Assets/Treasures/TERRE.png"));
            terre = resize(terre, 100, 100);
        }
        catch(IOException e){}
    }


}
