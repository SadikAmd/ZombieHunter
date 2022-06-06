package Code.GamePlay.main;

import Code.GamePlay.display.Display;
import Code.GamePlay.input.KeyInput;
import Code.GamePlay.input.MouseInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main{
    public static void main (String [] args){
        int width, height;
        KeyInput keyInput = new KeyInput();
        MouseInput mouseInput = new MouseInput();
        width= 900;
        height = 700;

        Display display = new Display(width, height, "Zombie Hunter Created By Sadik");
        display.getCanvas().addKeyListener(keyInput);
        display.getCanvas().addMouseMotionListener(mouseInput);
        display.getCanvas().addMouseListener(mouseInput);
        display.getCanvas().addMouseWheelListener(mouseInput);
        display.showDisplay();

        ZombieHunter game  = new ZombieHunter(display);
        game.start();

    }

}
