package PingPong;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ball {
    private static final int DIAMETER = 15;
    int x = 0;
    int y = 0;
    int xa = 4;
    int ya = 4;

    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        if (x + xa < 0) {
            xa = game.speed;
            game.opponentScore++;
            game.speed++;
        }
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
            game.playerScore++;
            game.speed++;
        }
        if (y + ya < 0) {
            ya = game.speed;
        }
        if (y + ya > game.getHeight() - DIAMETER) {
            ya = -game.speed;
        }

        if (collisionLeft()) {
            xa = game.speed;
            x = game.paddleLeft.getX() + DIAMETER;
        }
        if (collisionRight()) {
            xa = -game.speed;
            x = game.opponent.getX() - DIAMETER;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collisionLeft() {
        return game.paddleLeft.getBounds().intersects(getBounds());
    }

      private boolean collisionRight() {
        return game.opponent.getBounds().intersects(getBounds());
    }


    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x,y,DIAMETER,DIAMETER);
    }
    private Rectangle getBounds() {
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }

}
