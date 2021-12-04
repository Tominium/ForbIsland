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
    private static int WIDTH = 1000;
    private static int HEIGHT = 800;
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private GameBoardGraphic gb;

    public useCard(GameBoardGraphic gb){
        panel = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        this.gb = gb;

        panel.setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Pawn p: GameState.pawnLoc){
            JButton temp = new JButton(new ImageIcon(p.getIcon().getScaledInstance(100, 138, Image.SCALE_SMOOTH)));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    showCards(p);
                }});
            buttons.add(temp);
        }
        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; panel.add(b, gbc); i++;}
        add(panel);


        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);
    }

    private void showCards(Pawn bb){
        panel.removeAll();

        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for(Card c: bb.getHand()){
            JButton temp = new JButton(new ImageIcon(c.getImage()));
            temp.setOpaque(true);
            temp.setContentAreaFilled(false);
            temp.setBorderPainted(false);
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(c.getCardName().contains("Sandbag")){
                        gb.sandBag();
                        dispose();
                    }
                }});
            buttons.add(temp);
        }
        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=0; panel.add(b, gbc); i++;}

        panel.repaint();
        panel.revalidate();
        this.revalidate();

    }
}
