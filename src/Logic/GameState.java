package Logic;

import Cards.Card;
import Cards.FloodCard;
import Decks.FloodDeck;
import Decks.TreasureDeck;
import Graphics.Components.discardCard;
import Graphics.GameBoardGraphic;
import Water.WaterMeter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GameState {
    public static ArrayList<String> collectedTreasures;
    private static GameBoardGraphic gb;
    private BufferedImage boardTemplate;
    public static WaterMeter waterMeter;
    public static TreasureDeck treasureDeck;
    public static FloodDeck floodDeck;
    public static ArrayList<Pawn> pawnLoc;
    public static ArrayList<Tile> tileLoc;
    public static int turn;
    private static int actionCount;
    public final static String[] TILENAMES =
            {"Whispering Garden","Watchtower","Twilight Hollow","Tidal Palace"
                    ,"Temple of the Sun","Temple of the Moon","Silver Gate","Phantom Rock","Observatory","Misty Marsh"
                    ,"Lost Lagoon","Iron Gate","Howling Garden","Gold Gate","Fools' Landing", "Dunes of Deception",
                    "Crimson Forest", "Coral Palace", "Copper Gate", "Cliffs of Abandon", "Cave of Shadows", "" +
                    "Cave of Embers", "Bronze Gate", "Breakers Bridge"};
    private static HashMap<Point, Tile> dupl;
    private static int[] loc;

    public GameState(int numPlayers, String diff){
        collectedTreasures = new ArrayList<String>();
        pawnLoc = new ArrayList<>();
        tileLoc = new ArrayList<>();
        treasureDeck = new TreasureDeck();
        floodDeck = new FloodDeck();
        turn = 0;
        actionCount = 0;
        dupl = GameBoardGraphic.localTileLoc;
        //loc = new int[0];

        if(diff.equals("Novice")){waterMeter = new WaterMeter(2.0);}
        else if(diff.equals("Normal")){waterMeter = new WaterMeter(2.25);}
        else if(diff.equals("Elite")){waterMeter = new WaterMeter(2.5);}
        else{waterMeter = new WaterMeter(3.0);}

        shuffleTiles();
        setRoles(numPlayers);

        gb = new GameBoardGraphic(this);
    }

    private static void setRoles(int np){
        String[] temp = {"Engineer", "Diver", "Explorer", "Navigator", "Pilot", "Messenger"};
        ArrayList<String> roles = new ArrayList(Arrays.asList(temp));

        for(int i=0; i<np; i++) {
            int pos = (int)(Math.random()*roles.size())+0;
            Pawn p = new Pawn(roles.remove(pos), i);
            pawnLoc.add(p);
        }
    }

    public static void shuffleTiles() {
        for(int i = 0; i < 24; i++) {
            tileLoc.add(new Tile(TILENAMES[i])); //TO BE CHANGED
        }
        Collections.shuffle(tileLoc);
        for(int i=0; i<6; i++){
            String name = floodDeck.getCard().getCardName();
            for(int ii=0; ii<tileLoc.size(); ii++){
                if(tileLoc.get(ii).getName().equals(name)){
                    Tile t = tileLoc.get(ii);
                    t.floodTile();
                    tileLoc.set(ii, t);
                }
            }
        }
    }

    public boolean iterateAction(){
        actionCount++;
        if(actionCount==3){
            actionCount=0;
            iterateTurn();
            return false;
        }
        return true;
    }
    public void iterateTurn() {
          for(int i=0; i<2; i++){
              Card c = treasureDeck.getCard();
              if (c.getCardName().contains("Water")) {
                  treasureDeck.discardCard(c);
                  waterMeter.watersRise();
                  floodDeck.resetDeck();
                  JOptionPane.showMessageDialog(gb,
                          "You have drawn a Waters Rise Card!", "Waters Rise!",
                          JOptionPane.ERROR_MESSAGE);
                  gb.updateAll();
              }
              else if(pawnLoc.get(turn).getHand().size()+1 > 5) {
                  discardCard temp = new discardCard(this, 1, gb);
                  System.out.println("Pre Modal");
                  temp.setModal(true);
                  temp.setVisible(true);
                  System.out.println("Modal");
                  pawnLoc.get(turn).addCard(c);
                  gb.getPlayerDeckView().updatePanel();
                  gb.updateAll();
              }
              else{
                  if(pawnLoc.get(turn).getHand().size()==4){
                      System.out.println("Test1");
                  } pawnLoc.get(turn).addCard(c);gb.getPlayerDeckView().updatePanel();
                  gb.updateAll();}
          }
        for(int a=0; a<(int)waterMeter.getWaterLevel(); a++){
            FloodCard fc = floodDeck.getCard();
            for(int b=0; b<tileLoc.size(); b++){
                if(tileLoc.get(b).getName().equals(fc.getCardName())){
                    System.out.println(fc.getCardName());
                    Tile t = tileLoc.get(b);
                    t.floodTile();
                    tileLoc.set(b, t);
                }
            }
        }
        gb.getGameTiles().paintTile();
        gb.updateAll();
        turn++;
        if(turn>=pawnLoc.size()){turn =0;}
    }

    public static void setOriginalPlayerLocation() {
        for(Pawn p: pawnLoc){
            if(p.getRole().equals("Diver")){for(Tile t: tileLoc){if(t.getName().equals("Iron Gate")){p.setLocation(t.getLocation().get(0), t.getLocation().get(1));}}}
            if(p.getRole().equals("Explorer")){for(Tile t: tileLoc){if(t.getName().equals("Copper Gate")){p.setLocation(t.getLocation().get(0), t.getLocation().get(1));}}}
            if(p.getRole().equals("Messenger")){for(Tile t: tileLoc){if(t.getName().equals("Silver Gate")){p.setLocation(t.getLocation().get(0), t.getLocation().get(1));}}}
            if(p.getRole().equals("Navigator")){for(Tile t: tileLoc){if(t.getName().equals("Gold Gate")){p.setLocation(t.getLocation().get(0), t.getLocation().get(1));}}}
            if(p.getRole().equals("Pilot")){for(Tile t: tileLoc){if(t.getName().contains("Fool")){p.setLocation(t.getLocation().get(0), t.getLocation().get(1));}}}
            if(p.getRole().equals("Engineer")){for(Tile t: tileLoc){if(t.getName().equals("Bronze Gate")){p.setLocation(t.getLocation().get(0), t.getLocation().get(1));}}}
        }
    }

    public static boolean checkMove(Tile t, Pawn p) {
        if(t==null || t.isSunk()==true)
            return false;
        ArrayList<Integer> pawnL = p.getLocation();
        ArrayList<Integer> tileL = t.getLocation();
        if(p.getRole().equals("Explorer")&&((t.getLocation().get(0)==p.getLocation().get(0)+1&&t.getLocation().get(1)==p.getLocation().get(1)+1)|| (t.getLocation().get(0)==p.getLocation().get(0)-1&&t.getLocation().get(1)==p.getLocation().get(1)+1)|| (t.getLocation().get(0)==p.getLocation().get(0)+1&&t.getLocation().get(1)==p.getLocation().get(1)-1)|| (t.getLocation().get(0)==p.getLocation().get(0)-1&&t.getLocation().get(1)==p.getLocation().get(1)-1))) {
            return true;
        }
        if(p.getRole().equals("Pilot") && p.iterateMoveCount()>1) {
            return true;
        }
        if(pawnL.get(0)==tileL.get(0)){if(pawnL.get(1)+1==tileL.get(1) || pawnL.get(1)-1==tileL.get(1)){return true;}}
        if(pawnL.get(1)==tileL.get(1)){if(pawnL.get(0)+1==tileL.get(0) || pawnL.get(0)-1==tileL.get(0)){return true;}}

        return false;
    }

    public static boolean checkShore(Tile t, Pawn p){
        if(t==null || t.isSunk()==true)
            return false;
        ArrayList<Integer> pawnL = p.getLocation();
        ArrayList<Integer> tileL = t.getLocation();
        if(p.getRole().equals("Explorer")&&((t.getLocation().get(0)==p.getLocation().get(0)+1&&t.getLocation().get(1)==p.getLocation().get(1)+1)|| (t.getLocation().get(0)==p.getLocation().get(0)-1&&t.getLocation().get(1)==p.getLocation().get(1)+1)|| (t.getLocation().get(0)==p.getLocation().get(0)+1&&t.getLocation().get(1)==p.getLocation().get(1)-1)|| (t.getLocation().get(0)==p.getLocation().get(0)-1&&t.getLocation().get(1)==p.getLocation().get(1)-1))) {
            return true;
        }
        if(pawnL.get(0)==tileL.get(0)){if(pawnL.get(1)+1==tileL.get(1) || pawnL.get(1)-1==tileL.get(1)){return true;}}
        if(pawnL.get(1)==tileL.get(1)){if(pawnL.get(0)+1==tileL.get(0) || pawnL.get(0)-1==tileL.get(0)){return true;}}

        return false;
    }

    public boolean movePawn(Tile t, Pawn p) {
        if(checkMove(t, p)) {
            p.setLocation(t.getLocation().get(0), t.getLocation().get(1));
            return true;
        }
        return false;
    }


    public static HashMap<Point, ArrayList<Integer>> pawnLocHash(){
        HashMap<Point, ArrayList<Integer>> total = new HashMap<>();

        for(int i=0; i < pawnLoc.size();i++){
            Point p = new Point(pawnLoc.get(i).getLocation().get(0), pawnLoc.get(i).getLocation().get(1));
            if(total.containsKey(p)){
                total.get(p).add(i);
            }
            else{
                total.put(p, new ArrayList<Integer>());
                total.get(p).add(i);
            }
        }
        return total;
    }

    public static boolean checkTrade(Pawn b) {
        Pawn temp = GameState.pawnLoc.get(turn);

        ArrayList<Integer> aLoc = temp.getLocation();
        ArrayList<Integer> bLoc = b.getLocation();

        if(aLoc.get(0)==bLoc.get(0)&&aLoc.get(1)==bLoc.get(1))
            return true;
        else if(aLoc.get(0)==bLoc.get(0)+1&&aLoc.get(1)==bLoc.get(1))
            return true;
        else if(aLoc.get(0)==bLoc.get(0)-1&&aLoc.get(1)==bLoc.get(1))
            return true;
        else if(aLoc.get(0)==bLoc.get(0)&&aLoc.get(1)==bLoc.get(1)+1)
            return true;
        else if(aLoc.get(0)==bLoc.get(0)&&aLoc.get(1)==bLoc.get(1)-1)
            return true;
        else
            return false;
    }

    public static void trade(Pawn b, Card c) {
        if(checkTrade(b)) {
            GameState.pawnLoc.get(turn).removeCard(c);
            b.addCard(c);
        }
    }
    public static void updatePawnLoc(Pawn b){
        pawnLoc.set(turn, b);
    }

    public static boolean captureTreasure(){
        Pawn p = pawnLoc.get(turn);
        Point pe = new Point(p.getLocation().get(0), p.getLocation().get(1));
        Tile t = GameBoardGraphic.localTileLoc.get(pe);
        String cardName = "";
        if(t.getName().contains("Temple") || t.getName().contains("Garden") || t.getName().contains("Palace") || t.getName().contains("Cave")){
            if(t.getName().contains("Temple")) cardName = "Earth";
            else if(t.getName().contains("Cave")) cardName = "Fire";
            else if(t.getName().contains("Palace")) cardName = "Ocean";
            else cardName = "Wind";
        }
        else{
            JOptionPane.showMessageDialog(gb,
                    "You Are Not On The Correct Tile To Capture A Treasure", "Cannot Capture Treasure",
                    JOptionPane.ERROR_MESSAGE); return false;}

        int count = 0;
        String firstCard = "";
        for(int i = 0; i < p.getHand().size(); i++){
            if(p.getHand().get(i).getCardName().contains(cardName)){
                firstCard = p.getHand().get(i).getCardName();
                count++;
            }
        }

        if(count >= 4){
            collectedTreasures.add(firstCard);
            for(int i=0; i<count; i++){
                if(p.getHand().get(i).getCardName().contains(cardName)){
                    treasureDeck.discardCard(p.getHand().get(i));
                    p.removeCard(p.getHand().get(i));
                }
            }
            if(cardName.contains("Wind")){gb.getGameTiles().air();}
            else if(cardName.contains("Earth")){gb.getGameTiles().terre();}
            else if(cardName.contains("Fire")){gb.getGameTiles().feu();}
            else{gb.getGameTiles().eau();}
            gb.updateAll();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(gb,
                    "You Do Not Have Enough Treasure Cards", "Cannot Capture Treasure",
                    JOptionPane.ERROR_MESSAGE); return false;}

    }

    public TreasureDeck getTreasureDeck(){return treasureDeck;}

    public boolean checkLose(){
        HashMap<Point, ArrayList<Integer>> locs = GameState.pawnLocHash();

        if(dupl.get("Fool's Landing").isSunk()){
            return true;
        }
        if(dupl.get("Howling Garden").isSunk() && dupl.get("Whispering Garden").isSunk()){
            return true;
        }
        else if(dupl.get("Cave of Shadow").isSunk() && dupl.get("Cave of Embers").isSunk()){
            return false;
        }
        else if(dupl.get("Tidal Palace").isSunk() && dupl.get("Coral Palace").isSunk()){
            return false;
        }
        else if(dupl.get("Temple of the Sun").isSunk() && dupl.get("Temple of the Moon").isSunk()){
            return false;
        }
        return false;
    }

    public static boolean checkWin(){
        if(collectedTreasures.indexOf(null) != -1){
            int counter = 0;
            for(int i = 0; i < pawnLoc.size(); i++){
                if(pawnLoc.get(i).getLocation() == dupl.get("Temple Of the Sun").getLocation()){
                    counter++;
                }
            }
            if(counter == 4){

            }
        }
        return false;
    }

}
