package Graphics;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class HelpMenu extends JFrame {
    JLabel label = new JLabel();
    private JTextPane pane;

    public HelpMenu() {







        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        add(new Panel());
        setVisible(true);
    }


}
