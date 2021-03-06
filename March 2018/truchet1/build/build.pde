int x = 50;
int y = 50;
int size = 20;

void setup() {
	size(640, 640);
}

void draw() {
	noLoop();
	noStroke();
	for (int x = size; x < width - size; x+= size) {
		for (int y = size; y < width - size; y += size) {
			rotated_tile(x, y, size);
		}
	}
	

}

void rotated_tile(int x, int y, int s){
	int random_num = round(random(3));
	if (random_num == 0) {
		color c = #4abdac;
		triangle_tile(x, y, s, c);
	}
	if (random_num == 1) {
		color c = #fc4a1a;
		pushMatrix();
		rotate(PI/2);
		translate(0, -width);
		triangle_tile(x, y, s, c);
		popMatrix();
	}
	if (random_num == 2) {
		color c = #f78733;
		rotate(PI);
		translate(-height, -width);
		triangle_tile(x, y, s, c);
	} 
	if (random_num == 3) {
		color c = #007849;
		rotate(3*PI/2);
		translate(-height, 0);
		triangle_tile(x, y, s, c);
	}
}

void triangle_tile(int x, int y, int s, color c){
	fill(0);
	triangle(x, y, x, y + s, x + s, y);
	fill(c);
	triangle(x, y + size, x + size, y, x + size, y + size);
}