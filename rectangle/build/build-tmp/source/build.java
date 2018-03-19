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

public void setup() {
  
  background(23, 3, 18);

  textAlign(CENTER, CENTER);
} 

public void draw() {
  background(23, 3, 18);

  // Set the left and top margin
  int margin = 10;
  translate(margin*4, margin*4);

  int gap = 46;
  int counter = 65;
  
  for (int y = 0; y < height-gap; y += gap) {
    for (int x = 0; x < width-gap; x += gap) {

      char letter = PApplet.parseChar(counter);
      
      if (
      	letter == 'A' ||
      	letter == 'R' ||
        letter == 'T' ||
        letter == 'O' ||
        letter == 'I' ||
        letter == 'H' ||
        letter == 'M' ||
        letter == 'S') {
        fill(151, 216, 178);
} 
      else {
        fill(83, 18, 83);
      }

      // Draw the letter to the screen
      text(letter, x, y);

      // Increment the counter
      counter++;
    }
  }
}
  public void settings() {  size(275, 640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
