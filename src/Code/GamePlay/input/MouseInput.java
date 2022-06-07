package Code.GamePlay.input;

import java.awt.*;
import java.awt.event.*;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


public class MouseInput implements MouseListener , MouseMotionListener,MouseWheelListener{

    public static Point point;

    public static boolean mouseleft , mouseright;
    public MouseInput() {
        point = new Point (0,0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        point=e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point=e.getPoint();
        int mouse = e.getButton();
        if(mouse==MouseEvent.BUTTON1)
            mouseleft=true;
        if(mouse==MouseEvent.BUTTON2)
            mouseright=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        point=e.getPoint();
        int mouse = e.getButton();
        if(mouse==MouseEvent.BUTTON1)
            mouseleft=false;
        if(mouse==MouseEvent.BUTTON2)
            mouseright=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        point=e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        point=e.getPoint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }

}