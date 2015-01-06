
package br.silo.engine.vs.graphics;

/**
 *
 * @author Siloé
 */
public class ConfigGraphics {
    
    private static ConfigGraphics instance;
    
    private static int rWidth = 800;
    private static int rHeight = 600;
    

    private ConfigGraphics() {
    }

    public static ConfigGraphics getInstance() {
        return instance;
    }
}
