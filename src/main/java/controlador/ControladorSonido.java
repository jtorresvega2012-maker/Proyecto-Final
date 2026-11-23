/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.sound.sampled.*;
import java.net.URL;

/**
 *
 * @author ALEX JOSHUA TORRES V
 */
public class ControladorSonido {

    private static Clip musica;

    public static void iniciarMusicaFondo(String archivo) {

        try {
            URL sonido = ControladorSonido.class.getResource("/sounds/" + archivo);

            AudioInputStream audio
                    = AudioSystem.getAudioInputStream(sonido);

            musica = AudioSystem.getClip();
            musica.open(audio);

            musica.loop(Clip.LOOP_CONTINUOUSLY);
            musica.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir música: "
                    + e.getMessage());
        }
    }

    public static void detenerMusicaFondo() {

        if (musica != null) {
            musica.stop();
            musica.close();
        }
    }


public static void cambiarVolumen(float volumen) {

    if (musica != null) {

        FloatControl control = (FloatControl)
                musica.getControl(FloatControl.Type.MASTER_GAIN);

        // El volumen debe estar entre 0.0 y 1.0
        if (volumen < 0) volumen = 0;
        if (volumen > 1) volumen = 1;

        float minimo = control.getMinimum();
        float maximo = control.getMaximum();

        float decibelios;

        if (volumen == 0) {
            decibelios = minimo;
        } else {
            decibelios = (float) (20 * Math.log10(volumen));
        }

        control.setValue(Math.max(minimo,
                Math.min(maximo, decibelios)));
    }
}
}
