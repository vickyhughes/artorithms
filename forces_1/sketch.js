function setup() {
  createCanvas(640, 640);
  particle = new Particle();
}

function draw() {
  background(51);

  var Gravity = createVector(0.03, 0.1);
  particle.applyForce(Gravity);

  particle.update();
  particle.display();
}
