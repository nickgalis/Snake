package Objects;

import Game.Game;

public class Apple {
    public int x;       //x coordinate
    public int y;       //y coordinate


    public Apple(int startX, int startY) {  
        x = startX;
        y = startY; 
    }

    public void setPosition() {       //changes position of apple
        x = (int) (Math.random() * Game.WIDTH);
        y = (int) (Math.random() * Game.WIDTH);

        
    }
}