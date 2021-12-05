package Decks;

import Cards.FloodCard;
import Logic.GameState;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class FloodDeck {

    private Deque<FloodCard> deck;
    private Deque<FloodCard> used;


    public FloodDeck() {
        deck = new ArrayDeque<FloodCard>();
        used = new ArrayDeque<FloodCard>();

        for(int i = 0; i < 24; i++)
            deck.push(new FloodCard(GameState.TILENAMES[i], "FloodCard"));
        shuffle();
    }

    public void shuffle() {
        ArrayList<FloodCard> temp = new ArrayList<FloodCard>();
        while(deck.size()>0)
            temp.add(deck.pop());
        Collections.shuffle(temp);

        deck = new ArrayDeque<FloodCard>(temp);
    }

    public FloodCard getCard(){
        if(deck.size()>0){used.add(deck.peek());return deck.pop();}
        else{resetDeck(); used.add(deck.peek()); return deck.pop();}
    }

    public void resetDeck(){
        ArrayList<FloodCard> temp = new ArrayList<>();
        while(used.size()>0)
            temp.add(used.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<FloodCard>(temp);
    }


}
