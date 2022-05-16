static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static int MODE = SPRING;
static float GRAVITY = 0.35;
OrbList orbs;
void keyPressed(){
    if (key == '1'){
        SPRING_CONSTANT*=1.25;
    }
    if (key == '2'){
        SPRING_CONSTANT/=1.25;
    }
    if (key == '3'){
        float a = SPRING_DAMPEN*1.25;
        if (a>1){
          SPRING_DAMPEN=1;
        }
        else{
          SPRING_DAMPEN=a;
        }
    }
    if (key == '4'){
        SPRING_DAMPEN/=1.25;
    }
    if (key == '5'){
        SPRING_LENGTH*=1.25;
    }
    if (key == '6'){
        SPRING_LENGTH/=1.25;
    }
    if (key == '7'){
        GRAVITY*=1.25;
    }
    if (key == '8'){
        GRAVITY/=1.25;
    }
}

void setup() {
    size(1000, 800);
    orbs = new OrbList();
}
void mouseClicked() {
    orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
}
void draw() {
    background(255);
    orbs.processAll();
    orbs.display();
    fill(0);
    text(frameRate,20,20);
    text(SPRING_CONSTANT,20,30);
    text(SPRING_DAMPEN,20,40);
    text(SPRING_LENGTH,20,50);
    text(GRAVITY,20,60);
}
