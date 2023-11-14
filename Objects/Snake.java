package Objects;

import Game.Main;

public class Snake {

    Game main;

    public int snakeX[] = new int[main.WIDTH * main.HEIGHT];
    public int snakeY[] = new int[main.WIDTH * main.HEIGHT];
    int length = 2;

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move() {
        ;   //placeholder
    }
    

}
