package Logic;

import Decks.FloodDeck;
import Decks.TreasureDeck;
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
    private final static String[] TILENAMES =
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

        setRoles(numPlayers);
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

    public double riseWaterLevel() {
        waterMeter.watersRise();
        return waterMeter.getWaterLevel()
    }



}
