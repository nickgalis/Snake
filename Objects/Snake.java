package Objects;

import Game.Game;

public class Snake {

    Game main;

    public int direction = 0;
    public int size = 2;


    public int X[] = new int[main.WIDTH * main.HEIGHT];
    public int Y[] = new int[main.WIDTH * main.HEIGHT];
    

    public Snake(int x0, int y0, int x1, int y1) {
        X[0] = x0;
        Y[0] = y0;
        X[1] = x1;
        Y[1] = y1;


    }



    public void move() {
        for (int d = size; d > 0; d--) {
            X[d] = X[d - 1];
            Y[d] = Y[d - 1];
        }
 
        if (direction == 0) X[0]++;
        if (direction == 1) X[0]++;
        if (direction == 2) X[0]--;
        if (direction == 3) Y[0]--;

        for (int d = length - 1; d > 0; d--) {
            if ((X[0] == X[d]) & (X[0] == Y[d])) {
                size = d - 2;
            }
        }

        if (X[0] > main.WIDTH) snakeX[0] = 0;
        if (X[0] < 0) X[0] = main.WIDTH - 1;
        if (Y[0] > main.HEIGHT - 1) snakeY[0] = 0;
        if (Y[0] < 0) Y[0] = main.HEIGHT - 1;
 
        if (size < 2) {
            size = 2;
        } 
 
    }
    

}
