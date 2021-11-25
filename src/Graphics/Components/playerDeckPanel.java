package Graphics.Components;

import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import java.awt.*;

public class playerDeckPanel extends JPanel {

    private GridBagConstraints playerDeckGBC;
    private GridBagLayout playerDeckGBL;

    public playerDeckPanel(){
        playerDeckGBC = new GridBagConstraints();
        playerDeckGBL = new GridBagLayout();
        setLayout(playerDeckGBL);
        playerDeckGBC.ipadx = 2;
        playerDeckGBC.ipady = 2;
        for(Pawn p: GameState.pawnLoc){
            System.out.println(p.getTurnNum());
            for(int i=0; i<GameState.pawnLoc.size(); i++){
                for(int ii=0; ii<=p.getHand().size(); ii++){
                    playerDeckGBC.gridx = ii;
                    playerDeckGBC.gridy = i;
                    Image image;
                    if(ii==0){image = p.getIcon();}
                    else{
                        image = p.getHand().get(ii - 1).getImage().getScaledInstance(90, 132, Image.SCALE_SMOOTH);
                    }
                    add(new JLabel(new ImageIcon(image)), playerDeckGBC);
                }}}
    }

    public void updatePanel(){
        playerDeckGBC.ipadx = 5;
        playerDeckGBC.ipady = 5;
        for(Pawn p: GameState.pawnLoc){
            System.out.println(p.getTurnNum());
            for(int i=0; i<GameState.pawnLoc.size(); i++){
                for(int ii=0; ii<p.getHand().size(); ii++){
                    playerDeckGBC.gridx = ii;
                    playerDeckGBC.gridy = i;
                    Image image;
                    if(ii==0){image = p.getIcon();}
                    else{
                        image = p.getHand().get(ii - 1).getImage().getScaledInstance(90, 132, Image.SCALE_SMOOTH);
                    }
                    add(new JLabel(new ImageIcon(image)), playerDeckGBC);
                }}}
    }

    public GridBagConstraints getGBC() {
        return playerDeckGBC;
    }

    public GridBagLayout getGBL() {
        return playerDeckGBL;
    }
}

