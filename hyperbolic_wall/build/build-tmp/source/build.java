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

float a = 50;
float b = 10;
float t = PI/2;

float h = 320;
//float k = 320;

float a_vel = 0.05f;

PGraphics canvas;

public void setup() {
	
	background(0xff0abda0);
}

public void draw() {
	stroke(0xffebf2ea);

	for (int k = 0; k < height ; k +=5) {
		float x = a * 1/cos(t) + h;
		float y = b * tan(t) + k;
		ellipse(x, y, 1, 1);
	}

	t += a_vel;
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
