/*
 * Created by JFormDesigner on Sun Nov 14 12:36:04 CST 2021
 */

package Tests;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class GameBoardTest extends JPanel {
    public GameBoardTest() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tim Tom
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Breakers Bridge.png")));
        add(label1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Bronze Gate.png")));
        add(label2, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Cave of Embers.png")));
        add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label4 ----
        label4.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Cave of Shadows.png")));
        add(label4, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label5 ----
        label5.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Cliffs of Abandon.png")));
        add(label5, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label6 ----
        label6.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Copper Gate.png")));
        add(label6, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Coral Palace.png")));
        add(label7, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label8 ----
        label8.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Crimson Forest.png")));
        add(label8, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label9 ----
        label9.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Dunes of Deception.png")));
        add(label9, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label10 ----
        label10.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Fools' Landing.png")));
        add(label10, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label11 ----
        label11.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Gold Gate.png")));
        add(label11, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label12 ----
        label12.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Howling Garden.png")));
        add(label12, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 0), 0, 0));

        //---- label13 ----
        label13.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Iron Gate.png")));
        add(label13, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label14 ----
        label14.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Lost Lagoon.png")));
        add(label14, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label15 ----
        label15.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Misty Marsh.png")));
        add(label15, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label16 ----
        label16.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Observatory.png")));
        add(label16, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label17 ----
        label17.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Phantom Rock.png")));
        add(label17, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label18 ----
        label18.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Silver Gate.png")));
        add(label18, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 0), 0, 0));

        //---- label19 ----
        label19.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Temple of the Moon.png")));
        add(label19, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label20 ----
        label20.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Temple of the Sun.png")));
        add(label20, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label21 ----
        label21.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Tidal Palace.png")));
        add(label21, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label22 ----
        label22.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Twilight Hollow.png")));
        add(label22, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 3, 3), 0, 0));

        //---- label23 ----
        label23.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Watchtower.png")));
        add(label23, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 3), 0, 0));

        //---- label24 ----
        label24.setIcon(new ImageIcon(getClass().getResource("/Assets/zones/Whispering Garden.png")));
        add(label24, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 3), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Tim Tom
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
