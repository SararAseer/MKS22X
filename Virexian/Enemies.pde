import java.util.Random;

class Enemies{
  Vector pos= new Vector(width/2, height/2);
  Vector vel= new Vector(0,0);
  float heading=0;
  PImage ship;
  boolean dead;
  int b,c;
  void sd(boolean a){
     dead=a; 
  }
  
   void Display(){
     if(!dead){
      pushMatrix();
      ship=loadImage("eship.png");
      translate(pos.x,pos.y);
      rotate(heading);
      image(ship,0,0,50,50); 
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
      ship=loadImage("eship.png");
      translate(pos.x,pos.y);
      rotate(heading);
      image(ship,0,0,50,50); 
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
