public class MyHeap{
    private String[] data;
    private int size;
    private boolean type;
    
    public MyHeap(){
	data= new String [10];
	type=true;
    }
    
    public MyHeap(boolean x){
	data= new String [10];
	type=x;
    }

    public void resize(){
	String [] x= new String [size*2];
	for(int i=0; i < data.length; i++){
	    x[i]=data[i];
	}
	data=x;
    }

    public void add(String x){
	if(size==data.length){
	    resize();
	}
	data[size]=x;
	aH(x, size);
	size++;
    }

    public void aH( String s, int x){
	int dad=(x-1)/2;
	if(s.compareTo(data[x])>0){
	    pu(dad);
	    aH(s, dad);
	}
    }

    public String remove(){
	if(size!= 0){
	    String x=data[0];
	    data[0]=data[size-1];
	    rH(data[size-1],0);
	    data[size-1]=null;
	    size--;
	    return x;
	}
	return null;	
    }
	
    public void rH(String s, int x){
	int mom=2*x;
	if(mom+1<size && mom+2 < size){
	    if(data[mom+1].compareTo(s)>0){
		pd(x,1);
		rH(s, mom+1);
	    }
	    else if(data[x+2].compareTo(s)>0){
		pd(x,2);
		rH(s, mom +2);
	    }
	}
    }

    public String peek(){
	if(size==0){
	    return null;
	}
	return data[0];
    }

    public int size(){
	return size;
    }

    private void swap(String x[], int y, int z){
	String s =x[y];
	x[y]=x[z];
	x[z]=s;
    }

    public void pu(int x){
	swap(data, x, (x-1)/2);
    }

    public void pd( int x, int tr){
	swap(data, x, 2* x + tr);
    }

    public String toString(){
	String x="[";	    
	for(int i=0; i <size-1; i++){
	    x+=data[i]+",";
	}
	return  x+data[size-1]+"]";
    }

}
