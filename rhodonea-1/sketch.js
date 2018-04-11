var radius;
var theta;
var k = 5;
var n = 5;
var garden = new Array(n);

function setup() {
  smooth();
  createCanvas(360, 360);
  background("#00374C");
  theta = 0;
  radius = (width/(2*n))-20;
  for (var i = 1; i < n; i++) {
        garden[i] = new Rhodenea(i*width/n, 2*i/3);
        console.log(garden[i]);
    }
}

function draw() {
  for (var i = 1; i < n; i++) {
    garden[i].display();
    garden[i].update();
  }
}

function Rhodenea(x, k) {
  this.display = function() {
    noStroke();
    fill("#E8EBE1");
    push();
    translate(x, width/2);
    ellipse(radius*cos(k*theta)*cos(theta),
            radius * cos(k * theta) * sin(theta), 1, 1);
    pop();
    noFill();
    stroke(255);
    strokeWeight(40);
    rect(0, 0, width, height);
  }

  this.update = function() {
    if (theta < 16*PI) {
      theta += 0.005;
    }
  }

}
