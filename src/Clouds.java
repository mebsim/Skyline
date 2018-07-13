
/**
 * Cloud - A Class where a cloud is drawn, has a random velcoity, width and height
 * 
 * @author (Mohamed) 
 * @version (Jan. 2017)
 */

import java.awt.*;
import java.util.Random;

public class Clouds
{
    private int x, y, height, width, v; // x-coord, y-coord, velocity, height, width values
    Random rand;
    Color cloudColor = new Color(254,254,254, 130);
    
    // Initializes the values that are needed for the road.
    public Clouds(int i) {
    	rand = new Random();
        x = i;
        y = 10;
        v = rand.nextInt(100) + 50;
        if(i > 899){
        	v = -v;
        }
    }
    
    // Moves and decides the velocity of the car. It also decides the color and type of car.
    private void move() {
    	x += v;
    	if(x > 999 && v > 0) {
    		y = rand.nextInt(50);
    		width = rand.nextInt(450) + 150;
    		height = rand.nextInt(20) + 50;
    		v = 0 - (rand.nextInt(20) + 20);
    	}
    	if(x < -600 && v < 0) {
    		x = 1000;
    		v = 1;
    	}
    }
    
    // Draws each car, also asks it to move
    public void draw(Graphics page) {
    	page.setColor(cloudColor);
    	page.fillRect(x, y, width, height);
        move();
    }
    
    public void setX(int upperX)
    {
        x = upperX;
    }
    
    public void setY(int upperY)
    {
        y = upperY;
    }
    
    public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
}
