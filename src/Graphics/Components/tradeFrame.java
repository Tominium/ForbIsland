package Graphics.Components;

import Logic.GameState;
import Logic.Pawn;

import javax.swing.JFrame;
import java.awt.*;

public class tradeFrame extends JFrame {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 563;

    public tradeFrame() {
        super("Trade");
        Container win = getContentPane();
        win.setLayout(null);

        Pawn temp = GameState.pawnLoc.get(GameState.turn);
        int count = 0;
    }
}
