package Code.GamePlay.Util;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;



public class Util {

    public static BufferedImage loadImage(String path) throws IOException {
        BufferedImage img = ImageIO.read(new File(path));
        return img;
    }
}