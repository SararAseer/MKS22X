import java.util.*;
import java.io.*;

public class USACO{

    public static void main(String[] args){
	System.out.println(USACO.silver("Data.txt"));
	//	System.out.println(USACO.bronze("copy.txt"));
    }
    
    public static int bronze(String filename){
	int row = 0;
	int col = 0;
	int elevation;
	int instructions;
	int[][] board;
	int depth = 0;

	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String l = s.nextLine();
	    String[] n = l.split(" ");
	    row = Integer.parseInt(n[0]);
	    col = Integer.parseInt(n[1]);
	    elevation = Integer.parseInt(n[2]);
	    instructions = Integer.parseInt(n[3]);
	    board = new int[row][col];
	    for (int i = 0; i < row; i++){
	    	String j = s.nextLine();
	    	String[] read = j.split(" ");
    		for (int z = 0;z < col; z++){
		    board[i][z] = Integer.parseInt(read[z]);
    		}
		
	    }
	    
	    for (int i = 0; i < instructions; i++){
		String a="";
		String j = s.nextLine();
		String[] read = j.split(" ");
		board=doit(Integer.parseInt(read[0]),Integer.parseInt(read[1]),Integer.parseInt(read[2]),board,row,col);
				
	    }
	    
	    
	    String b="";

	    for (int i = 0; i < row; i++){
		for (int j = 0; j < col; j++){
		    int d = board[i][j];
		    if (d < elevation){
			board[i][j]=elevation-board[i][j];
			depth += elevation - d;
		    }
		    else{
			board[i][j]=0;
		    }
		    b+=" "+ board[i][j];
		}
		b+="\n";;
	    }

		
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(1);
	}
	return depth * 72 * 72;
    }

    private static int [][] doit(int r, int c, int d, int[][] board,int row,int col){
	String a="";	
	int b=0;
	final int h=board[r-1][c-1];
	final int x=h-d;
	for (int i = 0;  i < 3;  i++){
	    for (int j = 0;  j < 3; j++){
		if (board[r+i-1][c+j-1] > b) {
		    b=board[r+i-1][c+j-1];
		}
	    }
	}
	int t=b-d;
	for (int i = 0;  i < 3;  i++){
	    for (int j = 0;  j < 3; j++){
		if(board[r+i-1][c+j-1]>t){
		    board[r+i-1][c+j-1]=t;
		}
	  
	    }
	}
	for (int f = 0; f < row; f++){
	    for (int z= 0; z < col; z++){
		a+=" "+ board[f][z];
		    
	    }
	    a+="\n";
	}
	
    
	
	
	
	return board;
	}
    
    public static int silver(String filename){
	//Mouse maze Algorithim + Patch behavior
	int []info=new int[7];
	char[][] board;

	try{
	  
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String l = s.nextLine();
	    String[] x = l.split(" ");
	    info[0] = Integer.parseInt(x[0]);
	    info[1] = Integer.parseInt(x[1]);
	    info[2] = Integer.parseInt(x[2]);
	    board = new char[info[0]][info[1]];	    
	    for (int i = 0; i < board.length; i++){
	    	String a = s.nextLine();
    		for (int z = 0; z < info[1]; z++){
		    board[i][z] = a.charAt(z);
    		}
	    }
	    String nl = s.nextLine();
	    String[] sl = nl.split(" ");
	    for(int i=0; i < 4; i++){
		info[i+3]=Integer.parseInt(sl[i]) - 1;
	    }	  	    
	    int[][] track = new int[info[0]][info[1]];
	    int[][] track2 = new int[info[0]][info[1]];	    
	    track[info[3]][info[4]] = 1;
	    while (info[2] > 0){
		for (int i = 0; i < board.length; i++){
		    for (int g = 0; g < board[i].length; g++){
			if (track[i][g] != 0){
			    int[][] path = {{i+1,g}, {i-1, g}, {i, g+1}, {i, g-1}};
			    for (int tries =0; tries< path.length; tries++){
				if (path[tries][0] >= 0 && path[tries][0] < info[0] && path[tries][1] >= 0 && path[tries][1] < info[1]){
				    if(board[path[tries][0]][path[tries][1]] != '*'){
					track2[path[tries][0]][path[tries][1]] += track[i][g];
				    }
				}
			    }
			    track[i][g] = 0;
			}
		    
		    }
		
		}
		
		track = track2;
		track2 = new int[info[0]][info[1]];
		info[2] -= 1;
	    }
	    return track[info[5]][info[6]];

	}catch(FileNotFoundException e){
	    System.out.println("FILE!");
	}
	return 0;
    }

    
}
