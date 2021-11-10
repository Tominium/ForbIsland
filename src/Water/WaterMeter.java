package Water;

import java.awt.image.BufferedImage;

public class WaterMeter {
    private BufferedImage meter;
    private double waterLevel;

    public WaterMeter(double level){
        waterLevel = level;
    }

    public boolean hasLostGame(){
        if(waterLevel >= 5.5){
            return true;
        }
        return false;
    }

    public double watersRise(){
        waterLevel += 0.25;
        return waterLevel;
    }

    public double getWaterLevel(){
        return waterLevel;
    }
}
