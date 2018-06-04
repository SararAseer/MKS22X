import java.util.Random;

class Enemies{
  Vector pos= new Vector(width/2, height/2);
  Vector vel= new Vector(0,0);
  float heading=0;
  PImage hip;
  boolean dead;
  int b,c;
  void sd(boolean a){
     dead=a; 
  }
  
   void Display(){
     if(!dead){
      pushMatrix();
      hip=loadImage("eship.png");
      translate(pos.x,pos.y);
      rotate(heading);
      image(hip,25,-25,50,50); 
      popMatrix();
     }
    }
     public Enemies(int a){
     if(a==0){
      pos.x=220;
      pos.y=330;
      
     }
     else if(a==1){
       pos.x=100;
       pos.y=200;
     }
     else if(a==2){
       pos.x=100;
       pos.y=100;
     }
     else if(a==3){
       pos.x=400;
       pos.y=400;
     }
     
     
     if(!dead){
      pushMatrix();
      hip=loadImage("eship.png");
      translate(pos.x,pos.y);
      rotate(heading);
      image(hip,0,0,50,50); 
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
        if(heading+.05<atan2(pos.y-ship.pos.y,pos.x-ship.pos.x)){
        heading+=.05;
        }
        else{
        heading-=.05;
        }
         if(dist(pos.x+.1,pos.y,ship.pos.x,ship.pos.y)<dist(pos.x-.1,pos.y,ship.pos.x,ship.pos.y)){
           vel.x=.25;
         }
         else{
           vel.x=-.25;
         }
         if(dist(pos.x,pos.y+.1,ship.pos.x,ship.pos.y)<dist(pos.x,pos.y-.1,ship.pos.x,ship.pos.y)){
           vel.y=.25;
         }
         else{
           vel.y=-.25;
         }
          
        
    }
  
  
}
