float r = 20;
float a = PI/4;

float a_vel = 0.02;

int large_r = 200;
int d = 100;

void setup() {
	size(640,640);
	background(#eeeeee);
}

void draw() {
	stroke(#29a8ab);

	translate(width/2, height/2); // move to center of the window!

	float x = (large_r - r) * cos(a) + d * cos(a*(large_r - r)/r);
	float y = (large_r - r) * sin(a) + d * sin(a*(large_r - r)/r);


	ellipse(x, y, 1, 1);

	a += a_vel;

	}