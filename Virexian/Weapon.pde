class Weapon{
  Vector pos;
  Vector vel;
  float heading;
  PImage shot;
  boolean bounds;
  
  
  Vector getv(){
     return pos; 
    
  }
  public  Weapon(Vector x, float y, int u){
    if(u>=0 || u<0){
        shot=loadImage("eshot.png");
    }
      bounds=true;
      pos= new Vector(x.x+12.5, x.y+12.5);
      heading =y;
      vel=new Vector(-cos(heading),-sin(heading));
  }
  
  public  Weapon(Vector x, float y){
      shot=loadImage("shot.png");
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
    translate(pos.x,pos.y);
    rotate(heading);
    image(shot,12.5,-12.5,25,25); 
    popMatrix();
    }
    
  }
  
  
}
