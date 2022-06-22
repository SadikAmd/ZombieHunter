package Code.GamePlay.World;

import Code.GamePlay.Graphics.Resources;
import Code.GamePlay.Util.Util;
import Code.GamePlay.gameObject.Bullet;
import Code.GamePlay.gameObject.Player;
import Code.GamePlay.gameObject.Zombie;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class World {

    private Player player;
    private Zombie zombie;
    private Bullet bullet;
    private BufferedImage img;

    int width , height;
    public World() {

    }

    public void init(){
        loadWorld();
        width=height=900;
        player= new Player(600,400);
        zombie = new Zombie((int)(Math.random()*900), 500);
        bullet = new Bullet(400,600);

        img=Resources.ground;
    }
    public void tick(){

        player.tick();
        zombie.tick();
        bullet.tick();
    }
    public void render(Graphics g){
        g.drawImage(img, 0, 0, width,height,null);
        player.render(g);
        zombie.render(g);
        bullet.render(g);
    }
    private void loadWorld(){
        try {
            Resources.ground = Util.loadImage("src/bg.png");
            Resources.player = Util.loadImage("src/Player2.png");
            Resources.zombie = Util.loadImage("src/Zombie.png");
            Resources.bullet = Util.loadImage("src/Bullet.png");
        } catch (IOException ex) {
            System.out.println("failed to load");
        }
    }
}
