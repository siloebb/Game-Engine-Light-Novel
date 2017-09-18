
package br.silo.engine.vs.audio;

import br.silo.engine.vs.utils.References;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Siloé
 */
public class SoundManager {
    
    private AudioPlayer ap;
    private AudioStream audioStream;
    private static SoundManager instance;

    public static SoundManager getInstance() {
        if(instance==null){
            instance = new SoundManager();
        }
        return instance;
    }
        
    private SoundManager() {
    }    
        
    public void playMusic(Music music) {
        try {
            // get the sound file as a resource out of my jar file;
            // the sound file must be in the same directory as this class file.
            // the input stream portion of this recipe comes from a javaworld.com article.
            InputStream inputStream = new FileInputStream(References.folderMusic + music.getNameFull());
            audioStream = new AudioStream(inputStream);
            ap = AudioPlayer.player;
            ap.start(audioStream);            
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    public void stopMusic(){
        if(ap != null && audioStream != null){
            ap.stop(audioStream);
        }
    }
    
    public void playAudio(Audio audio){
        try {
            // get the sound file as a resource out of my jar file;
            // the sound file must be in the same directory as this class file.
            // the input stream portion of this recipe comes from a javaworld.com article.
            InputStream inputStream = new FileInputStream(References.folderSound + audio.getNameFull());
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
}
