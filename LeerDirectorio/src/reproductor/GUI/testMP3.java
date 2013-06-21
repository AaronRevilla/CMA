/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor.GUI;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

/**
 *
 * @author AARON
 */
public class testMP3 {
    public static void main(String[] args){
        File archivo = new File("C:\\Users\\AARON\\Desktop\\musica\\Boom Boom (Official Remix) (ElCorilloRD.Com) [Magnate & Valentino Ft J Alvarez & Nova & Jory -  ].mp3");
        if(archivo != null){
            try {
                System.out.println(archivo.getAbsolutePath());
                MP3File mp3 = new MP3File(archivo);
                System.out.println("Audio bitRate = " + mp3.getAudioHeader().getBitRate());
                System.out.println("Longitud del Archivo" + mp3.getMP3AudioHeader().getTrackLength());
                Tag tag = mp3.getTag();
                System.out.println("Aritsta: " + tag.getFirst(FieldKey.ARTIST));
                System.out.println("Album: " + tag.getFirst(FieldKey.ALBUM));
                System.out.println("Titulo: " + tag.getFirst(FieldKey.TITLE));
                System.out.println("Comentarios: " + tag.getFirst(FieldKey.COMMENT));
                System.out.println("Año: " + tag.getFirst(FieldKey.YEAR));
                System.out.println("Cancion: " + tag.getFirst(FieldKey.TRACK));
                System.out.println("Numero de disco: " + tag.getFirst(FieldKey.DISC_NO));
                System.out.println("Compositor: " + tag.getFirst(FieldKey.COMPOSER));
                System.out.println("Artist sort: " + tag.getFirst(FieldKey.ARTIST_SORT));
                
            } catch (IOException ex) {
                Logger.getLogger(testMP3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TagException ex) {
                Logger.getLogger(testMP3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ReadOnlyFileException ex) {
                Logger.getLogger(testMP3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidAudioFrameException ex) {
                Logger.getLogger(testMP3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("Error en el archivo");
        }
    }
}
