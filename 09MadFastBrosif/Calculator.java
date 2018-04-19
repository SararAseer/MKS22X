import java.util.LinkedList;
public class Calculator{
    public static double eval(String s){
	LinkedList <Double> a = new LinkedList<>();
	String [] b=s.split(" ");
	for (int i =0 ; i< b.length; i++){
	    String work=b[i];
	    int size=a.size()-1;
	   
	    if(work.equals("+")){
		double x= a.get(0)+a.get(1);
		a.pop();
		a.pop();
		a.push(x);
	    }
	    else if(work.equals("-")){
		double x= a.get(1)-a.get(0);
		a.pop();
		a.pop();
		a.push(x);
	    }
	    else if(work.equals("*")){
		double x= a.get(1)*a.get(0);
		a.pop();
		a.pop();
		a.push(x);
	    }
	    else if(work.equals("/")){
		double num=a.get(0);
		if(num==0){
		    num=1;
		}
		double x= a.get(1)/num;
		a.pop();
		a.pop();
		a.push(x);
	    }
	    else if(work.equals("%")){
		double num=a.get(0);
		if(num==0){
		    num=1;
		}
		double x= a.get(1)%num;
		a.pop();
		a.pop();
		a.push(x);
	    }
	    else{
	
		a.push(Double.parseDouble(work));
	    }
	  
	}
	    
	return a.get(0);
    }

    public static void main(String[] args){
	System.out.println("" +
			   eval("10 2.0 +")+","+
			   eval("11 3 - 4 + 2.5 *")+","+
			   eval("8 2 + 99 9 - * 2 + 9 -")
			   );
    }

}
