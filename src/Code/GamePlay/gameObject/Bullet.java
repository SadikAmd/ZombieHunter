package Code.GamePlay.gameObject;

import Code.GamePlay.Graphics.Resources;
import Code.GamePlay.input.KeyInput;
import Code.GamePlay.input.MouseInput;
import Code.GamePlay.main.ZombieHunter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet implements MouseMotionListener {

    static int  x;
    static int y;
    static int width;
    static int height;
    int speed;
    BufferedImage img ;
    private double scale=1;
    private AffineTransform transform= new AffineTransform();
    private double  rotAngle=0;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        width = 45;
        height = 45;
        speed = 4;
        img = Resources.bullet;

        ZombieHunter.canvas.addMouseMotionListener(this);


    }

    public void tick(){



        x = Player.x+Player.width/2+10;
        y = Player.y+Player.height/2+10;

        transform = AffineTransform.getTranslateInstance(x, y);
        transform.rotate(rotAngle ,width*scale/2,height*scale/2);
    }

    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        Graphics2D g2 =(Graphics2D)g;
        g2.setTransform(transform);
        g.drawImage(img,0,0, (int)(width*scale), (int)(height*scale),null);
        g2.setTransform(new AffineTransform());
    }
    public int centerX(){
        return(int)(x+width/2);
    }
    public int centerY(){
        return(int)(y+height/2);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double height = MouseInput.point.y-centerY();
        double width = MouseInput.point.x-centerX();
        double  gradient = height/width;

        rotAngle = Math.atan(gradient);

        if(width<0)
            rotAngle-=Math.PI;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double height = MouseInput.point.y-centerY();
        double width = MouseInput.point.x-centerX();
        double  gradient = height/width;

        rotAngle = Math.atan(gradient);

        if(width<0)
            rotAngle-=Math.PI;
    }




}
