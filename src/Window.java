
/**
 * Window - Draws a window, with randomized windows, amounts of windows on the building and windows sizes.
 * 
 * @author (Mohamed) 
 * @version (Dec. 2016)
 */

import java.awt.*;
import java.util.Random;

public class Window
{
    private int x, y, height, width, time, r, g, b, chanceToClose;
    private boolean lightOn;
    Random rand;
    Color usual = Color.BLACK;
    
    // Initializes the values that are needed for the window.
    public Window(int x, int y, int width, int height, int timeOfDay) {
    	rand = new Random();
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        time = timeOfDay;
        lightOn = true;
        r = 0;
        b = 0;
        g = 0;
    }
    
    // draws the window and also changes the color depending on the time of day and also decides if it wants to stay light up
    public void draw(Graphics page) {
    	if(time > 300 && time < 900) {
      	   r += 180/(36* 2);
      	   g += 180/(36* 2);
      	   b += 180/(36* 2);
      	   usual = new Color(r, g, b);
        }
    	if(time > 1700 && time < 2000) {
       	   r -= 180/(36* 2);
       	   g -= 180/(36* 2);
       	   b -= 180/(36* 2);
       	   usual = new Color(r, g, b);
         }
    	page.setColor(usual);
        page.fillRect(x, y, width, height);
        page.setColor(Color.DARK_GRAY);
        page.drawRect(x, y, width, height);
        if(time < 300 || time > 2100) {
        	if(time >= 250 && time < 300) {
            	r = 0;
    			b = 0;
    			g = 0;
    			page.setColor(Color.BLACK);
    			page.fillRect(x, y, width, height);
    			page.setColor(Color.GRAY);
    			page.drawRect(x, y, width, height);
    			/*chanceToClose = rand.nextInt(14) + 1;
    			if(chanceToClose == 5) {
    				lightOn = false;
    			} else {
    				lightOn = true;
    			}*/
            } else if(lightOn) {
            	page.setColor(Color.YELLOW);
    			page.fillRect(x, y, width, height);
    			page.setColor(Color.GRAY);
    			page.drawRect(x, y, width, height);
    			if(time < 2400) {
    				chanceToClose = rand.nextInt(24248 - (24000 + (time/10))) + 1;
    			}
    			if(time < 600) {
    				chanceToClose = rand.nextInt(6000 - (6000 - ((300 - time)/10))) + 1;
    			}
    			if(chanceToClose == 1) {
    				lightOn = false;
    			}
            } else {
            	page.setColor(Color.black);
    			page.fillRect(x, y, width, height);
    			page.setColor(Color.GRAY);
    			page.drawRect(x, y, width, height);
    			if(time > 600) {
    				chanceToClose = rand.nextInt(500); // Someone might reenter
    			} else {
    				chanceToClose = 0;
    			}
    			if(chanceToClose == 90) {
    				lightOn = true;
    			}
            }
        } else if(time > 2000 && time <= 2100) {
        	chanceToClose = rand.nextInt(30) + 1;
			if(chanceToClose == 5) {
				lightOn = true;
			}
			if(lightOn == true) {
				page.setColor(Color.YELLOW);
				page.fillRect(x, y, width, height);
				page.setColor(Color.GRAY);
				page.drawRect(x, y, width, height);
			} else {
				page.setColor(usual);
				page.fillRect(x, y, width, height);
				page.setColor(Color.GRAY);
				page.drawRect(x, y, width, height);
			}
        } else {
			page.setColor(usual);
			page.fillRect(x, y, width, height);
			page.setColor(Color.GRAY);
			page.drawRect(x, y, width, height);
			lightOn = false;
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
