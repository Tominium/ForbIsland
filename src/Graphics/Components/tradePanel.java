package Graphics.Components;

import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class tradePanel extends JPanel {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 1082 ;

    public tradePanel() {

        Pawn temp = GameState.pawnLoc.get(GameState.turn);
        //ArrayList<JButton> hand = new ArrayList<JButton>();

        JButton card1 = new JButton();
        card1.setBounds(100,100,100,100);

    }
}
