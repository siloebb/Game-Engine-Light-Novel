
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.graphics.IRenderer;

/**
 *
 * @author Siloé
 */
public class GameObject implements IRenderer{
    
    private int x;
    private int y;

    public void update(){
        
    }
    
    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); 
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
    
}
