
/**
 * Building - Draws a building, with randomized windows, amounts of windows on the building and windows sizes.
 * 
 * @author (Mohamed) 
 * @version (Jan. 2017)
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Building
{
    private int x, y, height, width, amountOfWindowsX, amountOfWindowsY, time;
    java.util.List<Window> windows = new ArrayList<Window>();
    Random rand;
    Color usual = Color.BLACK;
    
    // Initializes the values that are needed for the building.
    public Building(int num, int amount, int width, int timeOfDay) {
    	rand = new Random();
        x = num;
        y = 550 - amount;
        height = amount;
        this.width = width;
        time = timeOfDay;
        amountOfWindowsX = rand.nextInt(width/10 - 6) + 6;
        amountOfWindowsY = rand.nextInt(height/10 - 20) + 20;
        for(int i = 0; i < amountOfWindowsX; i++) {
    		for(int j = 0; j < amountOfWindowsY; j++) {
    			windows.add(new Window((i * width/amountOfWindowsX + x), (y + j * height/amountOfWindowsY), (width/amountOfWindowsX), (height/amountOfWindowsY),time));
    		}
    	}
    }
    
    // Draws the Building, an outline of the building, tells the windows to draw themselves. Also gives the windows the time of day.
    public void draw(Graphics page) {
    	/*if(time > 300 && time < 900) {
      	   r += 240/36;
      	   g += 240/36;
      	   b += 240/36;
      	   usual = new Color(r, g, b);
         }
         if (time > 1700 && time < 2300){
      	   r -= 240/36;
      	   g -= 240/36;
      	   b -= 240/36;
      	  usual = new Color(r, g, b);
         }
    	page.setColor(usual);
        page.fillRect(x, y, width, height);
        page.setColor(Color.DARK_GRAY);
        page.drawRect(x, y, width, height);*/
        for(Window e:windows) {
        	e.draw(page);
        	e.setTime(time);
        }
    }
    
    public void setTime(int timeOfDay) {
    	time = timeOfDay;
    }
    
    public void setSize(int amount) {
        height = amount;
    }
    
    public void setX(int upperX) {
        x = upperX;
    }
    
    public void setY(int upperY) {
        y = upperY;
    }
    
    public int  getWidth() {
        return width;
    }
    
    public int  getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getTime() {
    	return time;
    }
}
