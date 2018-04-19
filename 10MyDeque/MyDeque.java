public class MyDeque<E>{
    private E[] data;
    private  int  front;
    private  int  back;
    private int size;
    
    public static void main(String[] args){
	MyDeque<Integer> x= new MyDeque<>(2);
	x.addFirst(10);
	System.out.println(x.getFirst());
	x.addFirst(412);
	System.out.println(x.getFirst());
	x.addFirst(33);
	System.out.println(x.getFirst());
	x.addLast(23);
	x.addLast(23);
	x.addLast(23);
	x.addLast(23);
	x.addLast(23);
		

    }
    
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data =(E[])new Object[10];
	front=0;
	back=0;
	size=0;
    }
    @SuppressWarnings("unchecked")

     public MyDeque(int x){
	data =(E[])new Object[x];
	front=0;
	back=0;
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
	    if(front+data.length>back){
		data[front+data.length]=x;
	    }	   
	}
	else{
	    data[front]=x;
	}
	front--;
	back++;
	size++;
    }
    
    public void addLast(E x){
	if(x==null){
	    throw new NullPointerException() ;
	}
	if(size==data.length){
	    resize();
	    data[back]=x;
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
	if (front-1<0){
	    return data[front-1+data.length];
	}
	return data[front-1];
    }
    

    public E removeLast(){
	back--;
	size--;
	return data[back+1];
    }

    public E getFirst(){
	int x=front+1;
	if(x<0){
	    return data[data.length+x];
	}
	return data[x];
    }

    public E getLast(){
	int x=back-1;
	return data[x];

    }
    
    @SuppressWarnings("unchecked")
    private void resize(){	
	E [] x =(E[])new Object[data.length*2];
	for(int i =0; i < data.length; i++){
	    data[i]=x[i];
	}
	data=x;
    }

}
