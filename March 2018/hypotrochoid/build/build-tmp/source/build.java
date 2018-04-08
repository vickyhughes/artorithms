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

float r = 20;
float a = PI/4;

float a_vel = 0.02f;

int large_r = 200;
int d = 100;

public void setup() {
	
	background(0xffeeeeee);
}

public void draw() {
	stroke(0xff29a8ab);

	translate(width/2, height/2); // move to center of the window!

	float x = (large_r - r) * cos(a) + d * cos(a*(large_r - r)/r);
	float y = (large_r - r) * sin(a) + d * sin(a*(large_r - r)/r);


	ellipse(x, y, 1, 1);

	a += a_vel;

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
