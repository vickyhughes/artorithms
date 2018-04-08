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

// inspired by this great tutorial:
// https://www.youtube.com/watch?v=znOBmOrtz_M

float a = 100;
float b = 2;
float c = 100;
float d = 2;
float t = PI/2;
float j = 3;
float k = 3;

float r = 300;

float a_vel = 0.1f;
// float a_acc = 0.0001;


public void setup() {
	
	background(0xff9199be);
}

public void draw() {
	stroke(0xff212624);

	translate(width/2, height/2); // move to center of the window!

	float x = r*pow(cos(t),2)-width/4;
	float y = t-height/2;
	
	ellipse(x, y, 1, 1);
	

	t += a_vel;
	// a_vel += a_acc;
	// a_vel = constrain(a_vel, 0, 0.1);

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
