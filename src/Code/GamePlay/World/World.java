package Code.GamePlay.World;

import Code.GamePlay.Graphics.Resources;
import Code.GamePlay.Util.Util;
import Code.GamePlay.gameObject.Player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

public class World {

    //player
    private Player player;
    private BufferedImage img;
    //width heigh
    int width , height;
    public World() {

    }

    public void init(){
        loadWorld();
        width=height=1500;
        player= new Player(600,400);
        img=Resources.ground;
    }
    public void tick(){
        player.tick();
    }
    public void render(Graphics g){
        g.drawImage(img, 0, 0, width,height,null);
        player.render(g);
    }
    private void loadWorld(){
        try {
            Resources.ground = Util.loadImage("src/03.png");
            Resources.player = Util.loadImage("src/Player.png");
        } catch (IOException ex) {
            System.out.println("failed to load");
        }
    }
}
