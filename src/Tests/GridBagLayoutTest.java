//package Tests;
//
//import Logic.GameState;
//import Logic.Tile;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.HashMap;
//
//public class GridBagLayoutTest extends JFrame implements MouseListener {
//    private final GridBagLayout GridBagLayoutgrid;
//    private GridBagConstraints gbc;
//    private JPanel panel;
//    private HashMap<String, Tile> localTileLoc;
//
//    public static void main(String[] args) {
//        GridBagLayoutTest a = new GridBagLayoutTest();
//    }
//    public GridBagLayoutTest() {
//        new GameState(4, "Hard");
//
//        panel = new JPanel(new GridBagLayout());
//        GridBagLayoutgrid = new GridBagLayout();
//        gbc = new GridBagConstraints();
//        panel.setLayout(GridBagLayoutgrid);
//        add(panel);
//
//        localTileLoc = new HashMap<>();
//
//        //this.setLayout(GridBagLayoutgrid);
//        setTitle("GridBag Layout Example");
//        gbc.fill = GridBagConstraints.HORIZONTAL;
////        GridBagLayout layout = new GridBagLayout();
////        this.setLayout(layout);
//
//
//        int x = 2; int y=0; int i =0;
//        for(Tile t: GameState.tileLoc){
//            gbc.gridx = x;
//            gbc.gridy = y;
//            int[] loc = {x,y};
//            GameState.tileLoc.put(t, loc);
//            localTileLoc.put("(" + x + ", " + y + ")", t);
//            Image image = t.getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH); // transform it
//            panel.add(new JLabel(new ImageIcon(image)), gbc);
//            if(i == 0|| i == 5){
//                    if(x == 3){
//                        y++;
//                        i++;
//                        x = 1;
//                    }
//                    else {
//                        x++;
//                    }
//            }
//            else if(i == 1 || i == 4){
//                if(i == 1){
//                    if(x == 4){
//                        y++;
//                        i++;
//                        x = 0;
//                    }
//                    else{
//                        x++;
//                    }
//                }
//                else if(x == 4){
//                    y++;
//                    i++;
//                    x = 2;
//                }
//                else{
//                    x++;
//                }
//            }
//            else if(i == 2 || i == 3){
//                if(i == 2){
//                    if(x == 5){
//                        y++;
//                        i++;
//                        x = 0;
//                    }
//                    else{
//                        x++;
//                    }
//                }
//                else if(x == 5){
//                    y++;
//                    i++;
//                    x = 1;
//                }
//                else{
//                    x++;
//                }
//            }
//        }
//        System.out.println(localTileLoc);
//        pack();
//        addMouseListener(this);
//
//        setSize(3840, 2160);
//        setPreferredSize(getSize());
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        Component a = findComponentAt(e.getPoint());
//        int griX = GridBagLayoutgrid.getConstraints(a).gridx;
//        int griY = GridBagLayoutgrid.getConstraints(a).gridy;
//        int[] loc = {griX, griY};
//        System.out.println("(" + griX + ", " + griY + ")");
//        localTileLoc.get("(" + griX + ", " + griY + ")").floodTile();
//        a.repaint();
//        a.revalidate();
//        panel.revalidate();
//        panel.repaint();
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}