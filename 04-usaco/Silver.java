import java.util.*;
import java.io.*;
public class Silver{
    public static long solve(String filename){
        try{
            Scanner in = new Scanner(new File(filename));
            int n = in.nextInt();
            int m = in.nextInt();
            int t = in.nextInt();
            int[][][] dp = new int[n][m][t+1];
            int[][] grid = new int[n][m];
            in.nextLine();
            for(int i = 0; i < n; i++){
                String line = in.nextLine();
                for(int j = 0; j < m; j++){
                    if (line.charAt(j) == '*'){
                        grid[i][j] = -1;
                    } 
                }
            }
            int sr = in.nextInt()-1;
            int sc = in.nextInt()-1;
            int er = in.nextInt()-1;
            int ec = in.nextInt()-1;
            dp[sr][sc][0]=1;
            for (int time = 1; time <= t; time++){
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < m; j++){
                        if (grid[i][j]!=-1){
                            if(i!=0){
                                dp[i][j][time]+=dp[i-1][j][time-1];
                            }
                            if(i<n-1){
                                dp[i][j][time]+=dp[i+1][j][time-1];
                            }
                            if(j!=0){
                                dp[i][j][time]+=dp[i][j-1][time-1];
                            }
                            if(j<m-1){
                                dp[i][j][time]+=dp[i][j+1][time-1];
                            }
                        }
                    }
                }
            }
            return dp[er][ec][t];
        }
        catch(FileNotFoundException e){
            return -1;
        }
    }
}