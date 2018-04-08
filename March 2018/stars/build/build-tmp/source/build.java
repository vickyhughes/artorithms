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

int num_bg_stars = 250;
int old_x = 0;
int old_y = 0;

int[] sky = {0xff001848, 0xff001848, 0xff001848, 0xff301860, 0xff001848, 0xff483078};

public void setup() {
  
  background(0xff131862);
  noStroke();
  
	
}

public void draw() {
	noStroke();
	// textured night sky
  	for (int i = 0; i < width+width/100; i+=width/100) {
  		for (int j = 0; j < height+height/100; j+=height/100) {
  			int bg_colour = round(random(0,5));
  			fill(0xffffffff);
		  	fill(sky[bg_colour], 10);
	  		pushMatrix();
	  		translate(i, j);
	  		ellipse(0, 0, width/20, height/20);
	  		popMatrix();
  		}
  	}

  // background stars
 	for (int i = 0; i < num_bg_stars; i+=1) {
  		fill(0xffffffff);
	  	float x_bg_star = sqrt(i)*75+400*sin(i);
	  	float y_bg_star = sqrt(i)*55+400*cos(i);

	  	pushMatrix();
	  	translate(x_bg_star, y_bg_star);
	  	int points = round(random(4,8)); // twinkly effect
	  	star(0, 0, 1, 4, points); 
	  	popMatrix();
	}

  	int new_x = mouseX;
  	int new_y = mouseY;
	// allow for it being still
	if (new_x < old_x+50 & new_x > old_x-50) {
		
	} else {
		// draw the star and the trail
  		fill(0xffffffff);
		star(mouseX, mouseY, 5, 20, 8); 
		stroke(0xffffffff, 70);
		line(old_x, old_y, new_x, new_y);
		line(old_x+30, old_y, new_x, new_y);
		line(old_x-30, old_y, new_x, new_y);
		line(old_x+10, old_y+10, new_x, new_y);
		line(old_x-10, old_y-10, new_x, new_y);
		line(old_x+20, old_y+20, new_x, new_y);
		line(old_x-20, old_y-20, new_x, new_y);
	}
	// need old x to draw the trail
	old_x = mouseX;
	old_y = mouseY;

}

public void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0f;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}
  public void settings() {  size(640, 640);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
