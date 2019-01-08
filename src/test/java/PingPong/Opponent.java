package PingPong;

import java.awt.*;

public class Opponent {
    private static final int X = 740;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 60;
    int y = 200;

    private Game game;
    private Ball ball;

    public Opponent(Game game, Ball ball) {
        this.game = game;
        this.ball = ball;
    }

    public void move() {
        y = ball.y;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(X, y, WIDTH, HEIGHT);
    }

    public int getX() {
        return X;
    }

    public Rectangle getBounds() {
        return new Rectangle(X, y ,WIDTH, HEIGHT);
    }
}
