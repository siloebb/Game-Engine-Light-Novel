
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.fileacess.ImageFactory;
import java.awt.image.BufferedImage;

/**
 *
 * @author Siloé
 */
public class Sprite {
    
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void loadImage(String name) {
        ImageFactory instance = ImageFactory.getInstance();
        image = instance.getImage(name);
    }
               
}
