package br.silo.engine.vs.graphics;

import java.awt.Graphics;

/**
 *
 * @author Siloé
 */
public interface IRenderer {
    
    /**
     *Usado para desenhar na tela e abstrair qualquer coisa imprimivél
     * 
     * @param g
     * @param x
     * @param y
     */
    public void draw(Graphics g, int x, int y);
    
}
