
/**
 * Road - Draws a road, with cars that have random speeds, colors and types
 * 
 * @author (Mohamed) 
 * @version (Jan. 2017)
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Road
{
    private int x, y, time, r, g, b;
    Random rand;
    Color roadColor;
    Color swColor; // sidewalk color;
    java.util.List<Car> cars = new ArrayList<Car>();
    
    /*
     * Making stop lights
     */
    
    // Initializes the values that are needed for the road along with all the cars.
    public Road() {
    	rand = new Random();
        x = 0;
        y = 600 - 40;
        cars.add(new Car(-100,time));
        cars.add(new Car(-150,time));
        cars.add(new Car(-200,time));
        cars.add(new Car(900,time));
        cars.add(new Car(950,time));
        cars.add(new Car(1000,time));
        r = 0;
        g = 0;
        b = 0;
        roadColor = new Color(r,g,b);
        swColor = new Color(r + 80, g + 80, b + 80);
    }
    
    // Draw the roads and tells the cars to draw themselves. Also gives the cars the time of day.
    public void draw(Graphics page) {
    	if(time > 300 && time < 900) {
       	   r += 1;
       	   g += 1;
       	   b += 1;
       	   roadColor = new Color(r, g, b);
       	   swColor = new Color(r + 80, g + 80, b + 80);
        }
    	if(time > 1700 && time < 2300) {
    		r -= 1;
    		g -= 1;
    		b -= 1;
    	   	roadColor = new Color(r, g, b);
    	   	swColor = new Color(r + 80, g + 80, b + 80);
        }
    	page.setColor(roadColor);
    	page.fillRect(x, y, 800, 50);
    	page.setColor(swColor);
    	page.fillRect(0, 550, 800, 10);
        for(int i = 0; i < 16; i++) {
            page.fillRect((i * 50) + 12, 580, 25, 2);
        }
        for(Car e:cars) {
        	e.draw(page);
        	e.setTime(time);
        }
    }
    
    public void setTime(int time) {
    	this.time = time;
    }
    
    public void setX(int upperX) {
        x = upperX;
    }
    
    public void setY(int upperY) {
        y = upperY;
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
