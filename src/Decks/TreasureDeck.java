package Decks;

import Cards.Card;
import Cards.SpecialCard;
import Cards.TreasureCard;
import Graphics.Components.GameBoard;
import Logic.Tile;
import Water.WatersRise;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class TreasureDeck {

    private Deque<Card> deck;
    private Deque<Card> used;

    public TreasureDeck() {
        //5 of each treasure
        //3 watersRise
        //3 heli
        //2 sand

        deck = new ArrayDeque<Card>();
        used = new ArrayDeque<Card>();

        for(int i = 0; i < 5; i++)
        {
            deck.push(new TreasureCard("Earth", "TreasureCard"));
            deck.push(new TreasureCard("Wind", "TreasureCard"));
            deck.push(new TreasureCard("Fire", "TreasureCard"));
            deck.push(new TreasureCard("Ocean", "TreasureCard"));
        }

        for(int i = 0; i < 3; i++){
            deck.push(new WatersRise("WatersRise", "WatersRise"));
            deck.push(new SpecialCard("HelicopterRide", "SpecialCard"));
            deck.push(new SpecialCard("Sandbag", "SpecialCard"));
        }
        shuffle();
    }

    public Card getCard(){
        if(deck.size() > 0){return deck.pop();}
        else{resetDeck(); return deck.pop();}
    }

    private void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        while(deck.size()>0)
            temp.add(deck.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<Card>(temp);
    }

    private void resetDeck(){
        ArrayList<Card> temp = new ArrayList<Card>();
        while(used.size()>0)
            temp.add(used.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<Card>(temp);
    }

    public void discardCard(Card c){
        used.push(c);
    }

    public BufferedImage getTopUsed(){
        if(used.isEmpty()){
            try{
                return GameBoard.resize(ImageIO.read(Tile.class.getResource("/Assets/Empty.png")), 120, 120);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            return used.peek().getImage();
        }
        return used.peek().getImage();
    }
}
