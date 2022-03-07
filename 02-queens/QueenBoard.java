public class QueenBoard{
  private int[][] board;
  private boolean animated;
  private int delay;

  public QueenBoard(int size) {
    board = new int[size][size];
  }
  public void setAnimate(boolean newValue){
    animated = newValue;
  }
  public void setDelay(int newValue){
    delay = newValue;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (board[i][j]<0){
          ans+= "Q ";
        }
        else{
          ans+= "_ ";
        }
      }
      ans+= "\n";
    }
    return ans;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  public boolean addQueen(int r, int c){
    if (board[r][c]!=0){
      return false;
    }
    board[r][c]=-1;
    for (int i = 0; i < board.length; i++){
      if (i!=r){
        board[i][c]++;
      }
      if(i!=c){
        board[r][i]++;
      }
    }
    int diag1 = r+c;
    int diag2 = c-r;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (i+j==diag1 && i!=r){
          board[i][j]++;
        }
        else if (j-i==diag2 && i!=r){
          board[i][j]++;
        }
      }
    }
    if(animated){
      System.out.println(Text.go(1,1));
      System.out.println(this);//can modify here
      Text.wait(delay);
    }
    return true;



  }

  /**Remove the queen that was added to r,c
  *@precondition there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  public void removeQueen(int r, int c){
    board[r][c]=0;
    for (int i = 0; i < board.length; i++){
      if (i!=r){
        board[i][c]--;
      }
      if(i!=c){
        board[r][i]--;
      }
    }
    int diag1 = r+c;
    int diag2 = c-r;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if (i+j==diag1 && i!=r){
          board[i][j]--;
        }
        else if (j-i==diag2 && i!=r){
          board[i][j]--;
        }
      }
    }
    if(animated){
      System.out.println(Text.go(1,1));
      System.out.println(this);//can modify here
      Text.wait(delay);
    }
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve(){
    for (int i = 0; i < board.length;i++){
      for (int j = 0; j < board.length; j++){
        if (board[i][j]!=0){
          throw new IllegalStateException("Not clear");
        }
      }
    }
    return solve(0);
  }
  public boolean solve(int row){
    if (row==board.length){
      return true;
    }
    for (int i = 0; i < board.length;i++){
      if (addQueen(row,i)){
        if (solve(row+1)){
          return true;
        }
        removeQueen(row,i);
      }
    }
    return false;
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions(int row){
    for (int i = 0; i < board.length;i++){
      for (int j = 0; j < board.length; j++){
        if (board[i][j]!=0){
          throw new IllegalStateException("Not clear");
        }
      }
    }
    if (row==board.length){
      return 1;
    }
    int ans = 0;
    for (int i = 0; i < board.length; i++){
      if (addQueen(row,i)){
        ans += countSolutions(row+1);
        removeQueen(row,i);
      }
    }
    return ans;
  }
  public int countSolutions(){
    return countSolutions(0);
  }
}
