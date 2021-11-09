import java.util.ArrayList;

public class Pawn {
    private String role;
    private ArrayList<Card> hand;
    private int turnNum;

    public Pawn(String r){
        role = r;
        turnNum = 0;
    }

    public String getRole(){
        return role;
    }

    public ArrayList<Card> getDeck(){
        return hand;
    }

    public int getTurnNum(){
        return turnNum;
    }

    public void setDeck(ArrayList<Card> newDeck){
        hand = newDeck;
    }

    public boolean addCard(Card c){
        if(hand.size() >= 5){
            return false;
        }else{
            hand.add(c);
            return true;
        }
    }

    public int compareTo(){

    }

    public void incrementTurnNum(){
        turnNum++;
    }

    public void setTurnZero(){
        turnNum = 0;
    }




}
