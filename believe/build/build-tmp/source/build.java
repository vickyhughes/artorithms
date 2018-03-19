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

int[] colorList = {
	color(160, 210, 158),
	color(145, 176, 157),
	color(114, 148, 133)};

int index;

public void setup() {
	
	background(0);
	frameRate(6);

}

public void draw() {
	for (int j = 0; j < 640; j = j + 40) {
		noStroke();
		for (int i = 0; i < 640; i = i + 40) {
		index = PApplet.parseInt(random(colorList.length));
		fill(colorList[index]);
		rect(i, j, 40, 40);
	};
};
}

public void mouseOver() {
	
	float alienx = random(640);
	float alieny = random(640);
	float alien_size = 30;
	beginShape();
  	vertex(alienx, alieny); // first point
  	bezierVertex(
  		alienx - alien_size, alieny - alien_size,
  		alienx + alien_size, alieny - alien_size,
  		alienx, alieny);
  	endShape();
  	fill(0xff000000);
  	ellipse(
  		alienx - alien_size/10,
  		alieny - alien_size/2,
  		alien_size/10,
  		alien_size/5);

  	ellipse(
  		alienx + alien_size/10,
  		alieny - alien_size/2,
  		alien_size/10,
  		alien_size/5);
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
