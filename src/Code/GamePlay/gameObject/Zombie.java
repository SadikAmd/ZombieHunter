package Code.GamePlay.gameObject;

import Code.GamePlay.Graphics.Resources;
import Code.GamePlay.World.World;
import Code.GamePlay.input.KeyInput;
import Code.GamePlay.input.MouseInput;
import Code.GamePlay.math.Vector2f;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public class Zombie {
    int x, y , width,height;
    double speedX, speedY, distance;
    int diffX, diffY;
    BufferedImage img ;
    private double scale=1.7;
    private AffineTransform transform= new AffineTransform();
    private double  rotAngle=1;
    Steering steering;
    Vector2f vector;

    public Zombie(int x, int y){
        this.x = x;
        this.y = y;
        width=45;
        height=45;
        speedX= 2;
        speedY = 2;
        img= Resources.zombie;
        vector = new Vector2f();
        steering = new Steering(vector);
    }

    public void tick(){
        diffX = x-Player.x -Player.width;
        diffY = y-Player.y - Player.height;
        distance = (double) Math.sqrt(Math.pow((x-Player.x)*(x-Player.x), 2) + Math.pow((y-Player.y) *(y - Player.y), 2));

        speedX = 0;
        speedY = 0;
        x+=speedX;
        y+=speedY;



        if(Player.x == Player.x){
            double height = Player.y-centerY();
            double width = Player.x-centerX();
            double  gradient = height/width;

            rotAngle = Math.atan(gradient);

            if(width<0)
                rotAngle-=Math.PI;



        }






        transform = AffineTransform.getTranslateInstance(x, y);
        transform.rotate(rotAngle,width*scale/2,height*scale/2);
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

}
