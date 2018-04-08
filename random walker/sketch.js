var w;
var n = 500;
var walking_club = new Array(n);
var colours = ["#013434", "#84e8d0", "#f3e46b",
"#f1aa58", "#e87933"];

function setup() {
  createCanvas(360, 360);
  for (var i = 0; i < n; i++) {
    walking_club[i] = new Walker()
  }
}

function draw() {
  background(255, 10);
  noStroke();
  for (var i = 0; i < n; i++) {
    walking_club[i].walk();
    walking_club[i].display();
  }
}

function Walker() {
  this.pos = createVector(random(width),random(height));
  this.walk = function () {
    this.vel = createVector(random(-3,3),
                      random(-3,3));
    this.pos = this.pos.add(this.vel);
  }
  this.colour_int = round(random(0, colours.length-1));
  this.colour = colours[this.colour_int];
  this.display = function () {
    // picture frame
    noFill()
    stroke(255);
    strokeWeight(40);
    rect(0,0,width,height);
    noStroke();
    fill(this.colour);
    ellipse(this.pos.x, this.pos.y, 8, 8);
  }
}
