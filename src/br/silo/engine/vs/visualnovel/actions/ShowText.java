package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.gamelogic.objects.DialogText;
import br.silo.engine.vs.visualnovel.ActionCommand;

/**
 *
 * @author Siloé
 */
public class ShowText implements ActionCommand {

    private DialogText text;
    private Scene scene;

    public ShowText(DialogText text, Scene scene) {
        this.text = text;
        this.scene = scene;
    }

    @Override
    public void execute() {
        scene.addListaObj(text);
    }

    @Override
    public void end() {
        scene.removeListaObj(text);
    }

    @Override
    public boolean isEnded() {
        return false;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
