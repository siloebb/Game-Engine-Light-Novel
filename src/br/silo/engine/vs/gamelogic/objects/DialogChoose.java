package br.silo.engine.vs.gamelogic.objects;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Sprite;
import br.silo.engine.vs.gamelogic.Text;
import br.silo.engine.vs.input.InputManager;
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

    private ArrayList<String> listaAnswer;

    public DialogChoose(String title, ArrayList<String> listaAnswer) {
        dialog = new Sprite();
        dialog.loadImage("caixa_dialogo.png");

        chooser = new Sprite();
        chooser.loadImage("chooser.png");

        textDialog = new Text();

        this.listaAnswer = listaAnswer;
        this.textDialog.setText(title);
    }

    public DialogChoose() {
        dialog = new Sprite();
        dialog.loadImage("caixa_dialogo.png");

        chooser = new Sprite();
        chooser.loadImage("chooser.png");

        textDialog = new Text();

        this.listaAnswer = new ArrayList<>();
        this.setText("");
    }

    @Override
    public void update() {
        if (InputManager.isKeyDown(KeyEvent.VK_DOWN)) {
            if(selectedaAnswer < 3){
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
        }
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

    public void setListaAnswer(ArrayList<String> listaAnswer) {
        this.listaAnswer = listaAnswer;
    }

    @Override
    public void draw(Graphics g) {
        dialog.draw(g, this.x, this.y);
        chooser.draw(g, x + 20, y + 20 + (chooser.getImage().getHeight() * selectedaAnswer));
        textDialog.draw(g, this.x + 20, this.y + 40);
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
