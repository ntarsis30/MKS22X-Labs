import java.util.*;
import java.lang.Math;
public class MazeGenerator{
    public static String toString(char[][]maze){
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
    public static void generate(char[][]maze, int startrow, int startcol){
        recurse(maze,startrow,startcol);
        maze[startrow][startcol]='S';
        int max = 0;
        int[] coords = new int[] {startrow, startcol};
        for(int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                if (maze[i][j]=='.'){
                    maze[i][j]='#';
                }
                else if (maze[i][j]==' ' && Math.abs(i-startrow)+Math.abs(j-startcol)>max){
                    max=  Math.abs(i-startrow)+Math.abs(j-startcol);
                    coords[0]=i;
                    coords[1]=j;
                }

            }
        }
        maze[coords[0]][coords[1]]='E';
    }
    public static void recurse(char[][]maze, int startrow, int startcol){
        if (!safe(maze,startrow,startcol) && maze[startrow][startcol]!=' '){
            maze[startrow][startcol]='.';
            return;
        }
        maze[startrow][startcol]=' ';
        int[] dir1 = new int[] {1,-1,0,0};
        int[] dir2 = new int[] {0,0,1,-1};
        int[] order = permRand();
        for (int i : order){
            int newRow = startrow + dir1[i];
            int newCol = startcol + dir2[i];
            if (safe(maze,newRow,newCol) && maze[newRow][newCol]!='.'){
                recurse(maze,newRow,newCol);
            }
            else if (maze[startrow][startcol]!=' '){
                maze[newRow][newCol]='.';
            }
        }
    }
    public static boolean safe(char[][] maze, int row, int col){
        if (row == 0 || row == maze.length-1 || col == 0 || col == maze[0].length-1 || maze[row][col]==' '){
            return false;
        }
        int spaces = 0;
        int[] dir1 = new int[] {1,-1,0,0};
        int[] dir2 = new int[] {0,0,1,-1};
        for(int i = 0; i < dir1.length; i++){
            int newRow = row + dir1[i];
            int newCol = col + dir2[i];
            if (maze[newRow][newCol]==' '){
                spaces++;
            }
        }
        return spaces < 2;
    }
     
    public static int[] permRand(){
        int[] perm = new int[4];
        ArrayList<Integer> nums = new ArrayList<>(4);
        for (int i = 0; i < 4; i++)
            nums.add(i);
        int curr = 0;
        while (nums.size() > 0){
            int index = (int)(Math.random() * nums.size());
            perm[curr]=nums.get(index);
            nums.set(index,nums.get(nums.size()-1));
            nums.remove(nums.size()-1);
            curr++;
        }
        return perm;
    }
}