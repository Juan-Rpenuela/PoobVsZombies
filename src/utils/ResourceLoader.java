package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.*;
import java.net.URL;

public class ResourceLoader {
    public static Clip loadAudio(String path) {
        try {
            URL resource = ResourceLoader.class.getClassLoader().getResource(path);
            if (resource == null) {
                throw new IllegalArgumentException("No se encontró el archivo de audio: " + path);
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(resource);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo de audio: " + path);
        }
    }
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ResourceLoader.class.getClassLoader().getResource(path));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo cargar la imagen: " + path);
        }
    }
}
