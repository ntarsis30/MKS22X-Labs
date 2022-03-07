import java.util.*;
import java.io.*;
public class Maze{
private char[][]maze;
private boolean animate;//false by default
private int startRow,startCol;

/*Constructor loads a maze text file, and sets animate to false by default.
When the file is not found then:
throw a FileNotFoundException

You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
'#' - Walls - locations that cannot be moved onto
' ' - Empty Space - locations that can be moved onto
'E' - the location of the goal if any (0 or more per file)
'S' - the location of the start(exactly 1 per file)

You may also assume the maze has a border of '#' around the edges.
So you don't have to check for out of bounds!
Some text editors always include a newline at the end of a file, but that is not always present.
Make sure your file reading is able to handle this.
*/
public Maze(String filename) throws FileNotFoundException{
    //COMPLETE CONSTRUCTOR
    ArrayList<char[]> lines = new ArrayList<>();
	File file = new File(filename);
	Scanner in = new Scanner(file);
	while (in.hasNextLine()){
	    String line = in.nextLine();
	    char[] row = new char[line.length()];
	    for (int i = 0; i < line.length(); i++){
		    row[i] = line.charAt(i);
	    }
	    lines.add(row);
	}
    maze = new char[lines.size()][lines.get(0).length];
	for (int i = 0; i < lines.size(); i++){
	    for (int j = 0; j < lines.get(0).length; j++){
            if (lines.get(i)[j]=='S'){
                startRow=i;
                startCol=j;
            }
		    maze[i][j] = lines.get(i)[j];
	    }
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

public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
}
public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
}

/*Return the string that represents the maze.
It should look like the text file with some characters replaced.
*/
public String toString(){
    String ans = "";
    for (int i = 0; i < maze.length; i++){
        String row = "";
        for (int j = 0; j < maze[0].length; j++){
            row+=maze[i][j];
        }
        ans+=row+"\n";
    }
    return ans;
}

/*Wrapper Solve Function returns the helper function
Note the helper function has the same name, but different parameters.
Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
*/
public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
    clearTerminal();
    }
    //start solving at the location of the s.
    return solve(startRow,startCol,0);

}

/*
Recursive Solve function:

A solved maze has a path marked with '@' from S to E.

Returns the number of @ symbols from S to E when the maze is solved,
Returns -1 when the maze has no solution.

Postcondition:
The 'S' is replaced with '@'
The 'E' remain the same
All visited spots that were not part of the solution are changed to '.'
All visited spots that are part of the solution are changed to '@'
*/
private int solve(int row, int col, int ans){ //you can add more parameters since this is private
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(300);
        }
        char curr = maze[row][col];
        if(curr == 'E'){
            return ans;
        }
        else if(curr == '#' || curr == '.' || curr == '@'){
            return -1;
        }
        int[] dir1 = new int[] {1,-1,0,0};
        int[] dir2 = new int[] {0,0,1,-1};
        for(int i = 0; i < dir1.length; i++){
            int newRow = row + dir1[i];
            int newCol = col + dir2[i];
            maze[row][col] = '@';
            int check = solve(newRow, newCol, ans+1);
            if(check > 0){
                return check;
            }
            maze[row][col]='.';
        }
    return -1;
    }

}

