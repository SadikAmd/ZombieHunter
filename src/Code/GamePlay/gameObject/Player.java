package Code.GamePlay.gameObject;

import Code.GamePlay.Graphics.Resources;
import Code.GamePlay.main.ZombieHunter;
import Code.GamePlay.input.KeyInput;
import Code.GamePlay.input.MouseInput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


/**
 *
 * @author josephchuchu
 */
public class Player implements MouseMotionListener{

    int x, y , width,height;
    int speed;
    BufferedImage img ;
    private double scale=1.5;
    private AffineTransform transform= new AffineTransform();
    private double  rotAngle=0;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        width=45;
        height=45;
        speed=2;
        img= Resources.player;

        ZombieHunter.canvas.addMouseMotionListener(this);
    }
    double finetuner=0;
    public void tick(){

        if(KeyInput.w)
            y-=speed;
        if(KeyInput.s)
            y+=speed;
        if(KeyInput.a)
            x-=speed;
        if(KeyInput.d)
            x+=speed;


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