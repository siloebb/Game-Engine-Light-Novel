package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.visualnovel.Actions;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class Scene {
    
    private String nome;
    private ArrayList<GameObject> listaObj;
    private Actions actions;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void update(){
        for (GameObject go: listaObj) {
            go.update();
            actions.update();
        }
    }
    
}
