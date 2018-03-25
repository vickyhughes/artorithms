// inspired by this great tutorial:
// https://www.youtube.com/watch?v=znOBmOrtz_M

float a = 100;
float b = 2;
float c = 100;
float d = 2;
float t = PI/2;
float j = 3;
float k = 3;

float r = 300;

float a_vel = 0.1;
// float a_acc = 0.0001;


void setup() {
	size(640,640);
	background(#9199be);
}

void draw() {
	stroke(#212624);

	translate(width/2, height/2); // move to center of the window!

	float x = r*pow(cos(t),2)-width/4;
	float y = t-height/2;
	
	ellipse(x, y, 1, 1);
	

	t += a_vel;
	// a_vel += a_acc;
	// a_vel = constrain(a_vel, 0, 0.1);

	}