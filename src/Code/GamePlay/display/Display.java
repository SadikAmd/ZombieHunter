package Code.GamePlay.display;
import javax.swing.*;
import java.awt.*;


public class Display {
    private int width ,height;
    private JFrame window;
    private Canvas canvas;
    private String title;

    public Display(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title=title;

        init();
    }

    public void init(){

        window = new JFrame();
        canvas = new Canvas();
        canvas .setSize(width, height);
        canvas.setBackground(Color.BLACK);
        canvas.requestFocusInWindow();

        window.setTitle(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);


        window.add(canvas);

        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }


    public void showDisplay(){
        window.setVisible(true);
    }

    public void hideDisplay(){
        window.setVisible(false);
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public JFrame getWindow() {
        return window;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        window.setTitle(this.title+" "+title);
    }


}




