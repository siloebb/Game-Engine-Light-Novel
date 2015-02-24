
package br.silo.engine.vs.graphics;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Siloé
 */
public class RendererManager {
    
    private static Scene currentScene;
    private static RendererManager instance;
    private static Screen screen;
    
    private RendererManager() {
        screen = new Screen();
    }
    
    public static RendererManager getInstance() {
        if(instance == null){
            instance = new RendererManager();
        }
        return instance;
    }
    
    public static Scene getCurrentScene() {        
        return currentScene;
    }

    public static void setCurrentScene(Scene currentScene) {
        RendererManager.currentScene = currentScene;
    }
    
    public void drawScene(){
        Graphics2D g2d = (Graphics2D) screen.getGraphics();
        
        
        
        for (GameObject o : currentScene.getListaObj()) {
            g2d.drawImage(o.getSprite().getImage(), o.getX(), o.getY(), null);
        }
        
    }    
    
}
