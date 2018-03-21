float circleX;
float circleY;
int colour_index;

color c0 = #FFBA49;
color c1 = #20A39E;
color c2 = #EF5B5B;
color c3 = #23001E;
 
color[] colours  = {  
  c0, c1, c2, c3
};

void setup() {
	size(640, 640);
	background(#A4A9AD);
	frameRate(30);
	stroke(0);
}

void draw() {
	colour_index = int(round(random(0,3)));
	fill(colours[colour_index]);
	circleX = random(0, width);
	circleY = random(0, height);
	translate(circleX, circleY);
	ellipse(0, 0, 20, 20);
}