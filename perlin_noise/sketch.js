var p;
var vx;
var vy;
var angle;
var xoff = 0;
var yoff = 0;
var r = 30;
var n = 10;
var colours = ["#258039", "#f5be41", "#31a9b8", "#cf3721"];
var perlin_club = new Array(n);

function setup() {
  createCanvas(640, 640);
  frameRate(10);
  background(255);
  p = new Perlin_guy();
}

function draw() {
  Hexagon(width/2, height/2, r);
  angle = 2*PI / 6;
  p.walk();
  p.display();
}

function Perlin_guy() {

    this.pos = createVector(random(width),random(height));
    this.walk = function () {
      this.colour_int = round(random(0, colours.length-1));
      this.colour = colours[this.colour_int];
      r = random(30);
      fill(colorAlpha(this.colour, 0.4));
      xoff += 0.19;
      yoff += 0.23;
      this.pos = createVector(noise(xoff)*width, noise(yoff)*height);

    }

    this.display = function () {
    Hexagon(this.pos.x, this.pos.y, r);
      // picture frame
      noFill()
      stroke(255);
      strokeWeight(40);
      rect(0,0,width,height);
    }

}

function Hexagon(centx, centy, radius) {
  noStroke();
  beginShape();
  for (a = PI/6; a < 2*PI; a += angle) {
    vx = centx + cos(a) * radius;
    vy = centy + sin(a) * radius;
    vertex(vx, vy);
 };
 endShape(CLOSE);
}

function colorAlpha(aColor, alpha) {
  var c = color(aColor);
  return color('rgba(' +  [red(c), green(c), blue(c), alpha].join(',') + ')');
}
