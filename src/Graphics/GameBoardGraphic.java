package Graphics;

import javax.swing.*;
import java.awt.*;
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
        gameBoard = new JPanel(new GridBagLayout());
        heliPanel = new JPanel(new GridBagLayout());
        specialAbility= new JPanel(new GridBagLayout());
        limeGreen = new Color(118,218,132);
        nextTurn.setBounds(40,80,WIDTH, HEIGHT);
        nextTurn.setBackground(limeGreen);
        nextTurn.setLocation(150,150);
        move.setBounds(40,80,WIDTH, HEIGHT);
        move.setBackground(limeGreen);
        move.setLocation(300,150);
    }

    public void movePawn(){}

    public void tradeable(){}

    public void removeCard(){}

    public void sandBag(){}

    public void helicopter(){}

    public void specialAbility(){}

    public void winGraphics(){}

    public void loseGraphics(){}
}
