/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.input;

import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class InputManager {
    
    private ArrayList<InputEvent> listaInputEvent;
    private static InputManager instance;

    public static InputManager getInstance() {
        if(instance == null){
            instance = new InputManager();
        }
        return instance;
    }

    public InputManager() {
    }

    public ArrayList<InputEvent> getListaInputEvent() {
        return listaInputEvent;
    }

    public void setListaInputEvent(ArrayList<InputEvent> listaInputEvent) {
        this.listaInputEvent = listaInputEvent;
    }
    
    public static boolean isKeyDown(int keyCode){
        for (InputEvent ie : InputManager.getInstance().listaInputEvent) {
            if(ie.getEvent().getKeyCode() == keyCode){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isKeyDown(char key){
        for (InputEvent ie : InputManager.getInstance().listaInputEvent) {
            if(ie.getEvent().getKeyChar() == key){
                return true;
            }
        }
        return false;
    }
        
}
