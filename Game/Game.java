package Game;
import Objects.Apple;
import Objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 

public class Game extends JPanel implements ActionListener {

  public static final int SCALE = 32;
  public static final int WIDTH = 20;
  public static final int HEIGHT = 20;
  public static final int SPEED = 4;

  Apple apple = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
  Snake snake = new Snake(10, 10, 9, 10);
  Timer timer = new Timer(1000 / SPEED, this);

  public Game() {
    timer.start();
    addKeyListener(new Keyboard());
    setFocusable(true);
}



  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(false);
    f.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 29);
    f.setLocationRelativeTo(null);
    f.add(new Game());
    f.setVisible(true);           
    }




  public Color color(int red, int green, int blue) {
    return new Color(red, green, blue);
  }



  public void paint(Graphics g) {
    g.setColor(color(5, 50, 10));
    g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
    g.setColor(color(255, 216, 0));

    for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
      g.drawLine(xx, 0, xx, HEIGHT * SCALE);
    }

    for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
        g.drawLine(0, yy, WIDTH * SCALE, yy);
    }

    for (int d = 0; d < snake.size; d++) {
      g.setColor(color(0, 0, 255));
      g.fillRect(snake.X[d] * SCALE + 1, snake.Y[d] * SCALE + 1, SCALE - 1, SCALE - 1);
    }

    g.setColor(color(255, 0, 0));
    g.fillRect(apple.x * SCALE + 1, apple.y * SCALE + 1, SCALE - 1, SCALE - 1);
  }


  public void actionPerformed(ActionEvent e) {
    snake.move();

    if ((snake.X[0] == apple.x) & (snake.Y[0] == apple.y)) {
        apple.setPosition();
        snake.size++;
    }

    for (int k = 1; k < snake.size; k++) {
        if ((snake.X[k] == apple.x) & (snake.Y[k] == apple.y)) {
            apple.setPosition();
        }
    }

    repaint();
}



  private class Keyboard extends KeyAdapter {
    public void keyPressed(KeyEvent kEve) {
      int key = kEve.getKeyCode();

      if ((key == KeyEvent.VK_RIGHT) & snake.direction != 2) snake.direction = 0;
      if ((key == KeyEvent.VK_DOWN) & snake.direction != 3) snake.direction = 1;
      if ((key == KeyEvent.VK_LEFT) & snake.direction != 0) snake.direction = 2;
      if ((key == KeyEvent.VK_UP) & snake.direction != 1) snake.direction = 3;
    }
  }
}
