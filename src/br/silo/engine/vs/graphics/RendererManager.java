
package br.silo.engine.vs.graphics;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.input.InputEvent;
import br.silo.engine.vs.input.InputListener;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class RendererManager {
    
    private static Scene currentScene;
    private static RendererManager instance;
    private static Screen screen;
    private KeyAdapter ka;
    
    private ArrayList<InputListener> listaInputListenner;
    
    private RendererManager() {
        screen = new Screen();
        listaInputListenner = new ArrayList<>();
        
        putKeyListenner();
        screen.requestFocusInWindow();
    }
    
    public static RendererManager getInstance() {
        if(instance == null){
            instance = new RendererManager();
        }
        return instance;
    }
    
    public void addInputListenner(InputListener il){
        listaInputListenner.add(il);
    }    
    
    public void putKeyListenner(){   
        ka = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent ev) {
                for (InputListener il : listaInputListenner) {
                    InputEvent ie = new InputEvent(ev, KeyEvent.KEY_PRESSED);
                    il.inputed(ie);
                }
            }

            @Override
            public void keyReleased(KeyEvent ev) {
                for (InputListener il : listaInputListenner) {
                    InputEvent ie = new InputEvent(ev, KeyEvent.KEY_RELEASED);
                    il.inputed(ie);
                }
            }
        };
        
        screen.addKeyListener(ka);
    }
    
    public Scene getCurrentScene() {        
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        RendererManager.currentScene = currentScene;
    }
    
    public void drawScene(){
        Graphics2D g2d = (Graphics2D) screen.getGraphics();
        
        
        
        for (GameObject o : currentScene.getListaObj()) {
            g2d.drawImage(o.getSprite().getImage(), o.getX(), o.getY(), null);
        }
        
    }    
    
}
