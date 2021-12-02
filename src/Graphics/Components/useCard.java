package Graphics.Components;

import Cards.Card;
import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class useCard extends JPanel {
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;

    public useCard(){
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Pawn p: GameState.pawnLoc){
            JButton temp = new JButton((Icon) p.getIcon());
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    showCards(p);
                }});
            buttons.add(temp);
        }
        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; add(b, gbc); i++;}
    }

    private void showCards(Pawn bb){
        removeAll();

        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Card c: bb.getHand()){
            JButton temp = new JButton((Icon) c.getImage());
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("showCards");
                }});
        }
        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; add(b, gbc); i++;}


        this.repaint();
        this.revalidate();
    }
}
