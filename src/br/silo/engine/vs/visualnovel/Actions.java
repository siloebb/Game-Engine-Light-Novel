package br.silo.engine.vs.visualnovel;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class Actions {

    private final ArrayList<ActionCommand> listaAcoes;
    private Scene scene;
    private int currentIndex = 0;

    public Actions(Scene scene) {
        this.scene = scene;
        listaAcoes = new ArrayList<>();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
        
    public void storeAction(ActionCommand cmd) {
        cmd.setScene(scene);
        listaAcoes.add(cmd);
    }
    
    private boolean firstAction = true;
    private ActionCommand ac;
    
    public void updateAction() {
        //Executa uma ação e identifica se ela já terminou para executar a próxima
        if (listaAcoes.size() > 0 && currentIndex < listaAcoes.size()) {
            if(firstAction){
                ac = listaAcoes.get(currentIndex);
                ac.execute();
                firstAction = false;
            }
            ac.update();
            if (ac.isEnded()) {                
                currentIndex++;
                firstAction = true;
                ac.end();
            }
        }
    }

}
