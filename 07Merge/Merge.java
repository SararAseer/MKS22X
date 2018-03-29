import java.util.*;
import java.io.*;

public class Merge{

    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;
    private static final int EMPTY = 4;

    private static String name(int i){
	if(i==0)return "Increassing";
	if(i==1)return "Decreassing";
	if(i==2)return "Normal Random";
	if(i==3)return "Random with Few Values";
	if(i==4)return "size 0 array";
	return "Error stat array";

    }

    private static int create(int min, int max){
	return min + (int)(Math.random()*(max-min));
    }

    private static int[]makeArray(int size,int type){
	int[]ans =new int[size];
	if(type == STANDARD){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-1000000,1000000);
	    }
	}
	if(type == INCREASE){
	    int current = -5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current += 10;
	    }
	}
	if(type == DECREASE){
	    int current = 5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current -= 10;
	    }
	}
	if(type == SMALL_RANGE){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-5,5);
	    }
	}
	if(type == EMPTY){
	    ans = new int[0];
	}
	return ans;
    }

    public static void main(String[]args){
	if(args.length < 2)return;
    
	int size =  Integer.parseInt(args[0]);
	int type =   Integer.parseInt(args[1]);

	int [] start = makeArray(size,type);
	int [] result = Arrays.copyOf(start,start.length);
	Arrays.sort(result);
    
	long startTime = System.currentTimeMillis();
	mergesort(start);
	long elapsedTime = System.currentTimeMillis() - startTime;
	if(Arrays.equals(start,result)){
	    System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
	}else{
	    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
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
	if(hi-lo<=30){
	    insertionSort(data,lo,hi);
	}
	else if(lo<hi){
	    int mid = (hi+lo)/2;
	    msort(data,temp,lo,mid);
	    msort(data,temp,mid+1,hi);
	    merge(data,temp,lo,mid,hi);
	    for(int i=lo; i<=hi;i++){
		temp[i]=data[i];

	    }
	}
	
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

    
    
  
    private static void merge(int [] x, int [] y, int lo,int mid, int hi){
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
   

}
