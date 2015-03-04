
package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.audio.SoundManager;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.visualnovel.ActionCommand;

/**
 *
 * @author Siloé
 */
public class ActionStopMusic implements ActionCommand{

    @Override
    public void execute() {
        SoundManager s = SoundManager.getInstance();
        s.stopMusic();
    }

    @Override
    public void end() {
        
    }

    @Override
    public boolean isEnded() {
        return true;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void setScene(Scene scene) {
        
    }
    
}
