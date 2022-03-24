import java.util.Arrays;
import java.util.Random;
//This is not my tester
public class MergeTest {

  public static void main(String[] args) {
    randomMilHundreds();
    randomMilHundredsSorted();
    randomMilHundredsReverseSorted();
    randomMilNegHundreds();
    randomMilMillions();
    zerosMil();
    equalsMil();
    randomHunThousandTimes();
    random10MilHundreds();
    sizeOneArray();
    sizeZeroArray();
  }

  public static void randomMilHundreds() {
    System.out.println("An unsorted array of length 1 million with random values from 0 to 100:");
    int[] ary = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(100);
      if((int) (Math.random() *50) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void random10MilHundreds() {
    System.out.println("An unsorted array of length 10 million with random values from 0 to 100:");
    int[] ary = new int[10000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(100);
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void randomMilNegHundreds() {
    System.out.println("An unsorted array of length 1 million with random values from -100 to 100:");
    int[] ary = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(200) - 100;
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void randomMilMillions() {
    System.out.println("An unsorted array of length 1 million with random values from 0 to 1000000:");
    int[] ary = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(1000000);
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void zerosMil() {
    System.out.println("An unsorted array of length 1 million with all zeros:");
    int[] ary = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = 0;
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void equalsMil() {
    System.out.println("An unsorted array of length 1 million with all equal values:");
    int[] ary = new int[1000000];
    Random random = new Random();
    int value = random.nextInt(1000000);
    for (int i = 0; i < ary.length; i++) {
      ary[i] = value;
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static boolean randomHun() {
    int[] ary = new int[100];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(1000000);
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    Merge.mergesort(ary);
    boolean test = aryEquals(ary, sortedAry);
    return test;
  }

  public static void randomHunThousandTimes() {
    System.out.println("An unsorted array of length 100 with all random values from 0 to 1000000 1000 times:");
    boolean result = true;
    long time = System.currentTimeMillis();
    for (int i = 0; i < 1000; i++) {
      if (!randomHun()) {
        result = false;
        if((int) (Math.random() *10) == 7)System.out.print("\007");
      }
    }
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The arrays are sorted: " + result);
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void sizeOneArray() {
    System.out.println("An array of a single random value:");
    int[] ary = new int[1];
    Random random = new Random();
    int value = random.nextInt(1000000);
    for (int i = 0; i < ary.length; i++) {
      ary[i] = value;
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void sizeZeroArray() {
    System.out.println("An empty array:");
    int[] ary = new int[0];
    Random random = new Random();
    int value = random.nextInt(1000000);
    for (int i = 0; i < ary.length; i++) {
      ary[i] = value;
      if((int) (Math.random() *10) == 7)System.out.print("\007");
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void randomMilHundredsSorted() {
    System.out.println("A sorted array of length 1 million with random values from 0 to 100:");
    int[] ary = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(100);
    }
    Arrays.sort(ary);
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }

  public static void randomMilHundredsReverseSorted() {
    System.out.println("A reverse sorted array of length 1 million with random values from 0 to 100:");
    int[] ary = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < ary.length; i++) {
      ary[i] = random.nextInt(100);
    }
    Arrays.sort(ary);
    int[] ary2 = aryCopy(ary);
    for (int i = ary2.length - 1; i >= 0; i--) {
      ary[ary.length - i - 1] = ary2[i];
    }
    int[] sortedAry = aryCopy(ary);
    Arrays.sort(sortedAry);
    long time = System.currentTimeMillis();
    Merge.mergesort(ary);
    double runTime = ((double) (System.currentTimeMillis() - time)) / ( 1000.0);
    System.out.println("The array is sorted: " + aryEquals(ary, sortedAry));
    System.out.println("The sort took " + runTime + " seconds\n");
  }





  public static int[] aryCopy(int[] ary) {
    int[] out = new int[ary.length];
    for (int i = 0; i < ary.length; i++) {
      out[i] = ary[i];
    }
    return out;
  }

  public static boolean aryEquals(int[] ary1, int[] ary2) {
    if (ary1.length != ary2.length) {
      System.out.println("Comapred two arrays of unequal length");
      System.exit(1);
    }
    for (int i = 0; i < ary1.length; i++) {
      if (ary1[i] != ary2[i]) {
        return false;
      }
    }
    return true;
  }
}
