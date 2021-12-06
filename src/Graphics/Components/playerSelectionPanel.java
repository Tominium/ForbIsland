package Graphics.Components;

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

public class playerSelectionPanel extends JFrame {
    private GameBoardGraphic obj;
    private GridBagConstraints tradeGBC;
    private GridBagLayout tradeGBL;
    private Pawn p;
    private JPanel panel;
    private static int WIDTH = 800;
    private static int HEIGHT = 500;
    private GameState gs;
    public static Pawn otherPawn;
    public static Pawn otherPawn2;

    public playerSelectionPanel(GameBoardGraphic obj, GameState gs) {
        this.obj = obj;
        panel = new JPanel();
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

        for(int i = 0; i < GameState.pawnLoc.size(); i++) {
            if(!(i==turn)) {
                Icon icon = new ImageIcon(GameState.pawnLoc.get(i).getIcon());
                JButton button = new JButton(icon);
                button.setOpaque(true);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                int ii = i;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        otherPawn = GameState.pawnLoc.get(ii);
                        GameBoardGraphic.count = 0;
                        obj.getGameTiles().moveOther(otherPawn);
                        obj.updateAll();
                        gs.iterateAction();
                        dispose();
                    }
                });
                tradeGBC.gridx = i;

                panel.add(button, tradeGBC);
            }
        }
        add(panel);

    }

    public playerSelectionPanel(GameState gs, GameBoardGraphic obj) {
        this.obj = obj;
        panel = new JPanel();
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

        for(int i = 0; i < GameState.pawnLoc.size(); i++) {
            if(!(i==turn)) {
                Icon icon = new ImageIcon(GameState.pawnLoc.get(i).getIcon());
                JButton button = new JButton(icon);
                button.setOpaque(true);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                int ii = i;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        otherPawn2 = GameState.pawnLoc.get(ii);
                    }
                });
                tradeGBC.gridx = i;

                panel.add(button, tradeGBC);
            }
        }
        add(panel);

    }

}
