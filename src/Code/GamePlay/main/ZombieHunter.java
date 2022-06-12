package Code.GamePlay.main;

import Code.GamePlay.World.World;
import Code.GamePlay.display.Display;
import Code.GamePlay.input.KeyInput;
import Code.GamePlay.input.MouseInput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class ZombieHunter {
    //timing and FPS stuff
    private int maxFps , actualFps ;

    //width height
    private int  width , height;

    //graphics stuff
    public static Canvas canvas;
    private Display display;

    private boolean isrunning;

    //Worlds
    World world;


    public ZombieHunter(Display display) {
        this.display=display;
    }

    //init manages intilizing stuff
    public void init(){
        canvas=display.getCanvas();
        width=display.getWidth();
        height=display.getHeight();
        world= new World();

        maxFps=60;
        world.init();
    }


    //render manages the drawing and th rendering
    public void render(){
        BufferStrategy bufferStrategy =  canvas.getBufferStrategy();
        if(bufferStrategy == null){
            canvas.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.clearRect(0, 0, width,height);
        world.render(graphics);

        bufferStrategy.show();
        graphics.dispose();
    }

    public void tick(){
        KeyInput.update();
        if(KeyInput.esc)
            System.exit(0);
        world.tick();
    }

    public void start(){
        isrunning=true;
        init();
        int ticks=0;
        long lastTime = System.currentTimeMillis();
        long timePerTick = 1000/maxFps;
        long now;
        long timer =lastTime;
        while (isrunning) {

            now= System.currentTimeMillis();
            if(now-lastTime>=timePerTick){
                tick();
                ticks++;
                lastTime=now;
            }
            render();

            if(now-timer>=1000){
                actualFps=ticks;
                ticks=0;
                timer=now;
            }
            display.setTitle("Fps : "+actualFps);
        }
    }

    public void stop(){

    }
}