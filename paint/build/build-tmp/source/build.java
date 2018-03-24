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

int iter = 0;
int[] c  = {
	0xffEAF2E3,
	0xff61E8E1,
	0xffF25757,
	0xffF2E863,
	0xffF2CD60,
	0xff5BC0EB,
	0xffFDE74C,
	0xff9BC53D,
	0xff404E4D,
	0xff60D394,
	0xffAAF683,
	0xffFFD97D,
	0xffFF9B85
};

public void setup() {
	background(0xffEAF2EF);
	

}

public void draw() {
	background(0xffEAF2EF);
	noStroke();
	for (int i = 0; i < 11; i+=1) {
		fill(c[i]);
		arc(i*(width/10) - width/20, 0, width/10, iter*(i+1), 0, PI);
	}
	iter += 1;
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
