package sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[8];

    public Sound (){
        soundURL[0] = getClass().getResource("/sounds/Pixel 3.wav");
        soundURL[1] = getClass().getResource("/sounds/jump.wav");
        soundURL[2] = getClass().getResource("/sounds/fireball.wav");
        soundURL[3] = getClass().getResource("/sounds/powerup.wav");
        soundURL[4] = getClass().getResource("/sounds/hubWorld.wav");
        soundURL[5] = getClass().getResource("/sounds/w2_ost.wav");
        soundURL[6] = getClass().getResource("/sounds/menuMusic.wav");
        soundURL[7] = getClass().getResource("/sounds/birds.wav");
    }

    public void setFile(int i){

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e){

        }
    }

    public void play(){

        clip.start();
    }

    public void loop(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){

        clip.stop();
    }
}
