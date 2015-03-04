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
    private ConfigGraphics config;

    public Screen() {
        config = ConfigGraphics.getInstance();
        this.setSize(ConfigGraphics.rWidth, ConfigGraphics.rHeight);
        this.setBackground(Color.BLACK);
        this.setIgnoreRepaint(true);
        this.setVisible(true);
        this.setDoubleBuffered(true);
        
        
        createParent();
    }
    
    private void createParent(){
        parent = new JFrame("JOGO"){
            @Override
            public void paint(Graphics g) {                
            }
            
        };
        parent.setSize(ConfigGraphics.rWidth, ConfigGraphics.rHeight);
        parent.setBackground(Color.BLACK);        
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.setIgnoreRepaint(true);        
        //parent.setUndecorated(true);
        //parent.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        parent.setVisible(true);
        parent.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        
    }
    
    
    
}
