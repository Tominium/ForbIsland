package Decks;

import Cards.Card;
import Cards.SpecialCard;
import Cards.TreasureCard;
import Water.WatersRise;
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
            deck.push(new TreasureCard("Earth", "Cards.TreasureCard"));
            deck.push(new TreasureCard("Wind", "Cards.TreasureCard"));
            deck.push(new TreasureCard("Fire", "Cards.TreasureCard"));
            deck.push(new TreasureCard("Ocean", "Cards.TreasureCard"));
        }

        for(int i = 0; i < 3; i++)
            deck.push(new WatersRise(null, "Water.WatersRise"));

        for(int i = 0; i < 3; i++)
            deck.push(new SpecialCard("HelicopterRide", "Cards.SpecialCard"));

        for(int i = 0; i < 2; i++)
            deck.push(new SpecialCard("Sandbags", "Cards.SpecialCard"));

        shuffle();
    }

    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        while(deck.size()>0)
            temp.add(deck.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<Card>(temp);
    }
}
