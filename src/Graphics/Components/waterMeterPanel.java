package Graphics.Components;

import Logic.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class waterMeterPanel extends JPanel {

    private GridBagConstraints gbc;
    private GridBagLayout layout;

    public waterMeterPanel(){
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(layout);
        JLabel label = new JLabel(new ImageIcon(GameState.waterMeter.getMeter()));
        gbc.gridx = 0; gbc.gridy =1;
        add(label, gbc);

        gbc.gridx =0; gbc.gridy=0;
        BufferedImage image = rotateImageByDegrees(GameState.treasureDeck.getTopUsed(), 270);
        image = resize(image, 90, 132);
        add(new JLabel(new ImageIcon(image)), gbc);

        gbc.gridx=0; gbc.gridy =2;
        image = rotateImageByDegrees(GameState.floodDeck.getTopUsed(), 270);
        image = resize(image, 120, 120);
        add(new JLabel(new ImageIcon(image)), gbc);
    }

    public void update(){
        removeAll();

        JLabel label = new JLabel(new ImageIcon(GameState.waterMeter.getMeter()));
        gbc.gridx = 0; gbc.gridy =1;
        add(label, gbc);

        gbc.gridx =0; gbc.gridy=0;
        BufferedImage image = rotateImageByDegrees(GameState.treasureDeck.getTopUsed(), 270);
        image = resize(image, 90, 132);
        add(new JLabel(new ImageIcon(image)), gbc);

        gbc.gridx=0; gbc.gridy =2;
        image = rotateImageByDegrees(GameState.floodDeck.getTopUsed(), 270);
        image = resize(image, 120, 120);
        JLabel temp = new JLabel(new ImageIcon(image));
        add(temp, gbc);

        this.repaint();
        this.revalidate();
    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {
        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, this);
        g2d.setColor(Color.RED);
        g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
        g2d.dispose();

        return rotated;
    }


    public BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
