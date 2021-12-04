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

public class tradePanel extends JFrame {

    private GridBagConstraints tradeGBC;
    private GridBagLayout tradeGBL;
    private Card c;
    private GameBoardGraphic obj;
    private JPanel panel;
    private static int WIDTH = 800;
    private static int HEIGHT = 500;

    public tradePanel(GameBoardGraphic obj) {
        panel = new JPanel();
        this.obj = obj;
        tradeGBC = new GridBagConstraints();
        tradeGBL = new GridBagLayout();
        panel.setLayout(tradeGBL);
        tradeGBC.ipadx = 2;
        tradeGBC.ipady = 2;

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);


        Pawn temp = GameState.pawnLoc.get(GameState.turn);

        ArrayList<JButton> cards = new ArrayList<JButton>();

        for(int i = 0; i < temp.getHand().size(); i++) {
            Icon icon = new ImageIcon(temp.getHand().get(i).getImage());
            JButton button = new JButton(icon);
            button.setOpaque(true);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            int ii = i;
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    c = temp.getHand().get(ii);
                    playerSelection();
                }});
            tradeGBC.gridx = i;
            panel.add(button,tradeGBC);
        }
        add(panel);

    }

    public void playerSelection() {
        panel.removeAll();

        HashMap<Point, ArrayList<Integer>> temp = GameState.pawnLocHash();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(ArrayList<Integer> a: temp.values()) {
            if (a.contains(turn)) {
                al = a;
            }
        }

        for(int i = 0; i < al.size(); i++) {
            if(!(i==turn)) {
                Icon icon = new ImageIcon(GameState.pawnLoc.get(al.get(i)).getIcon());
                JButton button = new JButton(icon);
                button.setOpaque(true);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                int ii = i;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                tradeGBC.gridx = i;

                panel.add(button, tradeGBC);
            }

        }
        panel.repaint();
        panel.revalidate();
    }
}
