package Graphics.Components;

import Cards.Card;
import Logic.GameState;
import Logic.Pawn;
import Graphics.GameBoardGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class useCard extends JFrame {
    private JPanel panel;
    private static int WIDTH = 700;
    private static int HEIGHT = 500;
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private GameBoardGraphic gb;
    private GameState gs;

    public useCard(GameBoardGraphic gb, GameState gs){
        this.gs = gs;
        panel = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        this.gb = gb;

        panel.setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Pawn p: GameState.pawnLoc){
            JButton temp = new JButton(new ImageIcon(p.getIcon().getScaledInstance(120, 166, Image.SCALE_SMOOTH)));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    showCards(p);
                }});
            buttons.add(temp);
        }
        int i=5;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; panel.add(b, gbc); i++;}

        add(panel);


        setSize(
                WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);
    }

    private void showCards(Pawn bb){
        panel.removeAll();
        int divider = (int) (GameState.pawnLoc.get(0).getHand().size() /2.75);
        if(divider ==0){divider=1;}
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Card c: bb.getHand()){
            JButton temp = new JButton(new ImageIcon(c.getImage().getScaledInstance(125/divider, 184/divider, Image.SCALE_SMOOTH)));
            temp.setOpaque(true);
            temp.setContentAreaFilled(false);
            temp.setBorderPainted(false);
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    GameState.treasureDeck.discardCard(c);
                    if(c.getCardName().contains("Sandbag")){
                        gb.sandBag();
                    }
                    else if(c.getCardName().contains("Helicopter")){
                        gb.helicopter();
                    }
                    for(int i=0; i<GameState.pawnLoc.size(); i++){
                        if(bb.equals(GameState.pawnLoc.get(i))){
                            Pawn temp = GameState.pawnLoc.get(i);
                            temp.removeCard(c);
                            GameState.pawnLoc.set(i, temp);
                            gb.updateAll();
                        }
                    }
                    dispose();
                }});
            buttons.add(temp);
        }
        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; panel.add(b, gbc); i++;}


        gbc.gridx = 5; gbc.gridy =1;
        JButton temp = new JButton("Back");
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        temp.setPreferredSize(new Dimension(75, 50));
        panel.add(temp, gbc);

        panel.repaint();
        panel.revalidate();
        this.revalidate();

    }
    public void back(){
        panel.removeAll();
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Pawn p: GameState.pawnLoc){
            JButton temp = new JButton(new ImageIcon(p.getIcon().getScaledInstance(120, 166, Image.SCALE_SMOOTH)));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    showCards(p);
                }});
            buttons.add(temp);
        }
        int i=5;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; panel.add(b, gbc); i++;}

        panel.repaint();
        panel.revalidate();
        this.revalidate();
    }
}
