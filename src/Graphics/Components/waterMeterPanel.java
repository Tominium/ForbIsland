package Graphics.Components;

import Logic.GameState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class waterMeterPanel extends JPanel {

    public waterMeterPanel(){
        JLabel label = new JLabel(new ImageIcon(GameState.waterMeter.getMeter()));
        label.setBorder(new EmptyBorder(100, 35, 0 ,0));
        add(label);
    }

    public void update(){
        JLabel label = new JLabel(new ImageIcon(GameState.waterMeter.getMeter()));
        label.setBorder(new EmptyBorder(100, 35, 0 ,0));
        add(label);
    }
}
