package br.silo.engine.vs.visualnovel;

import br.silo.engine.vs.gamelogic.Scene;

/**
 *
 * @author Siloé
 */
public interface ActionCommand {
    public void execute();
    public void end();
    public boolean isEnded();
    public void update();
    public void setScene(Scene scene);
    
}
