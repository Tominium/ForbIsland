package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tile {

    private String name;
    private boolean flooded;
    private BufferedImage image;
    private boolean sunk;
    private String treasure;
    private ArrayList<Integer> loc;

    public Tile(String n) {
        name = n;
        flooded = false;
        sunk = false;
        treasure = "";
        loc = new ArrayList<Integer>();
        String url = "src/Assets/zones/" + name + ".png";
        try{
            image = ImageIO.read(new File(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOriginalLocation(int x, int y) {
        loc.add(x);
        loc.add(y);
    }

    public ArrayList<Integer> getLocation() {
        return loc;
    }

    public boolean floodTile() {
        if(flooded == false) {
            flooded = true;
            String url = "src/Assets/zones/" + name + "_flood.png";
            try{
                image = ImageIO.read(new File(url));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
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
            String url = "src/Assets/zones/" + name + ".png";
            try{
                image = ImageIO.read(new File(url));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
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

    public boolean isFlooded() {
        return flooded;
    }

    public boolean isSunk() {
        return sunk;
    }

    public boolean hasTreasure() {
        if(treasure != "")
            return true;
        return false;
    }


}
