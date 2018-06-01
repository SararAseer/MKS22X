import java.util.Random;

class Enemies{
  Vector pos= new Vector(width/2, height/2);
  Vector vel= new Vector(0,0);
  float heading=0;
  PImage ship;
  boolean dead;
  
  void sd(boolean a){
     dead=a; 
  }
  
   void Display(){
     if(!dead){
      pushMatrix();
      ship=loadImage("eship.png");
      translate(pos.x,pos.y);
      rotate(heading);
      image(ship,-25,-25,50,50); 
      popMatrix();
     }
    }
    
    void update(){
        pushMatrix();
        pos.add(vel);
        popMatrix();
    }
    
    void move(){
        Random rand = new Random();
        int a=rand.nextInt(100);
        boolean c=rand.nextBoolean();
        if(c){
         heading+=.05; 
        }
        else{
          heading-=.05;
        }
        if(a>75){
          vel=new Vector(0,-1);
        }
        else if(a>50){
          vel=new Vector(-1,0);
        }
        else if( a>25){
          vel=new Vector(1,0);
        }
        else{
          vel=new Vector(0,1);
        }
    }
  
  
}
