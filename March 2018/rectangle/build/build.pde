void setup() {
  size(275, 640);
  background(23, 3, 18);

  textAlign(CENTER, CENTER);
} 

void draw() {
  background(23, 3, 18);

  // Set the left and top margin
  int margin = 10;
  translate(margin*4, margin*4);

  int gap = 46;
  int counter = 65;
  
  for (int y = 0; y < height-gap; y += gap) {
    for (int x = 0; x < width-gap; x += gap) {

      char letter = char(counter);
      
      if (
      	letter == 'A' ||
      	letter == 'R' ||
        letter == 'T' ||
        letter == 'O' ||
        letter == 'I' ||
        letter == 'H' ||
        letter == 'M' ||
        letter == 'S') {
        fill(151, 216, 178);
} 
      else {
        fill(83, 18, 83);
      }

      // Draw the letter to the screen
      text(letter, x, y);

      // Increment the counter
      counter++;
    }
  }
}
