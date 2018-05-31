public class  RunningMedians{
    public MyHeap<Double> min;
    public MyHeap<Double> max;
    
    public RunningMedians(){
	min = new MyHeap<>(false);
	max = new MyHeap<>();
    }

    public void add(Double x){
	if(max.peek() == null || x < max.peek()){
	    max.add(x);
	}
	else{
	    min.add(x);
	}
    
	while(max.size()-min.size() > 1){
	    min.add(max.remove());
	}
    
	while(min.size()-max.size() > 1){
	    max.add(min.remove());
	}
    }
    
    public Double getMedian(){
	Double value = null;
	switch(max.size() - min.size()){
	    case 1:
		value = max.peek();
		break;
	    case 0:
		value = (min.peek() + max.peek())/2;
		break;
	    case -1:
		value = min.peek();
		break;
	    }
	return value;
    }

    public int size(){
	return min.size() + max.size();
    }

    public String toString(){
	String x = "";
	x += max.toString() + "\n" + min.toString();
	return x;
    }

}
