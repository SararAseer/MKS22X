public class MyLinkedList{
    private Node start,end;
    private int size;

    //This method will help you write other
    //methods, it is private to protect your list
    private Node getNode(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	if (index == size){
	    return end;
	}
	
	Node s1 = start;

	while (index > 0){
	    s1 = s1.getNext();
	    index-=1;
	}

	return s1;
	
    }


    public MyLinkedList(){
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
    
    public Integer get(int index){
	return getNode(index).getValue();
    }//exceptions!
    
    public Integer set(int index, Integer value){
	getNode(index).setValue(value);
	return value;
    }
    //exceptions!

    public int indexOf(Integer value){
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

    public boolean add(Integer newData){	
	add(size, newData);
	return true;
    }
    
    public void add(int index, Integer value){
	Node x= new Node(value);
	if (size!=0){
	    if(index==0){
		Node y= start;
		x.setPrev(x);
		x.setNext(y);
		y.setPrev(x);
		start=x;
	    }
	    else if(index==size-1){
		Node y=end;
		x.setPrev(y);
		x.setNext(x);
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
	    x.setPrev(x);
	    x.setNext(x);
	    start=end=x;
	}
	size++;
    }
    //exceptions!

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(Integer value){
	Node x=start;
	int count=0;
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
    
    public Integer remove(int index){
	Node x= getNode(index);
	final int value=x.getValue();
	if (index==0){
	    start=x.getNext();
	    x.getNext().setPrev(x.getNext());
	}
	else if (index==size){
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
    //exceptions! // returns the value of what you removed.

  
    private class Node{
	private Node next, prev;
	private Integer data;

	public Node(Integer x){
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
	public Integer getValue(){
	    return data;
	}

	public void setNext(Node x){
	    next = x;
	}
	public void setPrev(Node x){
	    prev = x;
	}
	public void setValue(Integer x){
	    data = x;
	}
    
	public String toString(){
	    return "" + getValue();
	}
    }

}
