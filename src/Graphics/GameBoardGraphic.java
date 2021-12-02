package Graphics;

import Graphics.Components.GameBoard;
import Graphics.Components.playerDeckPanel;
import Graphics.Components.waterMeterPanel;
import Logic.GameState;
import Logic.Pawn;
import Logic.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class GameBoardGraphic extends JFrame implements MouseListener {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 1082 ;
    private Font Font;
    private GameBoard gameTiles;
    private playerDeckPanel playerDeckView;
    private waterMeterPanel waterMeter;
    private JPanel heliPanel;
    private JPanel specialAbility;
    public static HashMap<Point, Tile> localTileLoc;
    private JPanel mainComps;
    private JPanel sideComps;
    private JPanel specialComps;

    public GameBoardGraphic(){
        addMouseListener(this);
        mainComps = new JPanel();
        mainComps.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        mainComps.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        localTileLoc = new HashMap<>();

        playerDeckView =  new playerDeckPanel();

        mainComps.add(playerDeckView);

        gameTiles = new GameBoard();
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
        move.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                movePawn();
            }});
        JButton shoreUp = new JButton("Shore Up"); shoreUp.setPreferredSize(new Dimension(200, 100)); sideComps.add(shoreUp);
        shoreUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                shoreUp();
            }});
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

    public void movePawn(){
        gameTiles.moveP();
        mainComps.repaint();
        mainComps.revalidate();
    }

    public void tradeable(){}

    public void removeCard(){}

    public void shoreUp(){
        gameTiles.shoreUp();
    }

    public void sandBag(){}

    public void helicopter(){}

    public void specialAbility(){}

    public void winGraphics(){}

    public void loseGraphics(){}


    @Override
    public void mouseClicked(MouseEvent e) {
        if(gameTiles.getAction().contains("shore")){
            Component a = findComponentAt(e.getPoint());
            int griX = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridx;
            int griY = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridy;
            if (griX != -1) {
                Point temp = new Point(GameState.pawnLoc.get(GameState.turn).getLocation().get(0),GameState.pawnLoc.get(GameState.turn).getLocation().get(1));
                if(GameState.checkMove(localTileLoc.get(new Point(griX, griY)), GameState.pawnLoc.get(GameState.turn)) || temp.equals(new Point(griX, griY))){
                    for (int i = 0; i < GameState.tileLoc.size(); i++) {
                        if (GameState.tileLoc.get(i).equals(localTileLoc.get(new Point(griX, griY)))) {
                            System.out.println("(" + griX + ", " + griY + ")");
                            Tile t = GameState.tileLoc.get(i);
                            t.shoreUp();
                            GameState.tileLoc.set(i, t);
                            gameTiles.resetAction();
                            gameTiles.paintTile();
                            GameState.iterateAction();
                        }
                    }
                }
            }
        }

        if(gameTiles.getAction().contains("move")){
            Component a = findComponentAt(e.getPoint());
            int griX = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridx;
            int griY = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridy;
            System.out.println("(" + griX + ", " + griY + ")");
            Tile t = GameBoardGraphic.localTileLoc.get(new Point(griX, griY));
            if(GameState.checkMove(t, GameState.pawnLoc.get(GameState.turn))){
                Pawn b = GameState.pawnLoc.get(GameState.turn);
                System.out.println(b.setLocation(griX, griY));
                GameState.updatePawnLoc(b);
                gameTiles.resetAction();
                gameTiles.paintTile();
                GameState.iterateAction();
            }
        }
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
