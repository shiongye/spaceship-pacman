//LIM SHIONG YE 0345270
//ITS66704

package ap.practest2;

import java.awt.Color;
import java.awt.Graphics;

public class Item {
    private int x; 
    private int dx = 0;
    private int y;
    private int dy = 0;
    private int speed;
    
    public Item (int sx, int sy, int sp) {
        x = sx; //starting x
        y = sy; //starting y
        speed = sp;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void reverseDirection() {
       dx = -dx;
       dy = -dy;
    }    
   
    public void updatePosition() {
       x = x + dx;
       y = y + dy;
    }

    public void moveLeft() {
        dx = -speed;
        dy = 0;
    }

    public void moveRight() {
        dx = speed;
        dy = 0;
    }

    public void moveUp() {
        dx = 0;
        dy = -speed;
    }

    public void moveDown() {
        dx = 0;
        dy = speed;
    }
    
    
    
}
