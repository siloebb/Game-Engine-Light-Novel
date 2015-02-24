/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.gamelogic;

import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class Scene {
    
    private String nome;
    private ArrayList<GameObject> listaObj;

    public Scene(String nome) {
        this.nome = nome;
        this.listaObj = new ArrayList<>();        
    }
        
    public ArrayList<GameObject> getListaObj() {
        return listaObj;
    }

    public void addListaObj(GameObject obj) {
        this.listaObj.add(obj);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
                            
}
