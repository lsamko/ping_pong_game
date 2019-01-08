package PingPong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    private static final int X = 50;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 60;

    int y = 200;
    int ya = 0;
    int speed = 8;

    private Game game;

    public Paddle(Game game) {
        this.game = game;
    }

    public void move() {
        if (y+ya >0 && y+ya < game.getHeight() -HEIGHT ){
            y= y+ya;
        }
    }

    public void keyRelased(KeyEvent e) {
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.ya = -speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.ya = speed;
        }
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(X, y, WIDTH, HEIGHT);
    }

    public int getX() {
        return X;
    }

    public Rectangle getBounds() {
        return new Rectangle(X, y, WIDTH, HEIGHT);
    }
}
