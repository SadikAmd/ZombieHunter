package Code.GamePlay.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyInput implements KeyListener{

    public static boolean [] keys =  new boolean[65556];

    public static boolean w,a,s,d,r,esc;

    public static void update(){
        w=keys[KeyEvent.VK_W];
        a=keys[KeyEvent.VK_A];
        s=keys[KeyEvent.VK_S];
        d=keys[KeyEvent.VK_D];
        r=keys[KeyEvent.VK_R];
        esc=keys[KeyEvent.VK_ESCAPE];
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

}