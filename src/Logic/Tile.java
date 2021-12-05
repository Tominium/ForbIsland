package Logic;

import Graphics.Components.GameBoard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Tile {

    private String name;
    private boolean flooded;
    private BufferedImage image;
    private boolean sunk;
    private String treasure;
    private ArrayList<Integer> loc;

    public Tile(String n) {
        name = n;
        image = null;
        flooded = false;
        sunk = false;
        treasure = "";
        loc = new ArrayList<Integer>();
        String url = "/Assets/zones/" + name + ".png.png";
        try{
            image = ImageIO.read(Tile.class.getResource(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLocation(int x, int y) {
        if(loc.size()==0){loc.add(x);loc.add(y);}
        else{loc.set(0, x); loc.set(1,y);}
    }

    public ArrayList<Integer> getLocation() {
        return loc;
    }

    public boolean floodTile() {
        if(flooded == false) {
            flooded = true;
            String url = "/Assets/zones/" + name + "_flood.png.png";
            try{
                image = ImageIO.read(Tile.class.getResource(url));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        if(flooded){
            sinkTile();
        }
        return false;
    }

    public boolean sinkTile() {
        if(sunk == false&&flooded == true) {
            sunk = true;
            try{
                image = GameBoard.resize(ImageIO.read(Tile.class.getResource("/Assets/Empty.png")), 120, 120);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean shoreUp() {
        if(sunk == false&&flooded == true) {
            flooded = false;
            String url = "/Assets/zones/" + name + ".png.png";
            try{
                image = ImageIO.read(Tile.class.getResource(url));
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

    @Override
    public boolean equals(Object o) {
        Tile t = (Tile)o;
        return this.getName().equals(t.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flooded, image, sunk, treasure, loc);
    }
}
