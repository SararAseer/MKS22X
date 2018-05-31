public class MyHeap<T extends Comparable<T>>{

    private T[] data;
    private int size;
    private boolean type;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[])new Comparable[10];
	type=true;
    }
    
    @SuppressWarnings("unchecked")
    public MyHeap(boolean x){
	data = (T[])new Comparable[10];
	type=x;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	T [] x= (T[])new Comparable[size*2];
	for(int i=0; i < data.length; i++){
	    x[i]=data[i];
	}
	data=x;
    }

    public void add(T x){
	if(size==data.length){
	    resize();
	}
	data[size]=x;
	pu(x, size);
	size++;
    }

   

    public T remove(){
	if(size!= 0){
	    T x=data[0];
	    data[0]=data[size-1];
	    rH(data[size-1],0);
	    data[size-1]=null;
	    size--;
	    return x;
	}
	return null;	
    }
	
    public void rH(T s, int x){
	pd(data[size-1],0);
    }

    public T peek(){
	if(size==0){
	    return null;
	}
	return data[0];
    }

    public int size(){
	return size;
    }

    private void swap(T x[], int y, int z){
	T s =x[y];
	x[y]=x[z];
	x[z]=s;
    }

    public void pu(T y,int x){
	int mom = (x-1)/2;
	if(ct(y,data[mom])>0){
	    swap(data,x,mom);
	    pu(y,mom);
	}
    }

    public void pd( T x, int tr){
	int mom = 2 * tr;

	if(mom+1 < size && mom+2 < size){
	
	 if(ct(data[mom + 1],x) > 0 && ct(data[mom + 1], data[mom+2]) > 0){
	    swap(data, tr, mom + 1);
	    pd(x, mom+1);
	}
	 if(ct(data[mom + 2], x) > 0 && ct(data[mom + 2], data[mom+1]) > 0){
	    swap(data, tr, mom + 2);
	    pd(x, mom + 2);
	 }
	}

    }

    public String toString(){
	String x="[";	    
	for(int i=0; i <size-1; i++){
	    x+=data[i]+",";
	}
	return  x+data[size-1]+"]";
    }

    public int ct(T y, T z){
	int x = y.compareTo(z);
	if (!type) x*=-1;
	return x;
    }

     public  void heapSort(){
	heapify();
	for(int i = size-1; i>-1; i--){
	    swap(data, 0, i);
	    pd(data[0], i);
	}
	if(size >= 2 && ct(data[0], data[1])>0){
	    swap(data, 0, 1);
	}
    }
    
    public  void heapify(){
	for (int i=size-1; i>-1; i--){
	    pd(data[i], size-1);	
	}
    }

}
