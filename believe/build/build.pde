color[] colorList = {
	color(160, 210, 158),
	color(145, 176, 157),
	color(114, 148, 133)};

int index;

void setup() {
	size(640, 640);
	background(0);
	frameRate(6);

}

void draw() {
	for (int j = 0; j < 640; j = j + 40) {
		noStroke();
		for (int i = 0; i < 640; i = i + 40) {
		index = int(random(colorList.length));
		fill(colorList[index]);
		rect(i, j, 40, 40);
	};
	float alienx = random(640);
	float alieny = random(640);
	float alien_size = 30;
	
	beginShape();
  	vertex(alienx, alieny); // first point
  	bezierVertex(
  		alienx - alien_size, alieny - alien_size,
  		alienx + alien_size, alieny - alien_size,
  		alienx, alieny);
  	endShape();
  	fill(#000000);
  	ellipse(
  		alienx - alien_size/10,
  		alieny - alien_size/2,
  		alien_size/10,
  		alien_size/5);

  	ellipse(
  		alienx + alien_size/10,
  		alieny - alien_size/2,
  		alien_size/10,
  		alien_size/5);
};
}