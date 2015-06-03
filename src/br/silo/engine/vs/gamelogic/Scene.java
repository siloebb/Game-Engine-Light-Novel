package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.visualnovel.ActionCommand;
import br.silo.engine.vs.visualnovel.Actions;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class Scene {
    
    private String nome;
    private final ArrayList<GameObject> listaObj;
    private final Actions actions;

    public Scene(String nome) {
        this.nome = nome;
        this.listaObj = new ArrayList<>();
        actions = new Actions(this);
    }
        
    public ArrayList<GameObject> getListaObj() {
        return listaObj;
    }

    public void addListaObj(GameObject obj) {
        this.listaObj.add(obj);
    }
    
    public void removeListaObj(GameObject obj) {
        this.listaObj.remove(obj);
    }
    
    public void removeListaObj(int index) {
        this.listaObj.remove(index);
    }
    
    public void addCommand(ActionCommand ac){        
        actions.storeAction(ac);
    }
    
    /**
     * Adiciona uma lista de comando imediatamente após o indice atual
     * @param lac 
     */
    public void addCommandNoAtual(ArrayList<ActionCommand> lac){        
        actions.storeActionsNoAtual(lac);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * É atualizado a cada frame
     */
    public void update(){
        for (GameObject go: listaObj) {
            go.update();
        }
        
        actions.updateAction();
    }
    
}
