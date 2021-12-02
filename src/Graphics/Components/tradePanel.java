package Graphics.Components;

import Logic.GameState;
import Logic.Pawn;

import javax.swing.*;

public class tradePanel extends JPanel {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 1082 ;

    public tradePanel() {

        Pawn temp = GameState.pawnLoc.get(GameState.turn);
        //ArrayList<JButton> hand = new ArrayList<JButton>();

        JButton card1 = new JButton();
        card1.setBounds(100,100,100,100);
//        card1.setOpaque(false);
//        card1.setContentAreaFilled(false);
//        card1.setBorderPainted(false);
        JButton card2 = new JButton();
        card2.setBounds(100,100,100,100);
//        card2.setOpaque(false);
//        card2.setContentAreaFilled(false);
//        card2.setBorderPainted(false);
//        JButton card1 = new JButton();
//        card1.setBounds(100,100,100,100);
////        card1.setOpaque(false);
////        card1.setContentAreaFilled(false);
////        card1.setBorderPainted(false);
//        JButton card1 = new JButton();
//        card1.setBounds(100,100,100,100);
////        card1.setOpaque(false);
////        card1.setContentAreaFilled(false);
////        card1.setBorderPainted(false);
//        JButton card1 = new JButton();
//        card1.setBounds(100,100,100,100);
////        card1.setOpaque(false);
////        card1.setContentAreaFilled(false);
////        card1.setBorderPainted(false);



    }
}
