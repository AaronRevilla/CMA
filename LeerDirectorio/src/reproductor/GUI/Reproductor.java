/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author AARON
 */ 
public class Reproductor implements java.applet.AudioClip {
  private AudioData audiodata;
  private AudioDataStream audiostream;
  private ContinuousAudioDataStream continuousaudiostream;
  static int length;
  
  public Reproductor(URL url) throws java.io.IOException {
    audiodata = new AudioStream(url.openStream()).getData();
    audiostream = null;
    continuousaudiostream = null;
  }
  public Reproductor(String filename) throws java.io.IOException {
    File archivo = new File(filename);
    FileInputStream fis = new FileInputStream(archivo);
    AudioStream audioStream = new AudioStream(fis);
    audiodata = audioStream.getData();
    audiostream = null;
    continuousaudiostream = null;
  }
  public void play() {
    audiostream = new AudioDataStream(audiodata);
    AudioPlayer.player.start(audiostream);
  }
  public void loop() {
    continuousaudiostream = new ContinuousAudioDataStream(audiodata);
    AudioPlayer.player.start(continuousaudiostream);
  }
  public void stop() {
    if (audiostream != null)
      AudioPlayer.player.stop(audiostream);
    if (continuousaudiostream != null)
      AudioPlayer.player.stop(continuousaudiostream);
  }
  public static void main(String args[]) throws Exception {
    //URL url1 = new URL("C:\\Users\\AARON\\Desktop\\musica\\Boom Boom (Official Remix) (ElCorilloRD.Com) [Magnate & Valentino Ft J Alvarez & Nova & Jory -  ].mp3");
    Reproductor rep = new Reproductor("C:\\Users\\AARON\\Desktop\\musica\\Boom Boom (Official Remix) (ElCorilloRD.Com) [Magnate & Valentino Ft J Alvarez & Nova & Jory -  ].mp3");
    rep.play();
    
    try { // Delay for loop
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
    }
  }
}
