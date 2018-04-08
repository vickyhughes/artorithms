var w;
var n = 1000;
var walking_club = new Array(n);
var colours = ["#98fbe4", "#ffc5a5", "#ff90e4",
  "#fd9595", "#c1ffc2"];

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
    walking_club[i].update();
    walking_club[i].display();
  }
}

function Walker() {
  this.pos = createVector(random(width),random(height));
  this.vel = createVector(0, 0);
  this.acc = createVector(random(-0.01, 0.01),
              random(-0.01, 0.01));

  this.update = function () {
    this.vel.add(this.acc);
    this.pos.add(this.vel);
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
    fill((this.colour));
    ellipse(this.pos.x, this.pos.y, 8, 8);
  }
}
