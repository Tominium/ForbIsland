package Water;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WaterMeter {
    private Image meter;
    private double waterLevel;

    public WaterMeter(double level){
        waterLevel = level;
        String url = "/Assets/WaterMeterParts/" + waterLevel + ".png";
        try{
            meter = ImageIO.read(WaterMeter.class.getResource(url)).getScaledInstance(221, 669,  Image.SCALE_SMOOTH);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasLostGame(){
        if(waterLevel >= 4.25){
            return true;
        }
        return false;
    }

    public double watersRise(){
        waterLevel += 0.25;
        System.out.println("Water Level " + waterLevel);
        updateMeter();
        return waterLevel;
    }

    public int getWaterLevel(){
        if(waterLevel <= 2.25){return 2;}
        if(waterLevel <= 3){return 3;}
        if(waterLevel <= 3.25){return 4;}
        if(waterLevel <= 4.0){return 5;}
        return 6;
    }

    private void updateMeter(){
        String url = "src/Assets/WaterMeterParts/" + waterLevel + ".png";
        try{
            meter = ImageIO.read(new File(url)).getScaledInstance(221, 669,  Image.SCALE_SMOOTH);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getMeter(){
        return meter;
    }
}
