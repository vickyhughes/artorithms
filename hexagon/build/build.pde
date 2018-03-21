float centx = 50;
float centy = 50;
int radius = 40;
float angle = TWO_PI / 6;

 void setup() {
  size(640, 640);
  background(#000000);

}

void draw() {
  stroke(#ffffff);
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