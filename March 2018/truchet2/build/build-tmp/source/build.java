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



// Store Tile objects
ArrayList paving = new ArrayList();
Tile curTile;

// tiles are quares, only one dim
int tileSize = 0;
int numberTiles = 0;
int numberTilesPerRow = 0;


public void setup() {
  
  
  numberTilesPerRow = 10;
  tileSize = height / numberTilesPerRow ;
  numberTiles = numberTilesPerRow * numberTilesPerRow;
  
  for(int i = 0; i < numberTilesPerRow; i++){
      for(int j = 0; j < numberTilesPerRow; j++){
        paving.add(new Tile(i,j));
      }
  }

}

public void draw() {
  background(color(0xff229944));
  // background(color(#000000));
  for (int i = paving.size() - 1; i>= 0; i--) {
    curTile = (Tile) paving.get(i); 
    curTile.display();
  }
}

class Tile {
  
  int Xindex;
  int Yindex;
  
  float x, y; // X-coordinate, y-coordinate center of tile
  float tilt; 
  float angle; 

  // Constructor
  Tile(int Xindex, int Yindex) {
    x = Xindex * tileSize + tileSize/2 ;
    y = Yindex * tileSize + tileSize/2; 
    angle = 0;
  }

  public void change() {
    tilt += PI/2; 
  }

  public void display() {
    noStroke();
    fill(color(234));
    pushMatrix();
    translate(x, y);
    
    rotate(tilt);
  
    triangle(-tileSize/2 , -tileSize/2 , -tileSize/2 , tileSize/2 , tileSize/2 , tileSize/2 ); 
    fill(200);
    popMatrix();
  }
}
  public void settings() {  size(600, 600);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
