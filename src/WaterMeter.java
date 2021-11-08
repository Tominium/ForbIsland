import java.awt.image.BufferedImage;

public class WaterMeter {
    private BufferedImage meter;
    private double waterLevel;

    public WaterMeter(Double level){
        waterLevel = level;
    }

    public boolean hasLostGame(){
        if(waterLevel >= 5.5){
            return true;
        }
        return false;
    }

    public double watersRise(){
        waterLevel += 1.0;
        return waterLevel;
    }

    public double getWaterLevel(){
        return waterLevel;
    }


}
