ArrayList<Orb>orbList;
int MODE;
final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;
final int SPRING_LENGTH = 50;
final float SPRING_DAMPEN = 0.99;
final float SPRING_CONSTANT = 0.015;
String[] check = new String[] {"GRAVITY","ORBIT","SPRING"};
boolean background = false;
boolean gravity = true;
Orb center;
void setup() {
    size(1000, 800);     
    orbList = new ArrayList<Orb>();
    MODE=0;
}
void mouseClicked() {
    //add a new Orb to the orbList, constructed as follows:
    //The x and y positions are the same as the mouse
    //the radius should be between in the range [20.0,70.0)
    //the xSpeed and ySpeed should be in the range [-3.0,3.0)
    /*
    float xs = random(-3.0,3.0);
    float ys = random(-3.0,3.0);
    float rad = random(20.0,70.0);
    */
    
    orbList.add(new Orb(mouseX,mouseY,5,0,20));
}
void keyPressed(){
    if (key == BACKSPACE){
        orbList = new ArrayList<Orb>();
    }
    if (key == 'b'){
        background = !background;
    }
    if (key == ' '){
        MODE=(MODE+1)%3;
    }
    if (key == 'g'){
        gravity = !gravity;
    }
}
void draw() {
    if (!background){
    background(255);
    }
    center = new Orb(500,400,0,0,20);
    center.c = color (0,255,0);
    center.display();
    for (Orb o : orbList) {
    if (MODE==ORBIT){
        center.attract(o);
    }
    else if (MODE == SPRING){
        center.springAttract(o);
    }
    else{
        o.move();
    }
    o.display();
    }
    fill(0);
    text(frameRate,20,20);
    text(orbList.size(),20,40);
    text(check[MODE],20,60);
}
public class Orb{
    float x,y;
    float xSpeed,ySpeed;
    float radius;
    color c;
    

    public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255),random(255),random(255));
    }


    void display(){
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    line(x,y,x+5*xSpeed,y+5*ySpeed);
    }

    void move(){
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    x+=xSpeed;
    y+=ySpeed;
    

    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (x>=width-radius){
        x-=radius/10;
        xSpeed=-(xSpeed)*5/6;
    }
    if (x<=radius){
        x+=radius/10;
        xSpeed=-(xSpeed)*5/6;
    }
    if (y>=height-radius){
        y-=radius/10;
        ySpeed=-(ySpeed)*5/6;
    }
    if (y<=radius){
        y+=radius/10;
        ySpeed=-(ySpeed)*5/6;
    }
        

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
    if (gravity){
        ySpeed+=0.15;
    }

    }
    void attract (Orb Other){
    float dist = dist(x,y,Other.x,Other.y);
    Other.xSpeed+=20*(x-Other.x)/(dist*dist);
    Other.ySpeed+=20*(y-Other.y)/(dist*dist);
    Other.x+=Other.xSpeed;
    Other.y+=Other.ySpeed;
    if (gravity){
        Other.ySpeed+=0.15;
    }
    
    }
    void springAttract(Orb other) {
    float dist = dist(x, y, other.x, other.y) ;
    float force = (dist-SPRING_LENGTH)*SPRING_CONSTANT;
    other.xSpeed+=(x-other.x)*force/dist;
    other.ySpeed+=(y-other.y)*force/dist;
    other.xSpeed*=SPRING_DAMPEN;
    other.ySpeed*=SPRING_DAMPEN;
    other.x+=other.xSpeed;
    other.y+=other.ySpeed;
    if (gravity){
        other.ySpeed+=0.15;
    }
    }
    
}
