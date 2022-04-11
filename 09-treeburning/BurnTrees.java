import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private Deque<int[]> q;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation

    return q.size()==0;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,1,-1};
    int curr = q.size();
    for (int i = 0; i < curr; i++){
      int[] point = q.remove();
      int r = point[0];
      int c = point[1];
      map[r][c] = ASH;
      for (int j = 0; j < 4; j++){
        if (r+dy[j]>=0 && r+dy[j]<map.length && c+dx[j]>=0 && c+dx[j]<map[0].length && map[r+dy[j]][c+dx[j]]==TREE){
          map[r+dy[j]][c+dx[j]]=FIRE;
          int[] temp = {r+dy[j],c+dx[j]};
          q.addLast(new int[]{r+dy[j],c+dx[j]});
        }
      }
    }
    ticks++;//leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    q = new ArrayDeque<int[]>();
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        int[] temp = {i,0};
        q.add(temp);
        map[i][0]=FIRE;
      }
    }
  }
  public static double averageOfNRuns(int n, int size, double density){
    double answer = 0;
    for (int i = 0; i < n; i++){
      BurnTrees burn = new BurnTrees(size,size,density);
      answer+=burn.run();
    }
    return (double) answer/n;
  }

    public static void main(String[]args){
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .7;
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      //BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
      
      for (double i = 5; i < 100; i+= 5){
        double actual = (double) i/100;
        System.out.println(i + " " + averageOfNRuns(100,500,actual));
      }
      System.out.println();
      for (double i = 55; i < 66; i+= 1){
        double actual = (double) i/100;
        System.out.println(i + " " + averageOfNRuns(100,500,actual));
      }
      
      //int test = 1000;//100 500
      //double b = averageOfNRuns(100,test,0.61);
      //System.out.println(b);
      //System.out.println(b/((double)test));




      //int ans = b.animate(DELAY);//animate all screens
      //System.out.println(ans);//print the final answer

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
