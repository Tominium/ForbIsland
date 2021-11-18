package Graphics;

import Logic.GameState;
import Logic.Pawn;
import Logic.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class GameBoardGraphic extends JFrame implements MouseListener {
    private static final int WIDTH = 2560;
    private static final int HEIGHT = 1440;
    private Font Font;
    private JButton nextTurn;
    private JButton move;
    private JPanel gameTiles;
    private JPanel playerDeckView;
    private JPanel heliPanel;
    private JPanel specialAbility;
    private final GridBagLayout GridBagLayoutgrid;
    private GridBagConstraints gbc;
    private HashMap<int[], Tile> localTileLoc;

    public GameBoardGraphic(){
        Container win = getContentPane();
        win.setLayout(new GridBagLayout());
        addMouseListener(this);

        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        playerDeckView =  new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(Pawn p: GameState.pawnLoc){
                    for(int i=0; i<p.getHand().size(); i++){
                        for(int a=100; a<500; a+=100){
                            g.drawImage(p.getHand().get(i).getImage(), (i+1)*100, a, null);
                        }
                    }
                }
            }
        };
        this.add(playerDeckView, frameGbc);

        localTileLoc = new HashMap<>();


        GridBagLayoutgrid = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.setLayout(GridBagLayoutgrid);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gameTiles = new JPanel();
        gameTiles.setLayout(GridBagLayoutgrid);
        frameGbc.gridx = 1;
        frameGbc.gridy = 1;
        add(gameTiles, frameGbc);

        int x = 2; int y=0; int i =0;
        for(Tile t: GameState.tileLoc){
            gbc.gridx = x;
            gbc.gridy = y;
            int[] loc = {x,y};
            t.setLocation(x,y);
            localTileLoc.put(loc, t);
            Image image = t.getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH); // transform it
            gameTiles.add(new JLabel(new ImageIcon(image)), gbc);
            if(i == 0|| i == 5){
                if(x == 3){
                    y++;
                    i++;
                    x = 1;
                }
                else {
                    x++;
                }
            }
            else if(i == 1 || i == 4){
                if(i == 1){
                    if(x == 4){
                        y++;
                        i++;
                        x = 0;
                    }
                    else{
                        x++;
                    }
                }
                else if(x == 4){
                    y++;
                    i++;
                    x = 2;
                }
                else{
                    x++;
                }
            }
            else if(i == 2 || i == 3){
                if(i == 2){
                    if(x == 5){
                        y++;
                        i++;
                        x = 0;
                    }
                    else{
                        x++;
                    }
                }
                else if(x == 5){
                    y++;
                    i++;
                    x = 1;
                }
                else{
                    x++;
                }
            }
        }



        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setResizable(false);
        add(new Panel());
        setVisible(true);
    }

    public void movePawn(){}

    public void tradeable(){}

    public void removeCard(){}

    public void sandBag(){}

    public void helicopter(){}

    public void specialAbility(){}

    public void winGraphics(){}

    public void loseGraphics(){}

    @Override
    public void mouseClicked(MouseEvent e) {
        Component a = findComponentAt(e.getPoint());
        int griX = GridBagLayoutgrid.getConstraints(a).gridx;
        int griY = GridBagLayoutgrid.getConstraints(a).gridy;
        System.out.println("(" + griX + ", " + griY + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
