package br.silo.engine.vs.visualnovel;

/**
 *
 * @author Siloé
 */
public interface ActionCommand {
    public void execute();
    public void end();
    public boolean isEnded();
    public void update();
}
