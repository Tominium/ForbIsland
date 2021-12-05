package Graphics.Components;

import Cards.Card;
import Graphics.GameBoardGraphic;
import Logic.GameState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class discardCard extends JDialog {

    private JPanel panel;
    private static int WIDTH = 1000;
    private static int HEIGHT = 1000;
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private GameState gb;
    private GameBoardGraphic gs;
    private Card chosen = null;

    public discardCard(GameState gb, int a, GameBoardGraphic gs){
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);

        panel = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.ipadx = 5;

        this.gs = gs;
        this.gb = gb;
        int turn = GameState.turn;

        panel.setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        ArrayList<Card> pawnDeck = GameState.pawnLoc.get(GameState.turn).getHand();
        for(Card c: pawnDeck){
            JButton temp = new JButton(new ImageIcon(c.getImage().getScaledInstance(100, 147, Image.SCALE_SMOOTH)));
            //temp.setBorder(new EmptyBorder(30, 0, 0 ,0));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    chosen=c;
                }});
            buttons.add(temp);
        }
        gbc.gridx =0; gbc.gridy = 1;

            JLabel temp = new JLabel("Select Card To Discard", SwingConstants.CENTER);
            temp.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
            temp.setBorder(new EmptyBorder(0, 0, 30 ,0));
            panel.add(temp, gbc);

        int i=0;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=3; panel.add(b, gbc); i++;}

        gbc.gridx = 6; gbc.gridy =7;
        JButton temp1 = new JButton("Confirm");
        temp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gb.getTreasureDeck().discardCard(chosen);
                GameState.pawnLoc.get(turn).removeCard(chosen);
                gs.getPlayerDeckView().updatePanel();
                gs.updateAll();

                setVisible(false);
                dispose();
            }
        });

panel.add(temp, gbc);

        add(panel);

    }
}
