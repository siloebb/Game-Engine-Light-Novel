package br.silo.engine.vs.visualnovel;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class Actions extends GameObject {
    
    private ArrayList<ActionCommand> listaAcoes;
    private Scene scene;
    private int currentIndex = 0;

    public Actions(Scene scene) {
        this.scene = scene;
        listaAcoes = new ArrayList<>();
    }
    
    public void storeAndExecute(ActionCommand cmd){
        listaAcoes.add(cmd);
    }
    
    public void update(){
        ActionCommand ac = listaAcoes.get(currentIndex);
        ac.update();
        if(ac.isEnded()){
            currentIndex++;
        }
    }
    
}
