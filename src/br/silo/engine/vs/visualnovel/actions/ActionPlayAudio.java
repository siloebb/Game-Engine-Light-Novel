/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.audio.Audio;
import br.silo.engine.vs.audio.SoundManager;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.visualnovel.ActionCommand;

/**
 *
 * @author Siloé
 */
public class ActionPlayAudio implements ActionCommand{
    
    private Audio audio;

    public ActionPlayAudio(Audio audio) {
        this.audio = audio;
    }
         
    @Override
    public void execute() {
        SoundManager s = SoundManager.getInstance();
        s.playAudio(audio);
    }

    @Override
    public void end() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setScene(Scene scene) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
