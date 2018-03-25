// inspired by this great tutorial:
// https://www.youtube.com/watch?v=znOBmOrtz_M

float r = 100;
float a = PI/4;

float a_vel = 0.02;
// float a_acc = 0.0001;

int kx = 3;
int ky = 4;

void setup() {
	size(640,640);
	background(#1e1f26);
}

void draw() {
	stroke(#d0e1f9);

	translate(width/2, height/2); // move to center of the window!

	float x = r * cos(kx * a);
	float y = r * sin(ky * a);


	ellipse(x, y, 1, 1);

	a += a_vel;
	// a_vel += a_acc;
	// a_vel = constrain(a_vel, 0, 0.1);

	}