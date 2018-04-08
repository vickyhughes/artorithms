

// Store Tile objects
ArrayList paving = new ArrayList();
Tile curTile;

// tiles are quares, only one dim
int tileSize = 0;
int numberTiles = 0;
int numberTilesPerRow = 0;


void setup() {
  size(600, 600);
  smooth();
  numberTilesPerRow = 10;
  tileSize = height / numberTilesPerRow ;
  numberTiles = numberTilesPerRow * numberTilesPerRow;
  
  for(int i = 0; i < numberTilesPerRow; i++){
      for(int j = 0; j < numberTilesPerRow; j++){
        paving.add(new Tile(i,j));
      }
  }

}

void draw() {
  background(color(#229944));
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

  void change() {
    tilt += PI/2; 
  }

  void display() {
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