package br.silo.engine.vs.graphics;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.input.InputEvent;
import br.silo.engine.vs.input.InputListener;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RendererManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        screen = new Screen();
        listaInputListenner = new ArrayList<>();

        putKeyListenner();
        screen.requestFocusInWindow();
    }

    public static RendererManager getInstance() {
        if (instance == null) {
            instance = new RendererManager();
        }
        return instance;
    }

    public void addInputListenner(InputListener il) {
        listaInputListenner.add(il);
    }

    public void putKeyListenner() {
        //Capturando entrada e usando um bouncer para controle de entrada
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

    public void drawScene() {
        //Graphics2D g2d = (Graphics2D) screen.getGraphics();
        Graphics graphics = screen.getGraphics();

        for (GameObject o : currentScene.getListaObj()) {
            o.draw(graphics);
        }
        screen.requestFocusInWindow();        
    }
    
    public void repaint(){
        screen.repaint();
    }

}
