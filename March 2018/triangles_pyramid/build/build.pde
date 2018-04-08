float x1, x2, y1, y2, x3, y3;

color c0 = #000000;
color c1 = #B91372;
color c2 = #FDFFFC;
color c3 = #41EAD4;
color c4 = #FF0022;
color c5 = #011627;
 
color[] colors  = {  
  c0, c1, c2, c3, c4, c5
};

void setup() {
	background(#ffffff);
	size(600, 600);
}

void draw() {
	noLoop();
	stroke(54,24,54);
	for (int i = (height/100)-1; i > 0; --i) {
		fill(colors[i]);
		int tr_height = i * 100;
		x1 = (width/2) - (tr_height)/2;
		y1 = height;
		x3 = width/2;
		y3 = height - tr_height;
		y2 = height;
		x2 = (width/2) + (tr_height)/2;
		triangle(x1, y1, x2, y2, x3, y3);
	}
	paper();		
}

void paper() { // from https://www.openprocessing.org/sketch/510598
	strokeWeight(1);
	noStroke();
	for (int i = 0; i<width-1; i+=4) {
  		for (int j = 0; j<height-1; j+=4) {
  			fill(random(205-40, 205+30), 25);
  			rect(i, j, 2, 2);
  		}
  	}
}