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

float centx = 50;
float centy = 50;
int radius = 40;
float angle = TWO_PI / 6;

 public void setup() {
  
  background(0xff000000);

}

public void draw() {
  stroke(0xffffffff);
  beginShape();
    for (float a = PI/6; a < TWO_PI; a += angle) {
      float vx = centx + cos(a) * radius;
      float vy = centy + sin(a) * radius;
      vertex(vx, vy);
   };
  endShape(CLOSE);

  centx += sqrt(3)*radius;
  centy += (3*radius)/2;
}
  public void settings() {  size(640, 640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
