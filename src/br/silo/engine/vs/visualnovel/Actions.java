package br.silo.engine.vs.visualnovel;

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
        
    /**
     * 
     * @param cmd Ação que será guardada para ser executada em ordem.
     */
    public void storeAction(ActionCommand cmd) {
        cmd.setScene(scene);
        listaAcoes.add(cmd);
    }
    
    /**
     * Adiciona uma lista de comando após o indice atual
     * @param listaCmd 
     */
    public void storeActionsNoAtual(ArrayList<ActionCommand> listaCmd){
        for(int i=0; i<listaCmd.size(); i++){
            ActionCommand ac = listaCmd.get(i);
            ac.setScene(scene);            
        }
        listaAcoes.addAll(currentIndex + 1, listaCmd);
    }
    
    private boolean firstStepAction = true;
    private ActionCommand ac;
    
    /**
     * Executa uma ação e identifica se ela já terminou para executar a próxima
     */
    public void updateAction() {
        
        if (listaAcoes.size() > 0 && currentIndex < listaAcoes.size()) {
            if(firstStepAction){
                ac = listaAcoes.get(currentIndex);
                ac.execute();
                firstStepAction = false;
            }
            ac.update();
            if (ac.isEnded()) {
                currentIndex++;
                firstStepAction = true;
                ac.end();
            }
        }
    }

}
