package Graphics.Components;

import Graphics.GameBoardGraphic;
import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Helicopter extends JFrame {

    private JPanel panel;
    private static int WIDTH = 650;
    private static int HEIGHT = 500;
    private GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private GameBoardGraphic gb;
    private ArrayList<Pawn> pawnsNew;

    public Helicopter(GameBoardGraphic gb){
        this.gb = gb;
        panel = new JPanel();
        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();

        panel.setLayout(GridBagLayoutgrid);
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        HashMap<Point, ArrayList<Integer>> test = GameState.pawnLocHash();
        for(Point p: test.keySet()){
            JButton temp = new JButton(new ImageIcon(GameBoardGraphic.localTileLoc.get(p).getImage().getScaledInstance(75, 75,  Image.SCALE_SMOOTH)));
            temp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    showPlayers(p);
                }});
            buttons.add(temp);
        }
        int i=0;
        for(JButton bb: buttons){gbc.gridx=i; gbc.gridy=3; panel.add(bb, gbc); i++;}
        gbc.gridx=i/2; gbc.gridy = 0;
        panel.add(new JLabel("Choose Tile With Players"), gbc);

        add(panel);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.HIDE_ON_CLOSE));
        setResizable(false);
        setVisible(true);
    }

    public void showPlayers(Point p){
        panel.removeAll();
        ArrayList<JCheckBox> temp1 = new ArrayList<>();
        ArrayList<Pawn> pawns = new ArrayList<>();
        HashMap<Point, ArrayList<Integer>> test = GameState.pawnLocHash();
        for(int ab: test.get(p)){
            JCheckBox c1 = new JCheckBox(new ImageIcon(GameState.pawnLoc.get(ab).getIcon().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
            c1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pawns.add(GameState.pawnLoc.get(ab));
                }
            });
            temp1.add(c1);
        }
        int i=0;
        for(JCheckBox bb: temp1){gbc.gridx=i; gbc.gridy=3; panel.add(bb, gbc); i++;}

        JButton but = new JButton("Confirm");
        but.setPreferredSize(new Dimension(110, 35));
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gb.getGameTiles().chooseMove();
                gb.updateAll();
            }
        });
        gbc.gridx =i/2;
        gbc.gridy = 4;
        panel.add(but, gbc);
        pawnsNew = pawns;

        JLabel newLabel = new JLabel("Choose Players to Move");
        gbc.gridx= i/2; gbc.gridy = 0;
        panel.add(newLabel, gbc);

        panel.repaint();
        panel.revalidate();
    }
    public ArrayList<Pawn> getPawnsNew(){return pawnsNew;}

}
