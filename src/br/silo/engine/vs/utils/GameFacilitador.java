
package br.silo.engine.vs.utils;

import br.silo.engine.vs.audio.Music;
import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.gamelogic.Sprite;
import br.silo.engine.vs.gamelogic.objects.DialogChoose;
import br.silo.engine.vs.gamelogic.objects.DialogText;
import br.silo.engine.vs.visualnovel.ActionCommand;
import br.silo.engine.vs.visualnovel.actions.ActionChangeScene;
import br.silo.engine.vs.visualnovel.actions.ActionPlayMusic;
import br.silo.engine.vs.visualnovel.actions.ActionShowQuestion;
import br.silo.engine.vs.visualnovel.actions.ActionShowText;
import br.silo.engine.vs.visualnovel.actions.ActionStopMusic;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class GameFacilitador {
    
    
    public static GameObject makeObjectSprite(Scene scene, String path, int x, int y, boolean addScene){
        Sprite s = new Sprite();
        s.loadImage(path);
        
        GameObject go = new GameObject();
        go.setAsSprite(s);
        go.setX(x);
        go.setY(y);
        
        if(addScene){
            scene.addListaObj(go);
        }
        return go;
    }
    
    public static ActionShowText makeCmdDialogText(Scene scene, String text, boolean addScene){
        DialogText dt = new DialogText();
        dt.setText(text);
        
        ActionShowText st = new ActionShowText(dt);
        if(addScene){
            scene.addCommand(st);
        }
        
        return st;
    }
    
    public static ActionChangeScene makeCmdChangeScene(Scene scene, Scene sceneForChange, boolean addScene ) {        
        ActionChangeScene sc = new ActionChangeScene(sceneForChange.getNome());
        if(addScene){
            scene.addCommand(sc);
        }        
        return sc;
    }
    
    public static ActionPlayMusic makeCmdPlayMusic(Scene scene, String path, boolean addScene){
        Music m = new Music(path);
        ActionPlayMusic pm = new ActionPlayMusic(m);
        if(addScene){
            scene.addCommand(pm);
        }
        return pm;
    }
    
    public static void makeCmdStopMusic(Scene scene){
        scene.addCommand(new ActionStopMusic());
    }
    
    public static ActionShowQuestion makeCmdQuestion(Scene scene, String question, 
            String answer1, String answer2, String answer3,
            ArrayList<ActionCommand> listaAcaoResposta1, 
            ArrayList<ActionCommand> listaAcaoResposta2, 
            ArrayList<ActionCommand> listaAcaoResposta3, 
            boolean addScene ){
        
        DialogChoose dc2 = new DialogChoose();
        dc2.setText(question);
        
        dc2.addAnswer(answer1, listaAcaoResposta1);
        dc2.addAnswer(answer2, listaAcaoResposta2);
        dc2.addAnswer(answer3, listaAcaoResposta3);
        
        ActionShowQuestion asq1 = new ActionShowQuestion(dc2);
        
        if(addScene){
            scene.addCommand(asq1);
        }
        return asq1;
    }
    
}
