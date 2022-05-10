/** Avatar: a function that draws a face/character/animal/object,

 *at a particular x,y location.


 */
void avatar(int x, int y){
  //your code here
  fill (255,255,255);
  circle(x+50,y+40,200);

  fill (127, 255, 127); 
  ellipse(x, y, 50, 50);
  fill (0, 40, 40); 
  ellipse(x, y, 30, 50);
  
  fill (127, 255, 127); 
  ellipse(x+90, y, 50, 50);
  
  fill (0, 40, 40); 
  ellipse(x+90, y, 30, 50);
  
  fill (255, 127, 127); 
  ellipse(x+50, y+90, 90, 10);
  
  fill (255, 0, 255);
  triangle(x+50, y+40, x+50, y+60, x+70, y+50);
  
//replace the rectangle with something better


}



//to test your code, here is a setup/draw

//The code should draw 3 avatars, one of them moves.
int xp,yp;
void setup(){
  size(800,600);
  xp = 0;
  yp = 0;
}
void draw(){
  background(255);
  avatar(xp,yp);
  xp++;
  yp++;
  avatar(100,100);
  avatar(600,300);
}