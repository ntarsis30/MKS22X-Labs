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
int x,y;
int MODE;
void setup(){
   size(800,800);
   MODE = 3;
   x = width/2;
   y = height/2;
}
void draw(){
   background(255);
   x = change(x);
   y = change(y);
   avatar(x,y);
}
int change(int value){
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
         wrap back around to the other end of the screen.
  */

  switch(MODE){
   case 1:
     return (int) random(0,800);
   case 2:
     return value + (int) random (0,3)-1;
   case 3:
     value++;
     if (value>=800){
       value=0;
     }
     return value;
   default:
     return width/2;
  }
  }