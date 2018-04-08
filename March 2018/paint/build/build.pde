int iter = 0;
color[] c  = {
	#EAF2E3,
	#61E8E1,
	#F25757,
	#F2E863,
	#F2CD60,
	#5BC0EB,
	#FDE74C,
	#9BC53D,
	#404E4D,
	#60D394,
	#AAF683,
	#FFD97D,
	#FF9B85
};

void setup() {
	background(#EAF2EF);
	size(640, 640);

}

void draw() {
	background(#EAF2EF);
	noStroke();
	for (int i = 0; i < 11; i+=1) {
		fill(c[i]);
		arc(i*(width/10) - width/20, 0, width/10, iter*(i+1), 0, PI);
	}
	iter += 1;
}