import java.util.*;
import java.io.*;


public class Quick{
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
	quicksort(start);
	long elapsedTime = System.currentTimeMillis() - startTime;
	if(Arrays.equals(start,result)){
	    System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
	}else{
	    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
	}
    }
    public static void insertionSort(int[] data, int lo, int hi){
	for (int i=lo+1; i<=hi; ++i){
	    int sub = data[i];
	    int place = i;
	    while (place>lo && data[place-1] > sub){
		data[place] = data[place-1];
		place = place-1;
	    }
	    data[place] = sub;
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
   
    public static int partition(int[] x,int lo, int hi){
	
	Random seed= new Random();
	int piv=seed.nextInt((hi-lo));
	swap(piv+lo,lo,x);
	int i=lo+1;
	int a=x[lo];
	while(i<=hi){
	    //   System.out.println(toString(x));
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
	//	System.out.println(""+lo+","+hi);
	//	System.out.println("piv:"+a);
	if(i!=0){
	    i=i-1;
	}
	
	return lo;
	
    }

	    



    public static void quicksort(int[]ary){
	QSH(ary,0,ary.length-1);
    }

    private static void QSH(int ary[], int lo, int hi){
	int n=(ary.length-1);
	if (hi-lo<=30){
	    insertionSort(ary,lo,hi);
	}
	else if(hi>lo){
	    int mid=partition(ary,lo,hi);
	    QSH(ary,lo,mid-1);
	    QSH(ary,mid+1,hi);
	}
	
    }

    private static void bs(int[] data){
 	for (int i=0; i <data.length-1;i++){
	    if(i<0)i=0;
 	    if (data[i]>data[i+1]){
 		int x=i;
 		while(x!=data.length-1 && data[x]>data[x+1]){
 		    int swap=data[x];
 		    data[x]=data[x+1];
		    data[x+1]=swap;
 		    x++;
 		    
 		}
 		i=i-2;
 	    }
	    
 	}
    }
    
    public static int quickselect(int[]ary, int k){
	return QSH(ary,k-1,0,ary.length-1);
    }

    private static int QSH(int[]ary, int k, int lo, int hi){
	int pos = partition(ary, lo, hi);
	if (pos-1 == k){
	    return ary[k];
	}
	if (k > pos+1){
	    return QSH(ary, k, pos + 1, ary.length -1);
	}
	if (k<pos-1){
	    return QSH(ary, k, 0, pos - 1);
	}
	
	return k;
	
    }

    public static void swap(int a, int b, int list[]){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}

