
package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.audio.Music;
import br.silo.engine.vs.audio.SoundManager;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.visualnovel.ActionCommand;

/**
 *
 * @author Siloé
 */
public class ActionPlayMusic implements ActionCommand {

    private Music music;

    public ActionPlayMusic(Music music) {
        this.music = music;
    }
            
    @Override
    public void execute() {
        SoundManager s = SoundManager.getInstance();
        s.playMusic(music);
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
