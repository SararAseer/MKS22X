import java.util.*;
import java.io.*;


public class Quick{
    
    public static void main(String[] args){
	try{
	    int[] test = new int[Integer.parseInt(args[0])];
	    for(int i =0; i < test.length; i++){
		Random seed= new Random();
		int num=seed.nextInt((Integer.parseInt(args[1])));
		if(seed.nextBoolean()){
		    num*=-1;
		}
		test[i]=num;

	    }
	    System.out.println("Before:"+"\n"+toString(test));
	    System.out.println(partition(test, 0, test.length-1));
	    System.out.println("After:"+"\n"+toString(test));
	}
	catch(Exception IndexOutOfBounds){
	    System.out.println("After the file name insert the size of the array and the bounds for the numbers in the array"+"\n"+"EX: FileName 10 200"+"\n"+"Would give an array of size 10 with numbers ranging from -200 to 200");
	}
    
    }

    private static String toString(int[] list){
	String s="[";
	for (int i = 0; i < list.length-1; i++){
		s+=""+list[i]+",";	    	    
	}
	
	s+=""+list[list.length-1]+"]";
	return s;
    }
   
    public static int partition(int[] x,int lo, int hi){
	Random seed= new Random();
	int piv=seed.nextInt((hi-lo));
	System.out.println(toString(x));
	swap(piv+lo,lo,x);
	int i=lo+1;
	int a=x[lo];
	while(i<=hi){
	    System.out.println(toString(x));
	    if(x[i]< x[lo]){
		swap(i,lo,x);
		i++;
		lo++;
	    }
	    else if(x[i]>x [lo]){
		swap(i,hi,x);
		hi--;
	    }

	    else if(x[i]==x[lo]){
		i++;
	    }
	      
	}
	System.out.println(""+lo+","+hi);
	System.out.println("piv:"+a);
	return x[i];
    }

    public static void swap(int a, int b, int list[]){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}

