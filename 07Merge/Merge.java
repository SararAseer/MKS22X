import java.util.*;
import java.io.*;

public class Merge{

    public static void main(String[] args){
	int[] test = new int[Integer.parseInt(args[0])];
	for(int i =0; i < test.length; i++){
	    Random seed= new Random();
	    int num=seed.nextInt((Integer.parseInt(args[1])));
	    if(seed.nextBoolean()){
		num*=-1;
	    }
	    test[i]=num;
	}

	System.out.println("Test:"+"\n"+toString(test));
	mergesort(test);
	System.out.println("Test:"+"\n"+toString(test));
	   
    }

    private static void insertionSort(int[] data,int lo, int hi){
	if (hi > lo){
      
	    insertionSort( data, lo,hi-1 );
      
	    int pos1 = data[hi-1];
	    int pos2 = hi-2;
      	    while (pos2 >= lo && data[pos2] > pos1){
		    data[pos2+1] = data[pos2];
		    pos2--;
		}
	    data[pos2+1] = pos1;
	}
    }
    
    public static String toString(int[] list){
	String s="[";
	for (int i = 0; i < list.length-1; i++){
	    s+=""+list[i]+",";	    	    
	}
	
	s+=""+list[list.length-1]+"]";
	return s;
    }
    
    public static void mergesort(int[] data){
	int [] temp= new int[data.length];
	for(int i=0; i < data.length;i++){
	    temp[i]=data[i];


	}
	msort(data,temp, 0, data.length-1);
    }

  
    private static void msort(int [] data, int [] temp, int lo, int hi){
	if(lo<hi){
	    int mid = (hi+lo)/2;
	    msort(data,temp,lo,mid);
	    msort(data,temp,mid+1,hi);
	    merge(data,temp,lo,mid,hi);
	    for(int i=lo; i<=hi;i++){
		temp[i]=data[i];

	    }
	}
	
    }

    
    
  
    private static void merge(int [] x, int [] y, int lo,int mid, int hi){
	if(hi-lo>30){
	    int pos=lo;
	    int m2=mid+1;

	    while(lo<=mid && m2<=hi){
		if(y[lo]<=y[m2]){
		    x[pos]=y[lo];
		    lo++;
		}	    
		else{
		    x[pos]=y[m2];
		    m2++;
		}
		pos++;
	    }
	    while (lo <= mid){
		x[pos] = y[lo];
		lo++;
		pos++;
	    }
	    while (m2 <=hi){
		x[pos] = y[m2];
		m2++;
		pos++;
	    }
	}
	else{
	    insertionSort(x,lo,hi);
	}
    }
   
    
}
