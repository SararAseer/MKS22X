
class Weapon{
  Vector pos;
  Vector vel;
  float heading;
  PImage shot;
  boolean bounds;
  
  public  Weapon(Vector x, float y){
      bounds=true;
      pos= x;
      heading =y;
      vel=new Vector(cos(heading),sin(heading));
  }
  
  void update(){
    if(pos.x>width || pos.y >height|| pos.x<0 || pos.y<0){
      bounds=false;
    }
    if(bounds){
    pos.add(vel);
    }
  }
  
  void Display(){
    if(bounds){
    System.out.println(vel.q);
    pushMatrix();
    shot=loadImage("shot.png");
    translate(pos.x,pos.y);
    rotate(heading-PI/2);
    image(shot,0,0,25,25); 
    popMatrix();
    }
    
  }
  
  
}
