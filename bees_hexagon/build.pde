int radius = 40;
float angle = TWO_PI / 6;

color[] colors = {
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #98dbc6,
  #5bc8ac,
  #e6d72a,
  #f18d9e,
  #98dbc6
};

 void setup() {
  size(640, 640);
  background(255);
  frameRate(3);
}

void draw() {
  stroke(255);
  // vary the width - start just off the screen so we don't have black edges
  for (float centy = -50+6*radius/4; centy < width+100; centy += radius*3) { // offset three times to skip a row
    for (float centx = 0; centx < width+100; centx += sqrt(3)/2 * 2*radius) {
      fill(#98dbc6);
      mouseOver(fill(#f18d9e));
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
      fill(#98dbc6);
      mouseOver(fill(#f18d9e));
      for (float a = PI/6; a < TWO_PI; a += angle) {
        float vx = centx + cos(a) * radius;
        float vy = centy + sin(a) * radius;
        vertex(vx, vy);
     };
      endShape(CLOSE);
    }
  }    
}