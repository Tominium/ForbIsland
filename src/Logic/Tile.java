package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tile {

    private String name;
    private boolean flooded;
    private BufferedImage image;
    private boolean sunk;
    private String treasure;

    public Tile(String n) {
        name = n;
        flooded = false;
        sunk = false;
        treasure = "";
        String url = "src/Assets/zones/" + name + ".png";
        try{
            image = ImageIO.read(new File(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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


    public boolean hasTreasure() {
        if(treasure != "")
            return true;
        return false;
    }

    public boolean returnSunk(){
        return sunk;
    }


}
