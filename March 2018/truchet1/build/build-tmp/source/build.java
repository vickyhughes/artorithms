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

int x = 50;
int y = 50;
int size = 20;

public void setup() {
	
}

public void draw() {
	noLoop();
	noStroke();
	for (int x = size; x < width - size; x+= size) {
		for (int y = size; y < width - size; y += size) {
			rotated_tile(x, y, size);
		}
	}
	

}

public void rotated_tile(int x, int y, int s){
	int random_num = round(random(3));
	if (random_num == 0) {
		int c = 0xff4abdac;
		triangle_tile(x, y, s, c);
	}
	if (random_num == 1) {
		int c = 0xfffc4a1a;
		pushMatrix();
		rotate(PI/2);
		translate(0, -width);
		triangle_tile(x, y, s, c);
		popMatrix();
	}
	if (random_num == 2) {
		int c = 0xfff78733;
		rotate(PI);
		translate(-height, -width);
		triangle_tile(x, y, s, c);
	} 
	if (random_num == 3) {
		int c = 0xff007849;
		rotate(3*PI/2);
		translate(-height, 0);
		triangle_tile(x, y, s, c);
	}
}

public void triangle_tile(int x, int y, int s, int c){
	fill(0);
	triangle(x, y, x, y + s, x + s, y);
	fill(c);
	triangle(x, y + size, x + size, y, x + size, y + size);
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
