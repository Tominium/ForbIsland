package Logic;

import Cards.Card;

import java.util.ArrayList;

public class Pawn implements Comparable<Pawn>{
    private String role;
    private ArrayList<Card> hand;
    private int turnNum;
    private int actionCount;

    public Pawn(String r, int tn){
        role = r;
        turnNum = tn;
        actionCount = 0;
    }

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
        if(hand.size() >= 5){
            return false;
        }else{
            hand.add(c);
            return true;
        }
    }

    public int compareTo(Pawn p){
        if(this.getTurnNum() > p.getTurnNum()){return 1;}
        return -1;
    }

    public void setTurnZero(){
        turnNum = 0;
    }

    public boolean iterateActionCount(){
        if(actionCount<3){actionCount++; return true;}
        return false;
    }




}
