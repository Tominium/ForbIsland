import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class TreasureDeck {

    private Deque<Card> deck;
    private Deque<Card> used;
    ArrayList<Card> temp;

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

        for(int i = 0; i < 3; i++)
            deck.push(new WatersRise(null, "WatersRise"));

        for(int i = 0; i < 3; i++)
            deck.push(new SpecialCard("HelicopterRide", "SpecialCard"));

        for(int i = 0; i < 2; i++)
            deck.push(new SpecialCard("Sandbags", "SpecialCard"));

        shuffle();
    }

    public void shuffle() {
        while(deck.size()>0)
            temp.add(deck.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<Card>(temp);
    }

    public Deque getDeck() {
        return deck;
    }

    public Deque getUsed() {
        return used;
    }
}
