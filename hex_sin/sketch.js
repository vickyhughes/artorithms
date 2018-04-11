var w;
var angle;
var n = 150;
var hexy_club = new Array(n);
var colours = ["#000b29", "#d70026", "#f8f5f2",
  "#edb83d"];

function setup() {
  createCanvas(360, 360);
  for (var i = 0; i < n; i++) {
    hexy_club[i] = new hexy_guy()
  }
  angle = 2*PI/6;
}

function draw() {
  background("#c9d1c8");
  noStroke();
  for (var i = 0; i < n; i++) {
    hexy_club[i].update();
    hexy_club[i].display();
  }
}

function hexy_guy() {
  this.pos = createVector(random(50, width-50),
    random(50, height-50));
  this.radius_angle = random(-1, 1);
  this.radius = 10*sin(this.radius_angle+1);

  this.update = function () {
    this.radius_angle += 0.01;
    this.radius = 20*sin(this.radius_angle+1);
  }

  this.colour_int = round(random(0, colours.length-1));
  this.colour = colours[this.colour_int];
  this.display = function () {
    // picture frame
    noFill()
    stroke(255);
    strokeWeight(40);
    rect(0,0,width,height);
    // hexagons
    noStroke();
    beginShape();
    fill(colorAlpha(this.colour, 0.7));
    for (a = PI/6; a < 2*PI; a += angle) {
      vx = this.pos.x + cos(a) * this.radius;
      vy = this.pos.y + sin(a) * this.radius;
      vertex(vx, vy);
   };
   endShape(CLOSE);
  }
}

function colorAlpha(aColor, alpha) {
  var c = color(aColor);
  return color('rgba(' +  [red(c), green(c), blue(c), alpha].join(',') + ')');
}
