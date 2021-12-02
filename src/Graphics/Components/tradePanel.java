package Graphics.Components;

import Cards.Card;
import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class tradePanel extends JPanel {

    private GridBagConstraints tradeGBC;
    private GridBagLayout tradeGBL;
    private Card c;

    public tradePanel() {

        tradeGBC = new GridBagConstraints();
        tradeGBL = new GridBagLayout();
        setLayout(tradeGBL);
        tradeGBC.ipadx = 2;
        tradeGBC.ipady = 2;

        Pawn temp = GameState.pawnLoc.get(GameState.turn);

        ArrayList<JButton> cards = new ArrayList<JButton>();

        for(int i = 0; i < temp.getHand().size(); i++) {
            Icon icon = new ImageIcon(temp.getHand().get(i).getImage());
            JButton button = new JButton(icon);
            int ii = i;
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    c = temp.getHand().get(ii);
                    playerSelection();
                }});
            tradeGBC.gridx = i;

            add(button,tradeGBC);
        }

    }

    public void playerSelection() {
        removeAll();

        for(int i = 0; i < GameState.pawnLoc.size(); i++) {
            Icon icon = new ImageIcon(GameState.pawnLoc.get(i).getIcon());
            JButton button = new JButton(icon);
            int ii = i;
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                }});
            tradeGBC.gridx = i;

            add(button,tradeGBC);
        }


    }
}
