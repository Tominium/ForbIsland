package Graphics;

import Graphics.Components.playerDeckPanel;
import Graphics.Components.waterMeterPanel;
import Logic.GameState;
import Logic.Pawn;
import Logic.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GameBoardGraphic extends JFrame implements MouseListener {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 1082 ;
    private Font Font;
    private JPanel gameTiles;
    private final GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private playerDeckPanel playerDeckView;
    private waterMeterPanel waterMeter;
    private JPanel heliPanel;
    private JPanel specialAbility;
    public static HashMap<Point, Tile> localTileLoc;
    private JPanel mainComps;
    private JPanel sideComps;

    public GameBoardGraphic(){
        addMouseListener(this);
        mainComps = new JPanel();
        mainComps.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        mainComps.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        localTileLoc = new HashMap<>();

        playerDeckView =  new playerDeckPanel();

        mainComps.add(playerDeckView);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gameTiles = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gameTiles.setLayout(GridBagLayoutgrid);
        paintTile();
        mainComps.add(gameTiles);

        waterMeter = new waterMeterPanel();
        mainComps.add(waterMeter);

        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints frameGBC = new GridBagConstraints();
        frameGBC.gridx = 0;
        frameGBC.gridy = 0;
        add(mainComps, frameGBC);

        sideComps = new JPanel();
        sideComps.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        sideComps.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        sideComps.setFont(new Font("Arial", Font.BOLD, 18));
        JButton move = new JButton("Move"); move.setPreferredSize(new Dimension(200, 100)); sideComps.add(move);
        JButton shoreUp = new JButton("Shore Up"); shoreUp.setPreferredSize(new Dimension(200, 100)); sideComps.add(shoreUp);
        JButton tradeB = new JButton("Trade"); tradeB.setPreferredSize(new Dimension(200, 100)); sideComps.add(tradeB);
        JButton capture = new JButton("Capture Treasure"); capture.setPreferredSize(new Dimension(200, 100)); sideComps.add(capture);

        frameGBC.gridx = 0;
        frameGBC.gridy = 1;
        add(sideComps, frameGBC);

        pack();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setResizable(true);
        setVisible(true);
    }

    private void paintTile(){
        int x = 2; int y=0; int i =0;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        for(Tile t: GameState.tileLoc){
            if(t.getName().contains("Fool")){GameState.setOriginalPlayerLocation(x, y);}
            gbc.gridx = x;
            gbc.gridy = y;
            t.setLocation(x,y);
            localTileLoc.put(new Point(x, y), t);
            Image image = t.getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // transform it
            gameTiles.add(new JLabel(new ImageIcon(image)), gbc);
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
        for(Pawn p: GameState.pawnLoc){
            gbc.gridx = p.getLocation().get(0);
            gbc.gridy = p.getLocation().get(1);
            BufferedImage result = new BufferedImage(120, 120, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = result.createGraphics();
            BufferedImage piece = p.getPiece();
            gbi.drawImage(localTileLoc.get(new Point(gbc.gridx, gbc.gridy)).getImage(), 0, 0, this);
            gbi.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.75f));
            gbi.drawImage(p.getPiece(), 0, 0, this);
            gameTiles.add(new JLabel(new ImageIcon(result)), gbc);
        }

    }

    public void movePawn(){}

    public void tradeable(){}

    public void removeCard(){}

    public void sandBag(){}

    public void helicopter(){}

    public void specialAbility(){}

    public void winGraphics(){}

    public void loseGraphics(){}


    @Override
    public void mouseClicked(MouseEvent e) {
        Component a = findComponentAt(e.getPoint());
        int griX = GridBagLayoutgrid.getConstraints(a).gridx;
        int griY = GridBagLayoutgrid.getConstraints(a).gridy;
        System.out.println("(" + griX + ", " + griY + ")");
        System.out.println(GameState.check(localTileLoc.get(new Point(griX,griY)), GameState.pawnLoc.get(0)));
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
