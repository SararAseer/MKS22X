public class QueenBoard{
    private int[][]board;
    private int size;

    
    public QueenBoard(int x){
	board= new int [x][x];
	size=x;
    }

    private boolean check(){
	for (int[] x : board){
	    for(int element:x) {
		if(element!=0){
		    return false;
		}		
	    }
	}
	return true;
    }

    private void vhd(int r,int c, int x){	
	for (int i= 0 ; i < size ; i++){
	    board[r][i]+=x;
	    board[i][c]+=x;
	    if(r+i<size&& c+i<size){
		board[r+i][c+i]+=x;
	    }
	    if(r+i<size&& c-i>=0){
		board[r+i][c-i]+=x;
	    }
	    if(r-i>=0&& c+i<size){
		board[r-i][c+i]+=x;
	    }
	    if(r-i>=0&& c-i>=0){
		board[r-i][c-i]+=x;
	    }
	}
	  
    
    }
    
   
    
    private boolean addQueen(int r, int c){
	boolean q=false;
	if (r <size && c <size){
	    if (board[r][c]==0){
		vhd(r,c,1);
		q=true;
		board[r][c]=-1;
	    }
	}
	return q;
    }
    private boolean removeQueen(int r, int c){
	boolean q=false;
	if (board[r][c]==-1){
	    vhd(r,c,-1);
	    q=true;
	    board[r][c]=0;
	}
	return q;
    }


    /**
 *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
	String s="";
	for (int i=0; i < size; i++){
	    for (int x=0; x < size; x++){
		if(board[i][x]==-1){
		    s+="Q";
		}
		else{
		    s+="_";
		}
	    
	    }
	    s+="\n";		    
	}
	return s;
    }
  
    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve(){
	if(!check()){
	    throw new IllegalStateException("Board has a number");
	}
	if(doit(0)){
	    return true;
	}
	return false;
    }

    private boolean doit(int c){
	if (c==size){
	    return true;
	}

	for (int i=0; i < size; i++){
	    if(addQueen(i,c)){
		if(doit(c+1)){
		    return true;
		}
		removeQueen(i,c);
	    }
	    
	}
	return false;
    }
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
	if(!check()){
	    throw new IllegalStateException("Board has a number");
	}
	int a=csh(0);
	for (int i =0; i < board.length ; i++){
	    for (int x= 0 ; x < board[i].length; x++){
		board[i][x]=0;
	    }
	}
	return a;
	
    }

    private int csh(int c){
	int x = 0;
  	if (c == board.length){
	    return 1;
    	}

    	for (int r = 0; r < board.length; r++){
    	    if (addQueen(r,c)){
		x += csh(c+1);
		removeQueen(r,c);	
    	    }
    	}

	
    	return x;


    }
}





