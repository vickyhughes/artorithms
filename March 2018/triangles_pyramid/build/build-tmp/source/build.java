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

float x1, x2, y1, y2, x3, y3;

int c0 = 0xff000000;
int c1 = 0xffB91372;
int c2 = 0xffFDFFFC;
int c3 = 0xff41EAD4;
int c4 = 0xffFF0022;
int c5 = 0xff011627;
 
int[] colors  = {  
  c0, c1, c2, c3, c4, c5
};

public void setup() {
	background(0xffffffff);
	
}

public void draw() {
	noLoop();
	stroke(54,24,54);
	for (int i = (height/100)-1; i > 0; --i) {
		fill(colors[i]);
		int tr_height = i * 100;
		x1 = (width/2) - (tr_height)/2;
		y1 = height;
		x3 = width/2;
		y3 = height - tr_height;
		y2 = height;
		x2 = (width/2) + (tr_height)/2;
		triangle(x1, y1, x2, y2, x3, y3);
	}
	paper();		
}

public void paper() { // from https://www.openprocessing.org/sketch/510598
	strokeWeight(1);
	noStroke();
	for (int i = 0; i<width-1; i+=4) {
  		for (int j = 0; j<height-1; j+=4) {
  			fill(random(205-40, 205+30), 25);
  			rect(i, j, 2, 2);
  		}
  	}
}
  public void settings() { 	size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
