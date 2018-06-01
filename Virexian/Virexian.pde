Ship ship;
Enemies coo;
ArrayList<Enemies> fighters;
ArrayList<Weapon> bullets;
ArrayList<Weapon> ebullets;

boolean space;
int counter;


void setup(){
  
    size(600, 600); 
    fighters = new ArrayList<Enemies>();  
    counter=0;
    space=true;
    ship= new Ship();
    ship.sd(false);
    coo= new Enemies();
    fighters.add(coo);
    bullets = new ArrayList<Weapon>();
    ebullets = new ArrayList<Weapon>();
    coo.sd(false);
}

void draw(){
  int a=0;
  Random rand = new Random();
  if(fighters.size()>0){
   a=rand.nextInt(fighters.size())+1;
  }
  if(fighters.size()==0){
    fighters.add(new Enemies());
  }/*
      final float az=coo.pos.x;
      final float bz=coo.pos.y;
      final float cz=coo.heading;
      space=false;
      ebullets.add(new Weapon(new Vector(az,bz),cz,0));
  */
  for(int i=0; i <a;i++){
      int b=rand.nextInt(fighters.size());
      int c=rand.nextInt(100);
      if(c==99){
      Enemies e=fighters.get(b);
      final float az=e.pos.x;
      final float bz=e.pos.y;
      final float cz=e.heading;
      space=false;
      ebullets.add(new Weapon(new Vector(az,bz),cz,0));
      }
  }
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
    else if(!ship.dead && keyPressed && key==' '&& space && bullets.size()<10 ){
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
     for(int q=0; q < fighters.size(); q++){
     if(abs(bullets.get(i).pos.x-fighters.get(q).pos.x)<25 &&abs(bullets.get(i).pos.y-fighters.get(q).pos.y)<25 && fighters.get(q).dead==false){
       fighters.get(q).sd(true);
       fighters.remove(q);
       bullets.remove(i);
     }
     else if(bullets.get(i).bounds==false){
       bullets.remove(i);
     }
     
     }
   }
   for(int i=0; i < ebullets.size(); i++){
     ebullets.get(i).Display();
     ebullets.get(i).update();
     if(abs(ebullets.get(i).pos.x-ship.pos.x)<25 &&abs(ebullets.get(i).pos.y-ship.pos.y)<25){
       ship.sd(true);
       ebullets.remove(i);
     }
     else if(ebullets.get(i).bounds==false){
       ebullets.remove(i);
     }
   }
   for(int i=0; i < fighters.size(); i++){
     fighters.get(i).move();
     fighters.get(i).update();
     fighters.get(i).Display();
   }
  
}

  

class Ship{
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
      ship=loadImage("ship.png");
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
