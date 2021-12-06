package Graphics;

import Graphics.Components.*;
import Logic.GameState;
import Logic.Pawn;
import Logic.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import static Logic.GameState.captureTreasure;
import static Logic.GameState.turn;
import static Graphics.Components.playerSelectionPanel.otherPawn;

public class GameBoardGraphic extends JFrame implements MouseListener {
    private static final int WIDTH = 1800;
    private static final int HEIGHT = 1150 ;
    private Font Font;
    private GameState gameState;
    private GameBoard gameTiles;
    private playerDeckPanel playerDeckView;
    private waterMeterPanel waterMeter;
    private JPanel heliPanel;
    private JPanel specialAbility;
    public static HashMap<Point, Tile> localTileLoc;
    private JPanel mainComps;
    private JPanel sideComps;
    private JPanel specialComps;
    private JButton ability;
    public static int count;

    public GameBoardGraphic(GameState gs){
        count = 0;
        gameState = gs;

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
        JButton move = new JButton("Move"); move.setPreferredSize(new Dimension(110, 35)); sideComps.add(move);
        move.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                movePawn();
            }});
        JButton shoreUp = new JButton("Shore Up"); shoreUp.setPreferredSize(new Dimension(110, 35)); sideComps.add(shoreUp);
        shoreUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                shoreUp();
            }});
        JButton tradeB = new JButton("Trade"); tradeB.setPreferredSize(new Dimension(110, 35)); sideComps.add(tradeB);
        tradeB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tradeable();
            }});
        JButton capture = new JButton("Capture Treasure"); capture.setPreferredSize(new Dimension(150, 35)); sideComps.add(capture);
        capture.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                captureTreasure();
            }});
        JButton useCard = new JButton("Use Card"); useCard.setPreferredSize(new Dimension(110, 35)); sideComps.add(useCard);
        useCard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                useCard();
            }});
        JButton endTurn = new JButton("End Turn"); endTurn.setPreferredSize(new Dimension(110, 35)); sideComps.add(endTurn);
        endTurn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gameState.iterateTurn(); updateAll();
            }});
        JButton helpButton = new JButton("Help"); helpButton.setPreferredSize(new Dimension(110, 35)); helpButton.add(endTurn);
        helpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new HelpMenu();
            }});
        ability = new JButton("Ability");
        ability.setPreferredSize(new Dimension(110, 35));
        sideComps.add(ability);
        ability.setVisible(false);
        ability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                navigatorAbility();
            }
        });

        frameGBC.gridx = 0;
        frameGBC.gridy = 1;
        add(sideComps, frameGBC);

        pack();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setResizable(false);
        setVisible(true);
        updateAll();
    }

    public void movePawn(){
        gameTiles.moveP();
        mainComps.repaint();
        mainComps.revalidate();
    }

    public void navigatorAbility() {
        new playerSelectionPanel(this, gameState);
    }
    public void tradeable(){
        HashMap<Point, ArrayList<Integer>> temp = GameState.pawnLocHash();
        boolean tf = false;

        for(ArrayList<Integer> a: temp.values()) {
            if (a.contains(turn) && a.size() > 1) {
                tf = true;
            }
        }
        if(tf) {
            new tradePanel(this, gameState);
        }
        else
            JOptionPane.showMessageDialog(this,
                    "You have no friends on this tile hahahaha", "haha",
                    JOptionPane.ERROR_MESSAGE);

    }

    public void removeCard(){}

    public void shoreUp(){
        if(GameState.pawnLoc.get(GameState.turn).getRole().contains("Engineer")){
            gameTiles.engineer();
            gameTiles.shoreUp();
            mainComps.repaint();
            mainComps.revalidate();
        }
        else {gameTiles.shoreUp();}
    }

    public void useCard(){
        new useCard(this, gameState);
    }

    public void sandBag(){
        gameTiles.sandBag();
        mainComps.repaint();
        mainComps.revalidate();
    }

    public void helicopter(){}

    public void winGraphics(){}

    public void loseGraphics(){}


    @Override
    public void mouseClicked(MouseEvent e) {
        if(gameTiles.getAction().contains("engineer")){
            Component a = findComponentAt(e.getPoint());
            int griX = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridx;
            int griY = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridy;
            System.out.println("Test 1");
            if(griX != -1){
                for(int i = 0; i < GameState.tileLoc.size(); i++){
                    if(GameState.tileLoc.get(i).equals(localTileLoc.get(new Point(griX, griY))) && GameState.checkShore(GameState.tileLoc.get(i),GameState.pawnLoc.get(GameState.turn) )){
                        Tile t = GameState.tileLoc.get(i);
                        t.shoreUp();
                        GameState.tileLoc.set(i, t);
                        gameState.iterateAction();
                        gameTiles.paintTile();
                        gameTiles.shoreUp();
                        mainComps.repaint();
                        gameTiles.revalidate();
                    }
                }
            }
        }

        if(gameTiles.getAction().contains("shore") || gameTiles.getAction().contains("sandbag")){
            Component a = findComponentAt(e.getPoint());
            int griX = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridx;
            int griY = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridy;
            if (griX != -1) {
                Point temp = new Point(GameState.pawnLoc.get(GameState.turn).getLocation().get(0),GameState.pawnLoc.get(GameState.turn).getLocation().get(1));
                if(GameState.checkShore(localTileLoc.get(new Point(griX, griY)), GameState.pawnLoc.get(GameState.turn)) || temp.equals(new Point(griX, griY)) || gameTiles.getAction().contains("sandbag")){
                    for (int i = 0; i < GameState.tileLoc.size(); i++) {
                        if (GameState.tileLoc.get(i).equals(localTileLoc.get(new Point(griX, griY)))|| gameTiles.getAction().contains("sandbag")) {
                            System.out.println("(" + griX + ", " + griY + ")");
                            Tile t = GameState.tileLoc.get(i);
                            t.shoreUp();
                            GameState.tileLoc.set(i, t);
                            gameTiles.paintTile();
                            if(!gameTiles.getAction().contains("sandbag") && !gameTiles.getAction().contains("engineer")){gameState.iterateAction();}
                            gameTiles.resetAction();
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
            Boolean self = gameTiles.getAction().equals("moveSink") && GameState.checkMove(t, gameTiles.mover);
            if(GameState.checkMove(t, GameState.pawnLoc.get(GameState.turn)) || self){
                Pawn b = GameState.pawnLoc.get(GameState.turn);
                if(b.getRole().equals("Pilot")){b.iterateMoveCount();}
                if(gameTiles.getAction().equals("moveSink")){b = gameTiles.mover;}
                System.out.println(b.setLocation(griX, griY));
                if(gameTiles.getAction().equals("move")){
                    GameState.updatePawnLoc(b);
                    gameState.iterateAction();
                }
                else{
                    for(int i=0; i<GameState.pawnLoc.size(); i++){
                        if(GameState.pawnLoc.get(i).equals(b)){
                            b.setLocation(griX, griY);
                            GameState.pawnLoc.set(i, b);
                        }
                    }
                }
                gameTiles.paintTile();
//                if(gameTiles.getAction().equals("moveSink")){
//                    synchronized(gameState.syncObject) {
//                        gameState.syncObject = true;
//                        gameState.syncObject.notify();
//                    }
//                }
                gameTiles.resetAction();
            }
        }

        if(gameTiles.getAction().contains("moveOther")){
            Component a = findComponentAt(e.getPoint());
            int griX = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridx;
            int griY = gameTiles.getGridBagLayoutgrid().getConstraints(a).gridy;
            System.out.println("(" + griX + ", " + griY + ")");
            Tile t = GameBoardGraphic.localTileLoc.get(new Point(griX, griY));
            if(GameState.checkMove(t, otherPawn)){
                Pawn b = otherPawn;
                System.out.println(b.setLocation(griX, griY));
                for(int i = 0; i < GameState.pawnLoc.size();i++)
                    if(GameState.pawnLoc.get(i).equals(b))
                        GameState.pawnLoc.get(i).setLocation(griX, griY);
                gameTiles.resetAction();
                gameTiles.paintTile();
            }
            if(count<1) {
                gameTiles.moveOther(otherPawn);
                count++;
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

    public playerDeckPanel getPlayerDeckView(){return playerDeckView;}
    public GameBoard getGameTiles(){return gameTiles;}

    public void updateAll(){
        playerDeckView.updatePanel();
        playerDeckView.revalidate();
        playerDeckView.repaint();
        waterMeter.update();
        gameTiles.revalidate();
        gameTiles.repaint();
        mainComps.repaint();
        mainComps.revalidate();
        waterMeter.update();
        sideComps.repaint();
        sideComps.revalidate();
        this.repaint();
        this.revalidate();
        if(GameState.pawnLoc.get(GameState.turn).getRole().contains("Navigator"))
            ability.setVisible(true);
        else
            ability.setVisible(false);

    }
}
