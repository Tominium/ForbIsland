package Logic;

import Cards.Card;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pawn implements Comparable<Pawn>{
    private String role;
    private ArrayList<Card> hand;
    private int turnNum;
    private int actionCount;
    private ArrayList<Integer> loc;
    private BufferedImage icon;

    public Pawn(String r, int tn){
        role = r;
        turnNum = tn;
        actionCount = 0;
        loc = new ArrayList<Integer>();
        hand = new ArrayList<>();

        String url = "src/Assets/PawnIcons/" + role + ".png";
        try{
            icon = ImageIO.read(new File(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        addCard(GameState.treasureDeck.getCard());
        addCard(GameState.treasureDeck.getCard());
        addCard(GameState.treasureDeck.getCard());
    }

    public void setLocation(int x, int y) {
        if(loc.size()==0){
            loc.add(x);
            loc.add(y);
        }
        else{
            loc.set(0, x);
            loc.set(1, y);
        }
    }

    public ArrayList<Integer> getLocation() {
        return loc;
    }

    public BufferedImage getIcon(){return icon;}

    public String getRole(){
        return role;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public int getTurnNum(){
        return turnNum;
    }

    public void setDeck(ArrayList<Card> newDeck){
        hand = newDeck;
    }

    public boolean addCard(Card c){
        if(c.getType().equals("WatersRise")){
            GameState.treasureDeck.discardCard(c);
            addCard(GameState.treasureDeck.getCard());
            return true;
        }
        if(hand.size() >= 5){
            return false;
        }else{
            hand.add(c);
            return true;
        }
    }

    public void removeCard(Card c){
        for(int i=0; i<hand.size(); i++){
            if(c.equals(hand.get(i))){hand.remove(i);}
        }
    }

    public int compareTo(Pawn p){
        if(this.getTurnNum() > p.getTurnNum()){return 1;}
        return -1;
    }

    public boolean iterateActionCount(){
        if(actionCount<3){actionCount++; return true;}
        return false;
    }




}
