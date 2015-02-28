
package br.silo.engine.vs.graphics;

/**
 *
 * @author Siloé
 */
public class ConfigGraphics {
    
    private static ConfigGraphics instance;
    
    public static final int rWidth = 815;
    public static final int rHeight = 640;
    

    private ConfigGraphics() {
    }

    public static ConfigGraphics getInstance() {
        return instance;
    }
}
