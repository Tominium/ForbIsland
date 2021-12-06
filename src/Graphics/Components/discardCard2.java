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
import java.util.HashMap;

import static Logic.GameState.turn;

public class discardCard2 extends JFrame {

    private GridBagConstraints tradeGBC;
    private GridBagLayout tradeGBL;
    private Card c;
    private Pawn p;
    private GameBoardGraphic obj;
    private JPanel panel;
    private static int WIDTH = 800;
    private static int HEIGHT = 500;
    private GameState gs;

    public discardCard2(GameBoardGraphic obj, GameState gs, Pawn p) {
        panel = new JPanel();
        this.obj = obj;
        tradeGBC = new GridBagConstraints();
        tradeGBL = new GridBagLayout();
        panel.setLayout(tradeGBL);
        tradeGBC.ipadx = 2;
        tradeGBC.ipady = 2;
        this.gs = gs;

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);



        ArrayList<JButton> cards = new ArrayList<JButton>();

        for(int i = 0; i < p.getHand().size(); i++) {
            Icon icon = new ImageIcon(p.getHand().get(i).getImage());
            JButton button = new JButton(icon);
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            int ii = i;
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    c = p.getHand().get(ii);
                    p.removeCard(c);
                    GameState.treasureDeck.discardCard(c);
                    obj.getPlayerDeckView().updatePanel();
                    dispose();
                }});
            tradeGBC.gridx = i;
            panel.add(button,tradeGBC);
        }
        add(panel);

    }

}
