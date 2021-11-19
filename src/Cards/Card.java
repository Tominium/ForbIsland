package Cards;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {

    private BufferedImage image;
    private String cardName;
    private String cardType;

    public Card(String name, String type){
        cardName = name;
        cardType = type;
        String url = "src/Assets/Cards/" + name + ".png";
        try{
            image = ImageIO.read(new File(url));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(name);
        }
    }
    public String getCardName(){
        return cardName;
    }

    public BufferedImage getImage(){
        return image;
    }

    public String getType(){
        return cardType;
    }

    public boolean equals(Object obj) {
        Card c = (Card) obj;
        return this.getCardName().equals(c.getCardName());
    }
}
