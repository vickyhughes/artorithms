import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

float circleX;
float circleY;
int colour_index;

int c0 = 0xffFFBA49;
int c1 = 0xff20A39E;
int c2 = 0xffEF5B5B;
int c3 = 0xff23001E;
 
int[] colours  = {  
  c0, c1, c2, c3
};

public void setup() {
	
	background(0xffA4A9AD);
	frameRate(30);
	stroke(0);
}

public void draw() {
	colour_index = PApplet.parseInt(round(random(0,3)));
	fill(colours[colour_index]);
	circleX = random(0, width);
	circleY = random(0, height);
	translate(circleX, circleY);
	ellipse(0, 0, 20, 20);
}
  public void settings() { 	size(640, 640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
