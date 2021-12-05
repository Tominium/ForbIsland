package Graphics.Components;

import Cards.Card;
import Graphics.GameBoardGraphic;
import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class discardCard extends JDialog {

    private JPanel panel;
    private static int WIDTH = 700;
    private static int HEIGHT = 600;
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private GameState gb;
    private GameBoardGraphic gs;
    private Card chosen = GameState.pawnLoc.get(GameState.turn).getHand().get(0);

    public discardCard(GameState gb, int a, GameBoardGraphic gs){
        super(gs, "Discard Card");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
//        setVisible(true);

        panel = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        this.gs = gs;
        this.gb = gb;
        int turn = GameState.turn;

        panel.setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        ArrayList<Card> pawnDeck = GameState.pawnLoc.get(GameState.turn).getHand();
        int divider = (int) (GameState.pawnLoc.get(GameState.turn).getHand().size() /3);
        if(divider ==0){divider=1;}
        for(Card c: pawnDeck){
            JButton temp = new JButton(new ImageIcon(c.getImage().getScaledInstance(100/divider, 147/divider, Image.SCALE_SMOOTH)));
            //temp.setBorder(new EmptyBorder(30, 0, 0 ,0));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    chosen=c;
                }});
            buttons.add(temp);
        }

        int i=0;
        gbc.ipadx = 7;
        for(JButton b: buttons){gbc.gridx=i; gbc.gridy=8; panel.add(b, gbc); i++;}

        gbc.gridx = i/2; gbc.gridy =9;
        JButton temp1 = new JButton("Confirm");
        temp1.setPreferredSize(new Dimension(110, 35));
        temp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gb.getTreasureDeck().discardCard(chosen);
                Pawn pp = GameState.pawnLoc.get(turn);
               System.out.println("Remove Card: " + pp.removeCard(chosen));
                GameState.pawnLoc.set(turn, pp);
                gs.getPlayerDeckView().updatePanel();
                gs.updateAll();

                setVisible(false);
                dispose();
            }
        });

panel.add(temp1, gbc);

        gbc.gridx =i/2; gbc.gridy = 0;

        JLabel temp = new JLabel("Select Card To Discard", SwingConstants.CENTER);
        temp.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
       // temp.setBorder(new EmptyBorder(0, 0, 20 ,0));
        panel.add(temp, gbc);

        add(panel);

    }
}
