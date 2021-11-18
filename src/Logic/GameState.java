package Logic;

import Decks.FloodDeck;
import Decks.TreasureDeck;
import Graphics.GameBoardGraphic;
import Water.WaterMeter;


import java.awt.image.BufferedImage;
import java.util.*;

public class GameState {
    public static String[] collectedTreasures;
    private BufferedImage boardTemplate;
    public static WaterMeter waterMeter;
    private static TreasureDeck treasureDeck;
    private static FloodDeck floodDeck;
    public static ArrayList<Pawn> pawnLoc;
    public static ArrayList<Tile> tileLoc;
    private static int turn;
    private static int actionCount;
    public final static String[] TILENAMES =
            {"Whispering Garden","Watchtower","Twilight Hollow","Tidal Palace"
                    ,"Temple of the Sun","Temple of the Moon","Silver Gate","Phantom Rock","Observatory","Misty Marsh"
                    ,"Lost Lagoon","Iron Gate","Howling Garden","Gold Gate","Fools' Landing", "Dunes of Deception",
                    "Crimson Forest", "Coral Palace", "Copper Gate", "Cliffs of Abandon", "Cave of Shadows", "" +
                    "Cave of Embers", "Bronze Gate", "Breakers Bridge"};

    public GameState(int numPlayers, String diff){
        collectedTreasures = new String[4];
        treasureDeck = new TreasureDeck();
        floodDeck = new FloodDeck();
        turn = 0;
        actionCount = 0;

        setRoles(numPlayers);
        shuffleTiles();

        new GameBoardGraphic();
    }

    private static void setRoles(int np){
        String[] temp = {"Engineer", "Diver", "Explorer", "Navigator", "Pilot", "Messenger"};
        ArrayList<String> roles = new ArrayList(Arrays.asList(temp));

        for(int i=0; i<np; i++) {
            int pos = (int)(Math.random()*roles.size())+0;
            Pawn p = new Pawn(roles.remove(pos), i+1);
            pawnLoc.add(p);
        }
    }

    public static void shuffleTiles() {
        for(int i = 0; i < 24; i++) {
            tileLoc.add(new Tile(TILENAMES[i])); //TO BE CHANGED
        }
        Collections.shuffle(tileLoc);
    }

    public double riseWaterLevel() {
        waterMeter.watersRise();
        return waterMeter.getWaterLevel();
    }

    public void setOriginalPlayerLocation(int x, int y, Pawn p) {
        p.setLocation(x, y);
    }
    public boolean check(Tile t, Pawn p) {
        ArrayList<Integer> temp = p.getLocation();

        if(t.isSunk()==true)
            return false;
        else if(t.getLocation().get(0)==temp.get(0)+1||t.getLocation().get(0)==temp.get(0)-1)
            return true;
        else if(t.getLocation().get(1)==temp.get(1)+1||t.getLocation().get(1)==temp.get(1)-1)
            return true;
        else
            return false;
    }
//    public boolean movePawn(int x, int y) {
//        for (Map.Entry<Pawn, int[]> entry : pawnLoc.entrySet())
//            if(entry.getKey().getTurnNum()==turn) {
//                int[] temp = entry.getValue();
//                temp[0] = x;
//                temp[1] = y;
//                return true;
//            }
//        return false;
//    }
//
//    public boolean shore(int x, int y) {
//        for (Map.Entry<Tile, int[]> entry : tileLoc.entrySet()) {
//            int[] temp = entry.getValue();
//            if(temp[0]==x&&temp[1]==y) {
//                entry.getKey().shoreUp();
//                return true;
//            }
//        }
//        return false;
//    }



}
