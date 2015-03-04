/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.gamelogic.objects.DialogChoose;
import br.silo.engine.vs.visualnovel.ActionCommand;

/**
 *
 * @author Siloé
 */
public class ActionShowQuestion implements ActionCommand {
    
    private final DialogChoose chooser;
    private Scene scene;
    private boolean ended = false;

    public ActionShowQuestion(DialogChoose chooser) {
        this.chooser = chooser;
    }
        
    @Override
    public void execute() {
        scene.addListaObj(chooser);
    }

    @Override
    public void end() {
        scene.removeListaObj(chooser);
    }

    @Override
    public boolean isEnded() {
        return ended;
    }

    @Override
    public void update() {
//        if(InputManager.isKeyDown(KeyEvent.VK_ENTER)){
//            ended = true;
//        }
//        if(InputManager.isKeyDown(KeyEvent.VK_UP)){
//            chooser.setSelectedaAnswer(selectedaAnswer);
//        }
//        if(InputManager.isKeyDown(KeyEvent.VK_DOWN)){
//            
//        }
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
}
