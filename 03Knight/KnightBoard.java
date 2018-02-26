public class KnightBoard{    
    private int [][] board;
    private int size;
    private int [][] pos;
    private int length;
    private int width;
    /*/
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(10,10);
	System.out.println(a.toString());
	//	System.out.println(a.countSolutions(0,0));
	System.out.println(a.solve(0,0));
	System.out.println(a.toString());

    }

    /*/
    
    public KnightBoard(int r ,int c){
	if(r<0 || c<0){

	    throw new IllegalArgumentException();
	}
	board=new int[r][c];
	size=r*c;
	pos=new int [][]{
	    {  -2, 1, -1, -2, 2, -1,  1,  2 },
	    {  -1, 2,  -2,  1, -1, 2, -2, 1 }
	};
	length=r;
	width=c;
	
    }

    private boolean check(int r, int c){
	for (int i = 0; i < board.length; i++){
	    for (int x = 0; x < board[i].length; x++){
		if (board[i][x] != 0){
		    throw new IllegalArgumentException();
		}
	    }
	}
	if (r < 0 || c < 0 || r >= length || c >= width){
	    throw new IllegalArgumentException();
	}

	return true;
    }


    public String toString(){
	String s="";
	for (int i=0; i < board.length; i++){
	    for (int x=0; x < board[i].length; x++){
		if(board[i][x]<10 &&board[i][x]>0){
		    s+="_"+""+board[i][x]+" ";
		}
		else if (board[i][x]>=10){
		    s+=""+board[i][x]+" ";
		}
		if(board[i][x]==0){
		    s+="_"+" ";
		}
	    }
	    s+="\n";		    
	}
	return s;
    }

    public boolean solve(int r, int c){
	check(r,c);
	return solveH(r,c,1);
    }

    public int countSolutions(int r, int c){
	check(r,c);
	return cH(r,c,1);
    }

    private int cH(int r, int c, int cc){
	int numSol=0;
	if (board[r][c] != 0){
	    return 0;
	}
	if (length * width == cc){
	    return 1;
	}
	
	for (int i = 0; i < 8; i++){
	    int nr = r + pos[0][i];
	    int nc = c + pos[1][i];
	    if (nr >= 0 && nc >= 0 && nc < width && nr < length){
		board[r][c] = cc;
		numSol+=cH(nr,nc,cc+1);
		board[r][c] = 0;
	    }
	}
	return numSol;	    
    }	    
    


    private boolean solveH(int r ,int c, int cc){
	if (board[r][c] != 0){
	    return false;
	}
	if (length * width == cc){
	    board[r][c] = cc;
	    return true;
	}

	
	for (int i = 0; i < 8; i++){
	    int nr = r + pos[0][i];
	    int nc = c + pos[1][i];
	    if (nr >= 0 && nc >= 0 && nc < width && nr < length){
		board[r][c] = cc;
		if (solveH(nr, nc, cc + 1)){
		    return true;
		}
		board[r][c] = 0;
	    }
	}
	return false;	    
    }
	
}
