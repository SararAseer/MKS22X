PImage a;
float angle;
ArrayList<laser> movers;
int x=0;
int y=0;
boolean rotate;
float rot=0;
int w=1;
int z=1;
int xLocation =0;
  int yLocation = 0;
Player one;
 import java.util.Timer;

void setup () {
  size(600, 600);
  ellipseMode(CENTER);  
  a=loadImage("ship.png");
  one = new Player();
   movers = new ArrayList<laser>();;
  one.display();
}
 
 
void draw(){
  background(255);
  pushMatrix();
  one.display();
  popMatrix();
  if(keyPressed){
      pushMatrix();

      one.move();
        popMatrix();

  }
  for (laser m : movers) {
      pushMatrix();

    m.display();
    m.update(movers);
      popMatrix();

  } 
  
  if( keyPressed && key=='q'){
    System.out.println(movers.size());
  }
  
   if( keyPressed && key=='c'){
       pushMatrix();

     one.shoot();
       popMatrix();

    System.out.println(movers.size());
  }
}



class Player{
   void display() {
     translate(xLocation,yLocation);
  ellipse(xLocation,yLocation,10,10);
  rotate(rot);
        image(a,-25,-25,50,50);
  }
  void move(){
    
    
    if(keyPressed && key=='z'){
  rot-=.1;
 
  }
  if(keyPressed && key=='x'){
  rot+=.1;
  
  }
  if(keyPressed && keyCode==LEFT){
    xLocation-=5;
    
  }
  if(keyPressed && keyCode==RIGHT){
  xLocation+=5;
  
  }
  if(keyPressed && keyCode==UP){
  yLocation-=5;
 
  }
    if(keyPressed && keyCode==DOWN){
yLocation+=5;

    }
    if(keyPressed && keyCode=='c'){
  shoot();
    }
  }
  void shoot(){
    laser q= new laser();
    movers.add(q);
  }
  
}

class laser{
  float x, xspeed, xacc;
  float y, yspeed, yacc;
  
  public laser(){
    x=0;
    y=0;
    xspeed=1;
    yspeed=1;
  }
  
  
  

  
  public void update(ArrayList<laser> others) {
    //change the position etc.
    x += xspeed; 
    y += yspeed; 
   
    //check the rest of the world for interactions
    
  }
  
  void display() {
    PImage nerd= loadImage("shot.png");
    image(nerd,x,y,20,20);
  }
  
}
