package Decks;

import Cards.FloodCard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class FloodDeck {

    private Deque<FloodCard> deck;
    private Deque<FloodCard> used;
    ArrayList<FloodCard> temp;
    private final static String[] CARDVALUES =
            {"Whispering Garden","Watchtower","Twilight Hollow","Tidal Palace"
                    ,"Temple of the Sun","Temple of the Moon","Silver Gate","Phantom Rock","Observatory","Misty Marsh"
                    ,"Lost Lagoon","Iron Gate","Howling Garden","Gold Gate","Fools' Landing", "Dunes of Deception",
                    "Crimson Forest", "Coral Palace", "Copper Gate", "Cliffs of Abandon", "Cave of Shadows", "" +
                    "Cave of Embers", "Bronze Gate", "Breakers Bridge"};

    public FloodDeck() {
        deck = new ArrayDeque<FloodCard>();
        used = new ArrayDeque<FloodCard>();

        for(int i = 0; i < 24; i++)
            deck.push(new FloodCard(CARDVALUES[i], "Cards.FloodCard"));

        shuffle();
    }

    public void shuffle() {
        while(deck.size()>0)
            temp.add(deck.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<FloodCard>(temp);
    }

    public Deque getDeck() {
        return deck;
    }

    public Deque getUsed() {
        return used;
    }
}
