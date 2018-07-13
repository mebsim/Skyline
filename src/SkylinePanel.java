
/**
 * SkyPanel - Class that draws and contains and initializes the buildings.
 * 
 * @author (Mohamed) 
 * @version (Jan. 2017)
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SkylinePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	java.util.List<Building> buildingList = new ArrayList<Building>();
	java.util.List<Clouds> cloudList = new ArrayList<Clouds>();
	final int nightR = 40;
	final int nightG = 30;
	final int nightB = 80;
	final int dayR = 0;
	final int dayG = 190;
	final int dayB = 250;
	int currentR = nightR;
	int currentG = nightG;
	int currentB = nightB;
	Color sky = new Color(currentR, currentG, currentB);
	Road r;
	int cloudX = 0;
	int timeOfDay = 0; // Goes from 0000/'midnight' to 2359/'minute before midnight'
   
   //Constructor: Creating 4-10 building objects, each with random widths and heights
   
   public SkylinePanel() {
	   Random rand = new Random();
	   int widthRemaining = 800;
	   int height = 50;
	   int numOfBuildings = rand.nextInt(10 - 3) + 3;
	   for(int i = 0; i < numOfBuildings; i ++) {
		   height = (rand.nextInt(22) + 30) * 10;
		   int widthOfBuilding = rand.nextInt(800/numOfBuildings - 70) + 70;
		   buildingList.add(new Building(800 - widthRemaining, height,widthOfBuilding, timeOfDay));
		   widthRemaining -= widthOfBuilding;
	   }
	   height = (rand.nextInt(22) + 30) * 10;
	   buildingList.add(new Building((800 - widthRemaining), height,widthRemaining, timeOfDay));
	   r = new Road();
       setPreferredSize(new Dimension(800, 600));
       setBackground(sky);
       int numOfClouds = rand.nextInt(3) + 2;
       int cloudPosition = -100;
       for(int j = 0; j < numOfClouds; j++) {
    	   cloudList.add(new Clouds(cloudPosition));
    	   cloudPosition -= 100;
       }
   }
   
   // Draws by asking the Building and the Road to draw themselves. Also, both changes the time and gives the time. It also changes the color of the sky
   public void paintComponent(Graphics page) {
       super.paintComponent(page);
       timeOfDay+=5;
       if(Integer.toString(timeOfDay).length() >= 2) {
	       if(Integer.toString(timeOfDay).substring(((Integer.toString(timeOfDay)).length()-2)).equals("60")) {
	    	   timeOfDay += 100;
	    	   timeOfDay -= 60;
	       }
       }
       if(timeOfDay == 2400) {
    	   timeOfDay = 0;
       }
       if(timeOfDay > 300 && timeOfDay < 900) {
    	   // System.out.println("I got to day time shift."); For debugging
    	   currentR += nightR/(36 * 2);
    	   currentG += (dayG - nightG)/(36* 2);
    	   currentB += (dayB - nightB)/(36* 2);
    	   sky = new Color(currentR, currentG, currentB);
       }
       if (timeOfDay > 1700 && timeOfDay < 2300){
    	   // System.out.println("I got to night time shift."); For debugging
    	   currentR -= nightR/(36* 2);
    	   currentG -= (dayG - nightG)/(36* 2);
    	   currentB -= (dayB - nightB)/(36* 2);
    	   sky = new Color(currentR, currentG, currentB);
       }
       page.setColor(sky);
       page.fillRect(0, 0, 800, 600);
       for(Building e: buildingList) {
    	   e.draw(page);
    	   e.setTime(timeOfDay);
       }
       // System.out.println(timeOfDay); For debugging
       r.draw(page);
       r.setTime(timeOfDay);
       for(Clouds e1: cloudList) {
    	   e1.draw(page);
       }
   }
}
