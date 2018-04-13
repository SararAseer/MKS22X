import java.util.Iterator;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node start,end;
    private int size;
    
    public Iterator<T> iterator(){
	return null;
    }

    //This method will help you write other
    //methods, it is private to protect your list
    private Node getNode(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	if (index == size-1){
	    return end;
	}
	
	Node s1 = start;

	while (index > 0){
	    s1 = s1.getNext();
	    index-=1;
	}

	return s1;
	
    }


    public MyLinkedListImproved(){
	start=null;
	end=null;
	size=0;
	
    }
    
    public String toString(){
	Node x=start;
	String finals="[";
	for (int i=0; i < size; i++){
	    finals+=x.getValue()+",";

	}
	x=x.getNext();
	finals +="]";
	return finals;
    }
    
    public void clear(){
	start=end=null;
	size=0;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	return getNode(index).getValue();
    }//exceptions!
    
    public T set(int index, T value){
	getNode(index).setValue(value);
	return value;
    }
    //exceptions!

    public int indexOf(T value){
	int count=0;
	Node x=start;
	while(!x.getValue().equals(value) && !x.equals(end)){
	    x=x.getNext();
	    count++;
	}
	
	if(x.getValue().equals(value)){
	    return  count;
	}
	
	return -1;
	
	
    }

    public boolean add(T newData){	
	add(size, newData);
	return true;
    }
    
    public void add(int index, T value){
	Node x= new Node(value);
	if (size!=0){
	    if(index==0){
		Node y= start;
		x.setPrev(x);
		x.setNext(y);
		y.setPrev(x);
		start=x;
	    }
	    else if(index==size){
		Node y=end;
		x.setPrev(y);
		y.setNext(x);
		end=x;

	    }
	    else{
		Node y=getNode(index);
		y.getPrev().setNext(x);
		x.setPrev(y.getPrev());
		x.setNext(y);
		y.setPrev(x);
	    }
	    
	    
	}
	else{
	    start=x;
	    end=x;
	}
	size++;
    }
    //exceptions!

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(T value){
	int count=0;
	Node x=getNode(count);
	while(!x.getValue().equals(value) && !x.equals(end)){
	    x=x.getNext();
	    count++;
	}
	if (x.getValue().equals(value)){
	    remove(count);
	    return true;
	}
	return false;
    }
    
    public T remove(int index){
	Node x= getNode(index);
	if (index==0){
	    start=x.getNext();
	    x.getNext().setPrev(x.getNext());
	}
	else if (index==size-1){
	    end=x.getPrev();
	    x.getPrev().getPrev().setNext(x.getPrev());
	}
	else{
	    x.getNext().setPrev(x.getPrev());
	    x.getPrev().setNext(x.getNext());

	}
	size-=1;
	return x.getValue();
	
    }
    
    public int max(){
	int s1 = -1;
	try{
	    s1=0;
	    T s2 = start.getValue();
	    int c = 0;
	    for(T x: this){
		if (x.compareTo(s2) > 0){
		    s1 = c;
		    s2 = x;
		}
		c++;
	    }
	}
	catch(NullPointerException n){
	    return -1;
	}
	

	return s1;
    }

    public int min(){
	int s2 = 0;
	try{
	    T s1 = start.getValue();
	    int c=0;
	    for(T x: this){
		if (x.compareTo(s1) < 0){
		    s2 = c;
		    s1 = x;
		}
		c++;
	    }
	}
	catch(NullPointerException n){
	    return -1;
	}
	
	return s2;
    }
    //exceptions! // returns the value of what you removed.

  
    private class Node{
	private Node next, prev;
	private T data;

	public Node(T x){
	    data = x;
	    next = null;
	    prev = null;
	}

	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public T getValue(){
	    return data;
	}

	public void setNext(Node x){
	    next = x;
	}
	public void setPrev(Node x){
	    prev = x;
	}
	public void setValue(T x){
	    data = x;
	}
    
	public String toString(){
	    return "" + getValue();
	}
    }

}
