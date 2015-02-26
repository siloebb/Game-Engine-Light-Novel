/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.input;

import java.util.EventListener;

/**
 *
 * @author Siloé
 */
public interface InputListener extends EventListener {    
    public void inputed(InputEvent ie);
}
