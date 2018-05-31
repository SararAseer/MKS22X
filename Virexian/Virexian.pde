Ship ship;
ArrayList<Enemies> fighters;
ArrayList<Weapon> bullets;
boolean space;
int counter;
void setup(){
    size(600, 600); 
    counter=0;
    space=true;
    ship= new Ship();
    bullets = new ArrayList<Weapon>();
}

void draw(){
  counter++;
  if(counter>=20){
    counter=0;
    space=true;
  }
   background(0);
   ship.Display();
    if(keyPressed && keyCode==UP){
      ship.move('w'); 
    }
    else if(keyPressed &&keyCode==DOWN){
      ship.move('s');
    }
    else if(keyPressed &&keyCode==RIGHT){
      ship.move('a');
    }
    else if(keyPressed &&keyCode==LEFT){
      ship.move('d');
    }
    else if(keyPressed && key==' '&& space && bullets.size()<10 ){
      final float xz=ship.pos.x;
      final float yz=ship.pos.y;
      final float hz=ship.heading;
      space=false;
      bullets.add(new Weapon(new Vector(xz,yz),hz));
      
    }
    else if(keyPressed ){ship.move(key); 
    
   }
   ship.update();
   ship.vel=new Vector(0,0);
   for(int i=0; i < bullets.size(); i++){
     bullets.get(i).Display();
     bullets.get(i).update();
     if(bullets.get(i).bounds==false){
       bullets.remove(i);
     }
   }
   
  
}

  

class Ship{
  Vector pos= new Vector(width/2, height/2);
  Vector vel= new Vector(0,0);
  float heading=0;
  PImage ship;
  
   void Display(){
     pushMatrix();
      ship=loadImage("ship.png");
      translate(pos.x,pos.y);
      rotate(heading);
      image(ship,-25,-25,50,50); 
      popMatrix();
    }
    
    void update(){
        pushMatrix();
        pos.add(vel);
        popMatrix();
    }
    
    void move(char x){
      if(x=='z'){
         heading-=.05; 
      }
      else if(x=='c'){
         heading+=.05 ;
      }
      else if(x=='w'){
          vel=new Vector(0,-1);
      }
      else if(x=='s'){
          vel=new Vector(0,1);  
      }
      else if(x=='a'){
          vel=new Vector(1,0);
      }
      else if(x=='d'){
          vel=new Vector(-1,0);  
      }
      
      
    }
  
  
}

class Vector{
    float x,y;
    float q,w;
    
    public Vector(float a, float b){
       x=a;
       y=b;
    }
   
    
    void add(int a,int b){
      x+=a;
      y+=b;
    }
    
    void add(float a,float b){
      q+=a;
      w+=b;
    }
    
    void add(Vector a){
      x+=a.x();
      y+=a.y();
      q+=a.x();
      w+=a.y();
    }
    
   
   
    float x(){
       return x; 
    }
    
    float y(){
       return y; 
    }
  
}
