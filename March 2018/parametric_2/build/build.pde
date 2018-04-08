float theta = PI/2;
float phi = PI/4;

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

	for (int a = 0; a < 200; a+=10) {
		float x = a*cos(theta);
		float y = b*sin(phi);
		ellipse(x, y, 1, 1);
	};

	theta += theta_vel;
	phi += phi_vel;

	}