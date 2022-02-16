public class Driver{
  public static void main(String[] args){
    QueenBoard test = new QueenBoard(13);
    System.out.println(test.toString());
    System.out.println(test.countSolutions());

  }
}
