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

int radius = 20;
float angle = TWO_PI / 6;

 public void setup() {
  
  background(255);
  noCursor();
}

public void draw() {
  stroke(0xffffcc00);
  // vary the width - start just off the screen so we don't have black edges
  for (float centy = -50+6*radius/4; centy < width+100; centy += radius*3) { // offset three times to skip a row
    for (float centx = 0; centx < width+100; centx += sqrt(3)/2 * 2*radius) {
      beginShape();
      if (mouseX > centx - radius && mouseX < centx + radius &&
       mouseY < centy + radius && mouseY > centy - radius) {
        fill( 0xffff9900);
      } else {
        fill( 0xffffff66, 30);
      }
      for (float a = PI/6; a < TWO_PI; a += angle) {
        float vx = centx + cos(a) * radius;
        float vy = centy + sin(a) * radius;
        vertex(vx, vy);
     };
     endShape(CLOSE);
    };
  }

  for (float centy = -50; centy < height+100; centy+= radius*3) {
    for (float centx = sqrt(3)/2 * radius; centx < width+100; centx += sqrt(3)/2 * 2*radius) {
      beginShape();
      if (mouseX > centx - radius && mouseX < centx + radius &&
       mouseY < centy + radius && mouseY > centy - radius) {
        fill( 0xffff9900);
      } else {
        fill( 0xffffff66, 30);
      }
      for (float a = PI/6; a < TWO_PI; a += angle) {
        float vx = centx + cos(a) * radius;
        float vy = centy + sin(a) * radius;
        vertex(vx, vy);
     };
      endShape(CLOSE);
    }
  }    
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
