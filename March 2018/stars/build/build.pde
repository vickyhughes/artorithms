int num_bg_stars = 250;
int old_x = 0;
int old_y = 0;

color[] sky = {#001848, #001848, #001848, #301860, #001848, #483078};

void setup() {
  size(640, 640);
  background(#131862);
  noStroke();
  smooth();
	
}

void draw() {
	noStroke();
	// textured night sky
  	for (int i = 0; i < width+width/100; i+=width/100) {
  		for (int j = 0; j < height+height/100; j+=height/100) {
  			int bg_colour = round(random(0,5));
  			fill(#ffffff);
		  	fill(sky[bg_colour], 10);
	  		pushMatrix();
	  		translate(i, j);
	  		ellipse(0, 0, width/20, height/20);
	  		popMatrix();
  		}
  	}

  // background stars
 	for (int i = 0; i < num_bg_stars; i+=1) {
  		fill(#ffffff);
	  	float x_bg_star = sqrt(i)*75+400*sin(i);
	  	float y_bg_star = sqrt(i)*55+400*cos(i);

	  	pushMatrix();
	  	translate(x_bg_star, y_bg_star);
	  	int points = round(random(4,8)); // twinkly effect
	  	star(0, 0, 1, 4, points); 
	  	popMatrix();
	}

  	int new_x = mouseX;
  	int new_y = mouseY;
	// allow for it being still
	if (new_x < old_x+50 & new_x > old_x-50) {
		
	} else {
		// draw the star and the trail
  		fill(#ffffff);
		star(mouseX, mouseY, 5, 20, 8); 
		stroke(#ffffff, 70);
		line(old_x, old_y, new_x, new_y);
		line(old_x+30, old_y, new_x, new_y);
		line(old_x-30, old_y, new_x, new_y);
		line(old_x+10, old_y+10, new_x, new_y);
		line(old_x-10, old_y-10, new_x, new_y);
		line(old_x+20, old_y+20, new_x, new_y);
		line(old_x-20, old_y-20, new_x, new_y);
	}
	// need old x to draw the trail
	old_x = mouseX;
	old_y = mouseY;

}

void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}