
package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.gamelogic.Game;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.visualnovel.ActionCommand;

/**
 *
 * @author Siloé
 */
public class ActionChangeScene implements ActionCommand {
    
    private String newScene;

    public ActionChangeScene(String newScene) {        
        this.newScene = newScene;
    }
    
    @Override
    public void execute() {
        Game game = Game.getInstance();
        game.setCurrentScene(newScene);
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
