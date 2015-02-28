
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.graphics.IRenderer;
import java.awt.Graphics;

/**
 *
 * @author Siloé
 */
public class GameObject {
    
    private int x;
    private int y;
    private IRenderer printable;

    public GameObject() {
        printable = new Sprite();
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
       
    public void draw(Graphics g){
        printable.draw(g, x, y);
    }

    public void setAsSprite(Sprite printable) {
        this.printable = printable;
    }
    
    public void setAsText(Text printable) {
        this.printable = printable;
    }
       
}
