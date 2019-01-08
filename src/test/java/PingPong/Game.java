package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    Ball ball = new Ball(this);
    Paddle paddleLeft = new Paddle(this);
    Opponent opponent = new Opponent(this, ball);

    int speed = 4;
    int playerScore = 0;
    int opponentScore = 0;

    public Game() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                paddleLeft.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                paddleLeft.keyRelased(e);
            }

            @Override
            public void keyTyped(KeyEvent arg0) {
            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.move();
        paddleLeft.move();
        opponent.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        paddleLeft.paint(g2d);
        opponent.paint(g2d);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Verdana", Font.BOLD, 60));
        g2d.drawString(String.valueOf(playerScore + ":" + opponentScore), 320, 60);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Ping Pong Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game game = new Game();

        frame.add(game);
        frame.setPreferredSize(new Dimension(800, 400));
        game.setBackground(Color.BLACK);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        while (true){
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }

}