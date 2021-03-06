public class Recursion{

    /*Print all words that are made of the letters a-e inclusive.
    *@param length : the length of the words that are to be printed
    */
    public static void printAllWords(int length){
      printAllWords(length,"");
    }

    /*Print all words that are made of the letters a-e inclusive.
    *@param length : either how many more letters or the total length depending on implementation
    *@param word   : the partial word so far.
    */
    public static void printAllWords(int length, String word){
      if (length==0){
        System.out.println(word);
        return;
      }
      for (char c = 'a'; c <= 'e';c++){
        printAllWords(length-1,word+c);
      }
    }

    /*Print all words that are made of the characters in the array of letters.
    *There may not be consecutive equal letters, so:
    *aax is not allowed, but axa is allowed.
    *@param length : the length of the words that are to be printed
    *@param letters: the letters you should be using
    */
    public static void printNoDoubleLetterWords(int length,char[] letters){
      printNoDoubleLetterWords(length,"",letters);
    }

    /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
    *aax is not allowed, but axa is allowed.
    *@param length : either how many more letters need to be
    *@param word   : the partial word so far.
    *@param letters: the letters you should be using
    */
    public static void printNoDoubleLetterWords(int length,String word,char[]letters){
      if (length==0){
        System.out.println(word);
        return;
      }
      for (char c : letters){
        if ((word.length()>0 && word.charAt(word.length()-1)!=c)||word.length()==0){
          printNoDoubleLetterWords(length-1,word+c, letters);
        }
      }
    }
    public static String reverse(String s){
      if (s.length()==0){
        return s;
      }
      return s.substring(s.length()-1)+reverse(s.substring(0,s.length()-1));
    }
    public static long countNoDoubleLetterWords(int length,String word){
      if (length==0){
        return 1;
      }
      int ans = 0;
      for (char c = 'a'; c <= 'z'; c++){
        if ((word.length()>0 && word.charAt(word.length()-1)!=c)||word.length()==0){
          ans += countNoDoubleLetterWords(length-1,word+c);
        }
      }
      return ans;
    }
    public static double sqrt(double n){
      return sqrt(n, 1);
    }
    public static double sqrt(double n, double guess){
      double check = guess*guess;
      double percent = Math.abs(check-n)*(100.0);
      if(n!=0){
        percent/=n;
      }
      if (percent <= 0.001){
        return guess;
      }
      return sqrt(n,(n/guess+guess)/2);
    }
    public static int fibIter(int n, int f1, int f2){
      if (n==0){
        return f2;
      }
      return fibIter(n-1,f1+f2,f1);
      }
    public static void main(String[] args){
      char[] test = {'a','b','c'};
      System.out.println(countNoDoubleLetterWords(3,""));
      System.out.println(reverse("abc"));
      System.out.println(sqrt(100.0));
      System.out.println(sqrt(0.0));
      System.out.println(fibIter(0,1,0));
      System.out.println(fibIter(1,1,0));
      System.out.println(fibIter(10,1,0));
      System.out.println(fibIter(10,5,4));

    }


}
