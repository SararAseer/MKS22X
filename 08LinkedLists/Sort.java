public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> x){
	if(x != null && x.size() != 0){
	
	    int max = x.get(x.max());

	    if (max != 0){
		max = ((int)(Math.log10(max)))+1;
	    }
	    

	    @SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[] bL = new MyLinkedListImproved[11];
	    int place = 0;
	    for(int z = 0; z <= max; z++){
		for(Integer j: x){
		    if((int)(Math.log10(j)) >= z){
			int t=j;
			for(int i = 0; i < z; i++){
			    t/=10;
			}
			place=t;
		    }
		    else if(j<0){
			place = 10;
		    }
		    else{
			place = 0;
		    }
		    if(bL[place] == null){
			MyLinkedListImproved<Integer> hold= new MyLinkedListImproved<>();
			hold.add(j);
			bL[place] = hold;			
		    }
		    else{
			bL[place].add(j);
		    }
		
		}
		x.clear();
		int c = 0;
		for(MyLinkedListImproved<Integer> pc: bL){
		    if(pc != null && c <11){
			x.extend(pc);
		    }
		    c++;

		}	
	    }
	    if(bL[10]!=null){
		radixsort(bL[10]);
		bL[10].rev();
		bL[10].extend(x);
		x = bL[10];
		bL[10].clear();

	    }

	}
	
    }

    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	radixsort(data);
    }
}    
