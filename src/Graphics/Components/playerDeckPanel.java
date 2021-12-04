package Graphics.Components;

import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class playerDeckPanel extends JPanel {

    private GridBagConstraints playerDeckGBC;
    private GridBagLayout playerDeckGBL;

    public playerDeckPanel(){
        setBorder(new EmptyBorder(0, 0, 0 ,35));
        playerDeckGBC = new GridBagConstraints();
        playerDeckGBL = new GridBagLayout();
        setLayout(playerDeckGBL);
        playerDeckGBC.ipadx = 2;
        playerDeckGBC.ipady = 5;
        int i =0;
        int divider = (int) (GameState.pawnLoc.get(0).getHand().size() /2.25);
        if(divider ==0){divider=1;}
        for(Pawn p: GameState.pawnLoc){
            for(int ii=0; ii<=p.getHand().size(); ii++){
                Image image;
                if(ii==0){image = p.getIcon().getScaledInstance(90/divider, 132/divider, Image.SCALE_SMOOTH);}
                else{
                    image = p.getHand().get(ii-1).getImage().getScaledInstance(90/divider, 132/divider, Image.SCALE_SMOOTH);
                }
                playerDeckGBC.gridx = ii;
                playerDeckGBC.gridy = i;
                add(new JLabel(new ImageIcon(image)), playerDeckGBC);
            }
            i++;
        }
    }
    //getImage().getScaledInstance(90, 132, Image.SCALE_SMOOTH);

    public void updatePanel(){
        removeAll();
        playerDeckGBC.ipadx = 2;
        playerDeckGBC.ipady = 5;
        int i =0;
        int divider = (int) (GameState.pawnLoc.get(0).getHand().size() /2.25);
        if(divider ==0){divider=1;}
        for(Pawn p: GameState.pawnLoc){
            for(int ii=0; ii<=p.getHand().size(); ii++){
                Image image;
                if(ii==0){image = p.getIcon().getScaledInstance(90/divider, 132/divider, Image.SCALE_SMOOTH);}
                else{
                    image = p.getHand().get(ii-1).getImage().getScaledInstance(90/divider, 132/divider, Image.SCALE_SMOOTH);
                }
                playerDeckGBC.gridx = ii;
                playerDeckGBC.gridy = i;
                add(new JLabel(new ImageIcon(image)), playerDeckGBC);
            }
            i++;
        }
        repaint();
        revalidate();
    }

    public GridBagConstraints getGBC() {
        return playerDeckGBC;
    }

    public GridBagLayout getGBL() {
        return playerDeckGBL;
    }
}

