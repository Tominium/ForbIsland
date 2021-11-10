import java.awt.image.BufferedImage;

public class Tile {

    private String name;
    private boolean flooded;
    private BufferedImage image;
    private boolean sunk;
    private String treasure;

    public Tile() {
        flooded = false;
        sunk = false;
        treasure = "";
    }

    public boolean floodTile() {
        if(flooded == false) {
            flooded = true;
            return true;
        }
        return false;
    }

    public boolean sinkTile() {
        if(sunk == false&&flooded == true) {
            sunk = true;
            return true;
        }
        return false;
    }

    public boolean shoreUp() {
        if(sunk == false&&flooded == true) {
            flooded = false;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage b) {
        image = b;
    }

    public boolean hasTreasure() {
        if(treasure != "")
            return true;
        return false;
    }


}
