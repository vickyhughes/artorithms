float circleX;
float circleY;
int colour_index;

color c0 = #fafe92;
color c1 = #ffb066;
color c2 = #ff9191;
color c3 = #e679c8;
 
color[] colours  = {  
  c0, c1, c2, c3
};

void setup() {
	size(640, 640);
	background(#ffffff);
	noStroke();
	frameRate(15);
}

void draw() {
	colour_index = int(round(random(0,3)));
	fill(colours[colour_index], 60);
	circleX = random(0, width+width/2);
	circleY = random(0, height+height/2);
	translate(circleX, circleY);
	for (int i = 0; i < 10; i ++) {
    	ellipse(0, 30, 30, 100);
    	rotate(PI/5);
  }
}