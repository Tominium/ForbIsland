package Graphics.Components;

import Cards.Card;
import Logic.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class discardCard extends JFrame {

    private JPanel panel;
    private static int WIDTH = 900;
    private static int HEIGHT = 500;
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private GameState gb;
    private Card chosen = null;
    private Card chosen1 = null;

    public discardCard(GameState gb, int a){
        panel = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        this.gb = gb;

        panel.setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        ArrayList<Card> pawnDeck = GameState.pawnLoc.get(GameState.turn).getHand();
        for(Card c: pawnDeck){
            JButton temp = new JButton(new ImageIcon(c.getImage().getScaledInstance(125, 184, Image.SCALE_SMOOTH)));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(chosen==null){chosen=c;}
                    else{chosen1=c;}
                }});
            buttons.add(temp);
        }
        gbc.gridx =0; gbc.gridy = -1;
        if(a==1){
            panel.add(new JLabel("After you draw treasure cards, you will have too many cards in your hand. Please select a card to discard"), gbc);
        }
        else if(a==2){
            panel.add(new JLabel("After you draw treasure cards, you will have too many cards in your hand. Please select " +2+" cards to discard"), gbc);
        }
        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=3; panel.add(b, gbc); i++;}

        gbc.gridx = 5; gbc.gridy =1;
        JButton temp = new JButton("Confirm");
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gb.getTreasureDeck().discardCard(chosen);
                GameState.pawnLoc.get(GameState.turn).removeCard(chosen);
                if(chosen1 != null){gb.getTreasureDeck().discardCard(chosen1);
                    GameState.pawnLoc.get(GameState.turn).removeCard(chosen1);}

                dispose();
            }
        });

        GridBagConstraints frameGBC = new GridBagConstraints();
        setLayout(new GridBagLayout());
        frameGBC.gridx =0;
        frameGBC.gridy = 0;

        add(panel, frameGBC);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);
    }
}
