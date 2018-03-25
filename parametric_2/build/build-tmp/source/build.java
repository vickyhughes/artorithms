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

float theta = PI/2;
float phi = PI/4;

float b = 200;

float theta_vel = 0.01f;
float phi_vel = 0.02f;

public void setup() {
	
	background(0xff9199be);
}

public void draw() {
	stroke(0xff212624);

	translate(width/2, height/2); // move to center of the window!

	for (int a = 0; a < 200; a+=10) {
		float x = a*cos(theta);
		float y = b*sin(phi);
		ellipse(x, y, 1, 1);
	};

	theta += theta_vel;
	phi += phi_vel;

	}
  public void settings() { 	size(640,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
