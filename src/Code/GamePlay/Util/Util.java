package Code.GamePlay.Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Util{
    public static BufferedImage loadImage(String path) throws IOException {
        BufferedImage img = null;
        img = ImageIO.read(Util.class.getResource(path));
        return img;
    }
}
