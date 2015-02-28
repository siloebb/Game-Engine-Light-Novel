
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.fileacess.ImageFactory;
import br.silo.engine.vs.graphics.IRenderer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Siloé
 */
public class Sprite implements IRenderer{
    
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void loadImage(String name) {
        ImageFactory instance = ImageFactory.getInstance();
        image = instance.getImage(name);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(), x, y, null);
    }
    
    private int getHeight(){
        return image.getHeight();
    }
    
    private int getWeight(){
        return image.getWidth();
    }
               
}
