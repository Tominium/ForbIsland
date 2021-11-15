package Logic;

import Cards.Card;
import Decks.FloodDeck;
import Decks.TreasureDeck;
import Graphics.GameBoardGraphic;
import Water.WaterMeter;


import java.awt.image.BufferedImage;
import java.util.*;

public class GameState {
    public static String[] collectedTreasures;
    private BufferedImage boardTemplate;
    public static HashMap<Tile, int[]> tileLoc;
    public static TreeMap<Pawn, int[]> pawnLoc;
    public static WaterMeter waterMeter;
    private static TreasureDeck treasureDeck;
    private static FloodDeck floodDeck;
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
        tileLoc = new HashMap<Tile, int[]>();
        pawnLoc = new TreeMap<Pawn, int[]>();
        treasureDeck = new TreasureDeck();
        floodDeck = new FloodDeck();
        turn = 0;
        actionCount = 0;

        shuffleTiles();
        setRoles(numPlayers);

        new GameBoardGraphic();
    }

    private static void setRoles(int np){
        String[] temp = {"Engineer", "Diver", "Explorer", "Navigator", "Pilot", "Messenger"};
        ArrayList<String> roles = new ArrayList(Arrays.asList(temp));

        for(int i=0; i<np; i++) {
            int pos = (int)(Math.random()*roles.size())+0;
            Pawn p = new Pawn(roles.remove(pos), i+1);
            pawnLoc.put(p, new int[2]);
        }
    }

    public static void shuffleTiles() {
        for(int i = 0; i < 24; i++) {
            tileLoc.put(new Tile(TILENAMES[i]), new int[2]); //TO BE CHANGED
        }
    }

    public static boolean collectTreasure(){
        ArrayList<Pawn> temp = new ArrayList<>();
        temp.addAll(pawnLoc.keySet());
        ArrayList<Card> deck = temp.get(turn).getHand();
        Map<Card, Integer> count = new TreeMap<>();
        for(Card c: deck){
            if(count.get(c) == null){count.put(c, 1);}
            count.put(c, count.get(c.getCardName())+1);
        }/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return false;
     }

    public double riseWaterLevel() {
        waterMeter.watersRise();
        return waterMeter.getWaterLevel();
    }

    public static Integer changeTurn(){
        if(turn==4){turn=0;}
        else{turn++;}
        return turn;
    }





}
