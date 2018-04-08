float theta = PI/2;
float phi = PI/4;

float a = 100;
float b = 200;

float theta_vel = 0.01;
float phi_vel = 0.02;

void setup() {
	size(640,640);
	background(#9199be);
}

void draw() {
	stroke(#212624);

	translate(width/2, height/2); // move to center of the window!

	float x = a*cos(theta);
	float y = b*sin(theta);
	ellipse(x, y, 1, 1);
	
	theta += theta_vel;
	phi += phi_vel;

	}