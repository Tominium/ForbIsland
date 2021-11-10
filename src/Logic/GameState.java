package Logic;
import Logic.Tile;
import Water.WaterMeter;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class GameState {
    public static String[] collectedTreasures;
    private BufferedImage boardTemplate;
    public static HashMap<int[], Tile> tileLoc;
    public static WaterMeter waterMeter;

}
