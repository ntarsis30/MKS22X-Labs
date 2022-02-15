public class Driver{
  public static void main(String[] args){
    QueenBoard test = new QueenBoard(5);
    System.out.println(test.toString());
    test.solve();
    System.out.println(test.toString());

  }
}
