package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameBoardGraphic extends JFrame{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private Font Font;
    private JButton nextTurn;
    private JButton move;
    private JPanel gameBoard;
    private JPanel heliPanel;
    private JPanel specialAbility;
    private Color limeGreen;

    public GameBoardGraphic(){
        nextTurn = new JButton("Next Turn");
        move = new JButton("Move");
        gameBoard = new JPanel();
        heliPanel = new JPanel();
        specialAbility=new JPanel();
        Color limeGreen = new Color(118,218,132);
        nextTurn.setBounds(40,80,WIDTH, HEIGHT);
        nextTurn.setBackground(limeGreen);
        nextTurn.setLocation(150,150);
        move.setBounds(40,80,WIDTH, HEIGHT);
        move.setBackground(limeGreen);
        move.setLocation(300,150);
        move.addActionListener((ActionListener) this);
    }

    public void movePawn(Object j){
        Pawn.getHand();
    }

    public void tradeable(){}

    public void removeCard(){}

    public void sandBag(){}

    public void helicopter(){}

    public void specialAbility(){}

    public void winGraphics(){}

    public void loseGraphics(){}
}