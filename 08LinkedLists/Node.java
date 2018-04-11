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