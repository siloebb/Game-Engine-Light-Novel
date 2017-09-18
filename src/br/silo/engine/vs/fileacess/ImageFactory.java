package br.silo.engine.vs.fileacess;

import br.silo.engine.vs.utils.References;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Siloé
 */
public class ImageFactory {

    public static HashMap<String, BufferedImage> images;
    private static ImageFactory instance;
    
    private ImageFactory() {
        images = new HashMap<>();
    }

    public static ImageFactory getInstance() {
        if(instance == null){
            instance = new ImageFactory();
        }
        return instance;
    }
        
    public BufferedImage getImage(String nome) {
        BufferedImage i = images.get(nome);
        
        if (i == null) {
            i = FileUtils.carregarImagem(References.folderSprites + nome);
            images.put(nome, i);
        }
        return i;
    }

}
