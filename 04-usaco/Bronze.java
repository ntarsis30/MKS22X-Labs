import java.util.*;
import java.io.*;
public class Bronze{
    public static void stomp(int[][] grid, int r,int c,int d){
        int max = 0;
        for (int i = r; i < r+3; i++){
            for (int j = c; j < c+3; j++){
                if (grid[i][j]>max){
                    max = grid[i][j];
                }
            }
        }
        for (int i = r; i < r+3; i++){
            for (int j = c; j < c+3; j++){
                if (grid[i][j]>max-d){
                    grid[i][j]=max-d;
                }
            }
        }
    }
    public static long solve(String filename){
        try{
            Scanner in = new Scanner(new File(filename));
            int r = in.nextInt();
            int c = in.nextInt();
            int e = in.nextInt();
            int n = in.nextInt();
            int[][] grid = new int[r][c];

            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    grid[i][j] = in.nextInt();
                }
            }
            
            while(in.hasNextInt()){
                stomp(grid, in.nextInt()-1, in.nextInt()-1, in.nextInt());
            }

            int ans = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(grid[i][j] < e){
                        ans += e - grid[i][j];
                    }
                }
            }
            return ans*72*72;
        }
        catch(FileNotFoundException e){
            return -1;
        }

    }
}