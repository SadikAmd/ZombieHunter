package Code.GamePlay.input;

import java.awt.*;
import java.awt.event.*;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener{

    public static Point point;
    public static boolean mouseLeft,mouseRight;

    public MouseInput(){
        point = new Point(0,0);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        point = e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point = e.getPoint();
        int mouse = e.getButton();
        if(mouse == MouseEvent.BUTTON1){
            mouseLeft = true;
        }
        if(mouse == MouseEvent.BUTTON2){
            mouseRight = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        point = e.getPoint();
        int mouse = e.getButton();
        if(mouse == MouseEvent.BUTTON1){
            mouseLeft = false;
        }
        if(mouse == MouseEvent.BUTTON2){
            mouseRight = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        point = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        point = e.getPoint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
