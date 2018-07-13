
/**
 * Car - A Class where a car is drawn, has a random velcoity, color and type
 * 
 * @author (Mohamed) 
 * @version (Jan. 2017)
 */

import java.awt.*;
import java.util.Random;

public class Car
{
    private int x, y, v, time, r, g, b; // x-coord, y-coord, velocity, time of day, rgb values
    Random rand;
    Color carColor;
    Cars type = Cars.REGULAR;
    boolean nightMov = true;
    int chanceToStop = 0;
    
    // Initializes the values that are needed for the road.
    public Car(int i,int time) {
    	rand = new Random();
        x = i;
        y = 600 - 40;
        this.time = time;
        v = rand.nextInt(100) + 50;
        if(i > 899){
        	v = -v;
        }
    }
    
    // Moves and decides the velocity of the car. It also decides the color and type of car.
    private void move() {
    	if(nightMov) {
    		x += v;
    	}
    	if(v > 0) {
    		y = 580;
    	} else if(v < 0) {
    		y = 560;
    	}
    	r = rand.nextInt(140) + 1;
    	g = rand.nextInt(170) + 1;
    	b = rand.nextInt(140) + 1;
    	if(x > 899 && v > 0  && nightMov) {
    		if(time < 600 || time > 2000) {
    			chanceToStop = rand.nextInt(4) + 1;
    			if(chanceToStop == 3) {
    				nightMov = false;
    			}
    		}
    		int typeOfCar = rand.nextInt(3) + 1;
    		if(typeOfCar == 1) {
    			type = Cars.REGULAR;
    		} else if(typeOfCar == 2) {
    			type = Cars.TRUCK;
    		} else if(typeOfCar == 3) {
    			type = Cars.BUS;
    			r = 90;
    			g = 100;
    			b = 115;
    		}
    		if(time > 600 && time < 2000) {
        		r += 85;
        		g += 85;
        		b += 85;
    		}
    		v = 0 - (rand.nextInt(100) + 20);
        	carColor = new Color(r,g,b);
    	}
    	if(x < -99 && v < 0 && nightMov) {
    		if(time < 600 || time > 2000) {
    			chanceToStop = rand.nextInt(4) + 1;
    			if(chanceToStop == 3) {
    				nightMov = false;
    			}
    		}
    		int typeOfCar = rand.nextInt(4) + 1;
    		if(typeOfCar == 1) {
    			type = Cars.REGULAR;
    		} else if(typeOfCar == 2) {
    			type = Cars.TRUCK;
    		} else if(typeOfCar == 3) {
    			type = Cars.BUS;
    			r = 90;
    			g = 100;
    			b = 115;
    		}
    		if(time > 600 && time < 2000) {
    			r += 85;
        		g += 85;
        		b += 85;
    		}
    		v = rand.nextInt(100) + 50;
    		carColor = new Color(r,g,b);
    	}
    	if(time > 600 && time < 2000) {
			nightMov = true;
		}
    }
    
    // Draws each car, also asks it to move
    public void draw(Graphics page) {
    	page.setColor(carColor);
    	if(v > 0) { // Going right
    		if(type == Cars.REGULAR) {
    			page.fillRect(x, y + 7, 25, 7);
                page.fillRect(x + 5, y + 2, 10, 5);
                page.setColor(Color.BLACK);
            	page.fillOval(x + 4, y + 12, 4, 4);
            	page.fillOval(x + 18, y + 12, 4, 4);
    		} else if(type == Cars.TRUCK) {
    			page.fillRect(x, y + 7, 30, 7);
                page.fillRect(x + 15, y + 2, 10, 5);
                page.setColor(Color.BLACK);
            	page.fillOval(x + 4, y + 12, 4, 4);
            	page.fillOval(x + 18, y + 12, 4, 4);
    		} else if(type == Cars.BUS) {
    			page.fillRect(x, y + 2, 40, 12);
                page.setColor(Color.BLACK);
            	page.fillOval(x + 4, y + 12, 4, 4);
            	page.fillOval(x + 32, y + 12, 4, 4);
    		} 
    	} else { // Going left
    		if(type == Cars.REGULAR) {
    			page.fillRect(x, y + 7, 25, 7);
                page.fillRect(x + 10, y + 2, 10, 5);
                page.setColor(Color.BLACK);
            	page.fillOval(x + 4, y + 12, 4, 4);
            	page.fillOval(x + 18, y + 12, 4, 4);
    		} else if(type == Cars.TRUCK) {
    			page.fillRect(x, y + 7, 25, 7);
                page.fillRect(x + 10, y + 2, 10, 5);
                page.setColor(Color.BLACK);
            	page.fillOval(x + 4, y + 12, 4, 4);
            	page.fillOval(x + 18, y + 12, 4, 4);
    		} else if(type == Cars.BUS) {
    			page.fillRect(x, y + 2, 40, 12);
    			page.setColor(Color.BLACK);
            	page.fillOval(x + 4, y + 12, 4, 4);
            	page.fillOval(x + 32, y + 12, 4, 4);
    		} 
    	}
        move();
    }
    
    public void setTime(int time) {
    	this.time = time;
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

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public Color getCarColor() {
		return carColor;
	}

	public void setCarColor(Color carColor) {
		this.carColor = carColor;
	}

	public Cars getType() {
		return type;
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setType(Cars type) {
		this.type = type;
	}

	public boolean isNightMov() {
		return nightMov;
	}

	public void setNightMov(boolean nightMov) {
		this.nightMov = nightMov;
	}

	public int getChanceToStop() {
		return chanceToStop;
	}

	public void setChanceToStop(int chanceToStop) {
		this.chanceToStop = chanceToStop;
	}

	public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getTime() {
    	return time;
    }
    
}
