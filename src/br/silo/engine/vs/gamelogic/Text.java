/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.gamelogic;

import br.silo.engine.vs.graphics.IRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author Siloé
 */
public class Text implements IRenderer {

    private String text;
    private FontMetrics fm;
    private Font f;

    public Text() {
        f = new Font("Times New Roman", Font.BOLD, 30);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        //fm = g.getFontMetrics();
        //Graphics2D g2d = (Graphics2D) g;

        /*g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
         RenderingHints.VALUE_ANTIALIAS_ON);*/

        String[] split = text.split("\n");
        for (int i = 0; i < split.length; i++) {
            g.setFont(f);
            g.setColor(Color.WHITE);
            g.drawString(split[i], x, y+(i*30));
        }

    }

}
