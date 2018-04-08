int radius = 20;
float angle = TWO_PI / 6;

 void setup() {
  size(640, 640);
  background(255);
  noCursor();
}

void draw() {
  stroke(#ffcc00);
  // vary the width - start just off the screen so we don't have black edges
  for (float centy = -50+6*radius/4; centy < width+100; centy += radius*3) { // offset three times to skip a row
    for (float centx = 0; centx < width+100; centx += sqrt(3)/2 * 2*radius) {
      beginShape();
      if (mouseX > centx - radius && mouseX < centx + radius &&
       mouseY < centy + radius && mouseY > centy - radius) {
        fill( #ff9900);
      } else {
        fill( #ffff66, 30);
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
        fill( #ff9900);
      } else {
        fill( #ffff66, 30);
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
