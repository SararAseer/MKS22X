public class MyDeque<E>{
    private E[] data;
    private  static int  front;
    private  static int  back;
    private int size;
    
    public static void main(String[] args){
	MyDeque<Integer> x= new MyDeque<>(2);
	x.addFirst(10);
	System.out.println(""+front+","+back);
	System.out.println(x);
	x.addFirst(412);
	System.out.println(""+front+","+back);
	System.out.println(x);
	x.addFirst(33);
	System.out.println(""+front+","+back);
	System.out.println(x);
	x.addLast(23);
	x.addLast(399);
	x.addLast(13);
	x.addLast(68);
	x.addLast(71);
	System.out.println(""+front+","+back);
	System.out.println(x);
	x.addFirst(1212);
	System.out.println(""+front+","+back);
	System.out.println(x);
    }

    public String toString(){
	String x="";
	for(int i=0; i < data.length-1; i++){
	    x+=data[i]+",";
	}
	x+=data[data.length-1];
	return x;
	
    }
    
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data =(E[])new Object[10];
	front=0;
	back=1;
	size=0;
    }
    @SuppressWarnings("unchecked")

     public MyDeque(int x){
	data =(E[])new Object[x];
	front=0;
	back=1;
	size=0;
    }

    public int size(){
	return size;
    }

    public void addFirst(E x){
	if(x==null){
	    throw new NullPointerException() ;
	}
	if(size==data.length){
	    resize();	   
	}
	if(front<0){
	    data[data.length+front]=x;  
	}
	else{
	    data[front]=x;
	}
	front--;
	size++;
    }
    
    public void addLast(E x){
	if(x==null){
	    throw new NullPointerException() ;
	}
	if(size==data.length){
	    resize();
	}
	if(back>data.length-1){
	    data[back-data.length-1]=x;
	}
	else{
	    data[back]=x;
	}
	back++;
	size++;
    }

    public E removeFirst(){
	front++;	
	size--;
	if (front<0){	    
	    return data[front+data.length];
	}
	return data[front];
    }
    

    public E removeLast(){
	back--;
	size--;
	if(back>data.length-1){
	    return data[back-data.length-1];
	}
	return data[back];
    }

    public E getFirst(){
	if(front<0){
	    return data[data.length+front];
	}
	return data[front];
    }

    public E getLast(){
	if(back>data.length-1){
	    return data[back-data.length-1];
	}
   	return data[back];

    }
    
    @SuppressWarnings("unchecked")
    private void resize(){	
	E [] x =(E[])new Object[data.length*2];
	for(int i =back-1; i >front; i--){
	    if(i>=0){
		x[i]=data[i];
	    }
	    else{
		x[i+x.length]=data[i+data.length];
	    }
	}
	data=x;
    }

}
