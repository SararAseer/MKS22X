import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int [][]path=new int[][]{
	    {0,1},
	    {1,0},
	    {-1,0},
	    {0,-1}
    };
    private int[][] se=new int [2][2];;
    private int length;
    private int width;
    
    
    public Maze(String filename) throws FileNotFoundException{
	File file = new File(filename);
        Scanner scan = new Scanner(file);
        int r,c;                                         
        r =0;
	c = 0;
        while (scan.hasNextLine()){
            String line = scan.nextLine();
	    c = line.length();
            r += 1;
        }
        int s = 0;
        int e = 0;
        maze = new char[r][c];
	length=r;
	width=c;
        Scanner data = new Scanner(file);
        for(int i = 0; i < r; i++){
            String q = data.nextLine();
            for (int x = 0; x < c; x++){
                maze[i][x] = q.charAt(x);
                if (maze[i][x] == 'S'){
                    s += 1;
		    se[0]=new int[] {i,x};
                }
                if (maze[i][x] == 'E'){
                    e += 1;
		    se[1]=new int []{i,x};
                }
            }
        }
        if (! (s == 1 && e == 1)){
            throw new IllegalStateException();
        }
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }


    public int solve(){
	int s=0;
	maze[se[0][0]][se[0][1]]=' ';
	if( solve(se[0][0],se[0][1])){
	    for (int i=0; i < maze.length; i++){
		for (int x=0; x < maze[i].length; x++){
		    if(maze[i][x]=='@'){
			s+=1;
		    }
		}
	    }
	    return s;
	}
	return -1;
    }

    public String toString(){
	String s="";
	for (int i=0; i < maze.length; i++){
	    for (int x=0; x < maze[i].length; x++){
		s+=maze[i][x];
	    }
	    s+="\n";		    
	}
	return s;
    }

  
    private boolean solve(int r, int c){
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(30);
        }
	if (maze[r][c] != ' '){
	    return false;
	}
	if (maze[r][c] == 'E'){
	    return true;
	}

	
	for (int i = 0; i < 4; i++){
	    int nr = r + path[i][0];
	    int nc = c + path[i][1];
	    if (nr >= 0 && nc >= 0 && nc < width && nr < length){
		if (maze[nr][nc] == 'E'){
		    maze[r][c] = '@';
		    return true;
		}
		maze[r][c] = '@';
		if (maze[nr][nc]==' ' &&solve(nr, nc)){
		    return true;
		}
		maze[r][c] = '.';
	    }
	  
	}
	return false;	    
    }
	
    
}
