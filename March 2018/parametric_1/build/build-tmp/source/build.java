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

float r = 100;
float a = PI/4;

float a_vel = 0.02f;
// float a_acc = 0.0001;

int kx = 3;
int ky = 4;

public void setup() {
	
	background(0xff1e1f26);
}

public void draw() {
	stroke(0xffd0e1f9);

	translate(width/2, height/2); // move to center of the window!

	float x = r * cos(kx * a);
	float y = r * sin(ky * a);


	ellipse(x, y, 1, 1);

	a += a_vel;
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
