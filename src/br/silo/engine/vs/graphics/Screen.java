/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.silo.engine.vs.graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Siloé
 */
public class Screen extends JComponent{
    
    private JFrame parent;

    public Screen() {
        this.setSize(800, 600);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        
        createParent();
    }
    
    private void createParent(){
        parent = new JFrame("JOGO");
        parent.setSize(800, 600);
        parent.setBackground(Color.BLACK);
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        parent.add(this);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
    }
    
    
    
}