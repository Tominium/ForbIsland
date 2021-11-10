package Logic;
import Decks.FloodDeck;
import Decks.TreasureDeck;
import Logic.Tile;
import Water.WaterMeter;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GameState {
    public static String[] collectedTreasures;
    private BufferedImage boardTemplate;
    public static HashMap<int[], Tile> tileLoc;
    public static WaterMeter waterMeter;
    private static TreasureDeck treasureDeck;
    private static FloodDeck floodDeck;
    private static int turn;
    private static int actionCount;



}
