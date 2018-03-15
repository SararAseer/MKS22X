import java.util.*;
import java.io.*;

public class Quick{
    
    public static void main(String[] args){
	int[] test = {1,999,9999,999,999,999,999,999,999};
	System.out.println(partition(test, 0, test.length-1));
	System.out.println(toString(test));
    }

    private static String toString(int[] list){
	String s="";
	for (int i = 0; i < list.length; i++){
	    s+=""+list[i]+",";
	}
	return s;
    }
   
    public static int partition(int[] x,int lo, int hi){
	System.out.println(""+lo+","+hi);
	Random seed= new Random();
	int piv=seed.nextInt((hi-lo));
	swap(piv+lo,lo,x);
	final int num=lo;
	lo+=1;
	while(lo<=hi){
	    System.out.println(""+lo+","+hi);
	    System.out.println(toString(x));
	    if(x[lo]> x[num]){
		swap(lo,hi,x);
		hi--;
	    }
	    if(x[lo]<x [num]){
		lo++;
	    }

	    if(x[lo]==x[num]){
		lo++;
	    }
	      
	}
	swap(hi,num,x);
	System.out.println(""+lo+","+hi);
	return x[hi];
    }

    public static void swap(int a, int b, int list[]){
	System.out.println(""+a+","+b);
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
