/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.input;

import java.awt.event.KeyEvent;
import java.util.EventObject;

/**
 *
 * @author Siloé
 */
public class InputEvent extends  EventObject {
           
    private KeyEvent event;
    private long lastPressed = 0;
    /**
     * Usar as constantes de KeyEvent
     */
    private int state;

    public InputEvent(KeyEvent k, int state) {
        super(k);
        this.event = k;
        this.state = state;
    }

    public KeyEvent getEvent() {
        return event;
    }
    
    public int getState() {
        return state;
    }

    public long getLastPressed() {
        return lastPressed;
    }

    public void setLastPressed(long lastPressed) {
        this.lastPressed = lastPressed;
    }

    @Override
    public boolean equals(Object obj) {
        InputEvent ie = (InputEvent)obj;
        return (event.getKeyCode() == ie.getEvent().getKeyCode())?true:false;
        //return ((event.getKeyCode() == ie.getEvent().getKeyCode()) && (ie.getState() == state) )?true:false;
    }
    
}
