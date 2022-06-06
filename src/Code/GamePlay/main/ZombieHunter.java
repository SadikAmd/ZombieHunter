package Code.GamePlay.main;

import Code.GamePlay.display.Display;
import Code.GamePlay.input.KeyInput;
import Code.GamePlay.input.MouseInput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class ZombieHunter {
    private Canvas canvas;
    private Display display;
    private boolean isRunning;
    private int maxFps , actualFps ;


    public ZombieHunter(Display display){
        this.display = display;
    }

    public void init(){
        canvas = display.getCanvas();
        maxFps = 30;
    }

    int x = 0;
    public void render(){

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        if(bufferStrategy == null){
            canvas.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0,0, display.getWidth(), display.getHeight());
        graphics.setColor(Color.RED);
        graphics.fillRect(x,60,60,60);
        graphics.drawString("Mouse pos : "+MouseInput.point, MouseInput.point.x,MouseInput.point.y);


        bufferStrategy.show();
        graphics.dispose();

    }

    public void tick(){
        KeyInput.update();

        x++;

        if(KeyInput.esc){
            System.exit(0);
        }
        
    }

    public void start(){
        isRunning=true;
        init();
        int ticks=0;
        long lastTime = System.currentTimeMillis();
        long timePerTick = 1000/maxFps;
        long now;
        long timer =lastTime;
        while (isRunning) {

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
