/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.graphics.RendererManager;
import java.util.HashMap;

/**
 *
 * @author Siloé
 */
public class Game extends Thread {

    private HashMap<String, Scene> scenes;
    private String firstScene;
    private boolean pause = false;
    private RendererManager render;

    public Game() {
        render = RendererManager.getInstance();
        scenes = new HashMap<>();
    }

    @Override
    public void run() {
        //super.run();
        this.startGame();
    }

    private void gameLooping() {
        long delay = 33;
        long inicio = System.currentTimeMillis();

        //Para verificar qual o FPS que está rodando o jogo
        long delayFPS = 1000;
        long inicioFPS = System.currentTimeMillis();
        int contadorFPS = 0;

        while (true) {
            if ((System.currentTimeMillis() - inicio) > delay && pause == false) {
                inicio = System.currentTimeMillis();

                updateAll();

                render.drawScene();

//              contadorFPS++;
            }

//            //    Mostrador do FPS
//            if ((System.currentTimeMillis() - inicioFPS) > delayFPS) {
//                System.out.println("FPS = " + contadorFPS);
//                inicioFPS = System.currentTimeMillis();
//                contadorFPS = 0;
//                inicioFPS = System.currentTimeMillis();
//            }
        }
    }

    public void startGame() {
        gameLooping();
    }

    public void pauseGame() {

    }

    private void updateAll() {

    }

    private void menuScene() {

    }

    public Scene getScene(String nome) {
        return scenes.get(nome);
    }

    public void addScenes(Scene scene) {
        //se o map estiver vazio a cena será colocada como a primeira cena
        if (scenes.size() == 0) {
            scenes.put(scene.getNome(), scene);
            setFirstScene(scene.getNome());
        } else {
            scenes.put(scene.getNome(), scene);
        }
    }

    public String getFirstScene() {
        return firstScene;
    }

    public void setFirstScene(String firstScene) {
        this.firstScene = firstScene;
        RendererManager.setCurrentScene(scenes.get(firstScene));
    }

}
