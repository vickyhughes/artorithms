// based on this tutorial: https://youtu.be/uWzPe_S-RVE

float r1 = 200; // length of first wire
float r2 = 200; // length of second wire
float m1 = 40; // mass of first blob
float m2 = 40; // mass of second blob
float a1 = PI/2; // angle of first pendulum
float a2 = PI/2; // angle of first pendulum
float a1_v = 0; // velocity
float a2_v = 0;
float g = 1; // gravity

float prev_x2 = -1;
float prev_y2 = -1;

float center_x, center_y;

PGraphics canvas;

void setup() {
	size(900, 900);
	center_x = width/2;
	center_y = 300;
	canvas = createGraphics(width, height);
	canvas.beginDraw();
	canvas.background(0);
	canvas.endDraw();
}

void draw() {

	float num1 = -g * (2*m1 + m2) * sin(a1);
	float num2 = -m2 * g * sin(a1 - 2*a2);
	float num3 = -2 * sin(a1 - a2) * m2;
	float num4 = a2_v * a2_v * r2 + a1_v * a1_v * r1 * cos(a1 - a2);
	float denom1 = r1 * (2*m1 + m2 - m2 * cos(2*a1 - 2*a2));

	float a1_a = (num1 + num2 + num3*num4)/denom1;

	float num5 = 2 * sin(a1 - a2);
	float num6 = (a1_v * a1_v * r1 * (m1 + m2));
	float num7 = g * (m1 + m2) * cos(a1);
	float num8 = a2_v * a2_v * r2 * m2 * cos(a1 - a2);
	float denom2 = r2 * (2*m1 + m2 - m2 * cos(2*a1 - 2*a2));

	float a2_a = (num5 * (num6 + num7 + num8))/denom2;

	//background(255);
	image(canvas, 0, 0);
	stroke(#000000, 0);

	translate(center_x, center_y); // move where we're drawing to here

	float x1 = r1 * sin(a1); // x of first blob
	float y1 = r1 * cos(a1); // y of first blob

	float x2 = x1 + r2 * sin(a2); // x of second blob (offset from x1)
	float y2 = y1 + r2 * cos(a2); // y of second blob (offset from y1)

	fill(#000000, 0);
	line(0, 0, x1, y1);
	ellipse(x1, y1, m1, m1); // size relative to mass
	fill(#000000, 0);
	line(x1, y1, x2, y2);
	ellipse(x2, y2, m2, m2); // size relative to mass

	a1_v += a1_a;
	a2_v += a2_a;

	a1 += a1_v;
	a2 += a2_v;

	canvas.beginDraw();
	canvas.translate(center_x, center_y);
	canvas.strokeWeight(2);
	canvas.stroke(#DC493A, 40);
	if (frameCount > 1) { // don't draw the first time
		canvas.line(prev_x2, prev_y2, x2, y2);		
	}
	canvas.endDraw();

	prev_x2 = x2;
	prev_y2 = y2;
}