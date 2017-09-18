
package br.silo.engine.vs.gamelogic.objects;

import br.silo.engine.vs.gamelogic.GameObject;
import br.silo.engine.vs.gamelogic.Sprite;
import br.silo.engine.vs.gamelogic.Text;
import java.awt.Graphics;

/**
 *
 * @author Siloé
 */
public class DialogText extends GameObject {
    
    private final Sprite dialog;
    private final Text textDialog;
    private String text;

    private final int x = 0;
    private final int y = 400;
    
    public DialogText() {
        dialog = new Sprite();
        dialog.loadImage("caixa_dialogo.png");
        
        textDialog = new Text();
    }

    @Override
    public void update() {
        
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        textDialog.setText(text);
    }
    
    @Override
    public void draw(Graphics g) {        
        dialog.draw(g, this.x, this.y);
        textDialog.draw(g, this.x+20, this.y+60);
    }
        
    /**
     * Retorna true se é a ultima parte do texto
     * @return 
     */
    private boolean nextText(){
        return true;
    }
    
}
