// inspired by this great tutorial:
// https://www.youtube.com/watch?v=znOBmOrtz_M

float a = 50;
float b = 10;
float t = PI/2;

float h = 320;
//float k = 320;

float a_vel = 0.05;

PGraphics canvas;

void setup() {
	size(640,640);
	background(#0abda0);
}

void draw() {
	stroke(#ebf2ea);

	for (int k = 0; k < height ; k +=5) {
		float x = a * 1/cos(t) + h;
		float y = b * tan(t) + k;
		ellipse(x, y, 1, 1);
	}

	t += a_vel;
	}