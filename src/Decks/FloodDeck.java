package Decks;

import Cards.FloodCard;
import Graphics.Components.GameBoard;
import Logic.GameState;
import Logic.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
        if(!deck.isEmpty()){used.add(deck.peek());return deck.pop();}
        else{     deck = new ArrayDeque<FloodCard>();
            used = new ArrayDeque<FloodCard>();

            for(int i = 0; i < 24; i++)
                deck.push(new FloodCard(GameState.TILENAMES[i], "FloodCard"));
            shuffle(); used.add(deck.peek()); return deck.pop();}
    }

    public void resetDeck(){
        ArrayList<FloodCard> temp = new ArrayList<>();
        while(!used.isEmpty())
            temp.add(used.pop());

        Collections.shuffle(temp);

        deck = new ArrayDeque<FloodCard>(temp);
        used = new ArrayDeque<FloodCard>();
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
