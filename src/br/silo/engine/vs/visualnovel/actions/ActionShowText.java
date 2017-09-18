package br.silo.engine.vs.visualnovel.actions;

import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.gamelogic.objects.DialogText;
import br.silo.engine.vs.input.InputManager;
import br.silo.engine.vs.visualnovel.ActionCommand;
import java.awt.event.KeyEvent;

/**
 *
 * @author Siloé
 */
public class ActionShowText implements ActionCommand {

    private DialogText text;
    private Scene scene;
    private boolean end = false;

    public ActionShowText(DialogText text) {
        this.text = text;
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
        return end;
    }
    
    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void update() {
        if(InputManager.isKeyDown(KeyEvent.VK_ENTER)){
            end = true;
        }
    }
}
