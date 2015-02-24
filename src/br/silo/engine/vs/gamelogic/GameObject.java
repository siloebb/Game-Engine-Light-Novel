
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.fileacess.ImageFactory;
import br.silo.engine.vs.graphics.IRenderer;

/**
 *
 * @author Siloé
 */
public class GameObject implements IRenderer{
    
    private int x;
    private int y;
    private Sprite sprite;

    public GameObject() {
        sprite = new Sprite();
    }
        
    public void update(){
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
    
    public void loadSprite(String name){
        sprite.loadImage(name);        
    }
   
}
