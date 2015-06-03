package br.silo.engine.vs.gamelogic.objects;

import br.silo.engine.vs.gamelogic.Game;
import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Scene;
import br.silo.engine.vs.gamelogic.Sprite;
import br.silo.engine.vs.gamelogic.Text;
import br.silo.engine.vs.input.InputManager;
import br.silo.engine.vs.visualnovel.ActionCommand;
import br.silo.engine.vs.visualnovel.actions.ActionShowQuestion;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Siloé
 */
public class DialogChoose extends GameObject {

    private Sprite dialog;
    private Sprite chooser;
    private Text textDialog;
    private String text;

    private int x = 0;
    private int y = 400;

    private int selectedaAnswer = 0;
    
    private ArrayList<Text> listaText;
    private ArrayList<ArrayList<ActionCommand>> listaComandosParaRespostas;
    
    private ActionShowQuestion asq;

    public DialogChoose(String title) {
        dialog = new Sprite();
        dialog.loadImage("caixa_dialogo.png");

        chooser = new Sprite();
        chooser.loadImage("chooser.png");

        textDialog = new Text();
        
        this.textDialog.setText(title);
                        
    }

    public DialogChoose() {
        dialog = new Sprite();
        dialog.loadImage("caixa_dialogo.png");

        chooser = new Sprite();
        chooser.loadImage("chooser.png");

        textDialog = new Text();

        this.setText("");
    }

    @Override
    public void update() {
        if (InputManager.isKeyDown(KeyEvent.VK_DOWN)) {
            if(selectedaAnswer < listaText.size() - 1){
                selectedaAnswer++;
            }
        }
        if (InputManager.isKeyDown(KeyEvent.VK_UP)) {
            if (selectedaAnswer > 0) {
                selectedaAnswer--;
            }
        }
        if (InputManager.isKeyDown(KeyEvent.VK_ENTER)) {
            //Escolha            
            Game instance = Game.getInstance();
            Scene currentScene = instance.getCurrentScene();
            currentScene.addCommandNoAtual(listaComandosParaRespostas.get(selectedaAnswer));
            asq.setEnded(true);
        }
    }

    public void setActionShowQuestion(ActionShowQuestion asq) {
        this.asq = asq;
    }
        
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        textDialog.setText(text);
    }

    public int getSelectedaAnswer() {
        return selectedaAnswer;
    }

    public void setSelectedaAnswer(int selectedaAnswer) {
        this.selectedaAnswer = selectedaAnswer;
    }

    /*public void setListaAnswer(ArrayList<String> listaAnswer) {
        this.listaAnswer = listaAnswer;
        
        this.listaText = new ArrayList<>();
        
        for (String answer1 : listaAnswer) {
            Text t = new Text();
            t.setText(answer1);
            listaText.add(t);
        }        
    }*/
    
    public void addAnswer(String answer, ArrayList<ActionCommand> listaCmdResposta){        
        if(this.listaText == null){
            this.listaText = new ArrayList<>();
        }
        if(this.listaComandosParaRespostas == null){
            this.listaComandosParaRespostas = new ArrayList<>();
        }
        
        Text t = new Text();
        t.setText(answer);
        this.listaText.add(t);
        
        this.listaComandosParaRespostas.add(listaCmdResposta);
        
    }

    @Override
    public void draw(Graphics g) {
        dialog.draw(g, this.x, this.y);
        chooser.draw(g, x + 20,  y+40 + (40*(selectedaAnswer)));//y+ 20 + (chooser.getImage().getHeight() * selectedaAnswer));
        textDialog.draw(g, this.x + 20, this.y + 40);
        
        for(int i=0; i<listaText.size(); i++){
            listaText.get(i).draw(g, x+20, y+40 + (40*(i+1)));
        }
        
    }

    /**
     * Retorna true se é a ultima parte do texto
     *
     * @return
     */
    private boolean nextText() {
        return true;
    }

}
