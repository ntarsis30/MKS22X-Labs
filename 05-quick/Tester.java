import java.util.Arrays;
public class Tester {
  public static void main(String[] args) {
    System.out.println("This should take around 20-30 seconds. Not longer.\n");
    test_all();
    /*
    long[] time = new long[]{0, 0};

    for (int i = 0; i < 20; i++) {
      long start = System.currentTimeMillis();
      testEqual();
      long end = System.currentTimeMillis();
      time[0]++;
      time[1] += end -start;
      System.out.println(end - start);
    }
    System.out.println("\n" + time[1]/time[0]);*/
  }
  public static void test_all() {
    print("Negative", testNeg());
    print("Reverse", testRev());
    print("Tiny Random", testRandom_1());
    print("Big Random", testRandom_0());
    print("Equal", testEqual());
    long start = System.currentTimeMillis();
    print("Sorted", testSorted());
    long end = System.currentTimeMillis();
    if (end - start >= 5000) System.out.println("your sort works on sorted arrays but takes way too long, u didn't the dutch partition thing or ur computer is ass\n");
  }
  public static void print(String type, boolean pass) {
    if (pass) {
      System.out.println(type + " Arrays: PASS\n");
    } else {
      System.out.println(type + " Arrays: FAIL\n");
    }
  }
  public static boolean testNeg() {
    boolean good = true;
    for (int i = 0; i < 10; i++) {
      int[] arr_0 = makeNeg();
      int[] arr_1 = arr_0.clone();
      Quick.quicksort(arr_0);
      Arrays.sort(arr_1);
      if (!(Arrays.toString(arr_0).equals(Arrays.toString(arr_1)))) return false;
    }
    return good;
  }
  public static boolean testSorted() {
    boolean good = true;
    for (int i = 0; i < 10; i++) {
      int[] arr_0 = makeSorted();
      int[] arr_1 = arr_0.clone();
      Quick.quicksort(arr_0);
      Arrays.sort(arr_1);
      if (!(Arrays.toString(arr_0).equals(Arrays.toString(arr_1)))) return false;
    }
    return good;
  }
  public static boolean testRev() {
    boolean good = true;
    for (int i = 0; i < 10; i++) {
      int[] arr_0 = makeRev();
      int[] arr_1 = arr_0.clone();
      Quick.quicksort(arr_0);
      Arrays.sort(arr_1);
      if (!(Arrays.toString(arr_0).equals(Arrays.toString(arr_1)))) return false;
    }
    return good;
  }
  public static boolean testRandom_0() {
    boolean good = true;
    for (int i = 0; i < 10; i++) {
      int[] arr_0 = makeRandom_0();
      int[] arr_1 = arr_0.clone();
      Quick.quicksort(arr_0);
      Arrays.sort(arr_1);
      if (!(Arrays.toString(arr_0).equals(Arrays.toString(arr_1)))) return false;
    }
    return good;
  }
  public static boolean testRandom_1() {
    boolean good = true;
    for (int i = 0; i < 10; i++) {
      int[] arr_0 = makeRandom_1();
      int[] arr_1 = arr_0.clone();
      Quick.quicksort(arr_0);
      Arrays.sort(arr_1);
      if (!(Arrays.toString(arr_0).equals(Arrays.toString(arr_1)))) return false;
    }
    return good;
  }
  public static boolean testEqual() {
    boolean good = true;
    for (int i = 0; i < 10; i++) {
      int[] arr_0 = makeEqual();
      int[] arr_1 = arr_0.clone();
      Quick.quicksort(arr_0);
      Arrays.sort(arr_1);
      if (!(Arrays.toString(arr_0).equals(Arrays.toString(arr_1)))) return false;
    }
    return good;
  }
  public static int[] makeRandom_0() {
    int[] arr = new int[(int) (Math.random() * 10000000)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 500);
    }
    return arr;
  }
  public static int[] makeRandom_1() {
    int[] arr = new int[(int) (Math.random() * 10000000)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 8);
    }
    return arr;
  }
  public static int[] makeRev() {
    int[] arr = makeSorted();
    int[] rev = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      rev[i] = arr[arr.length - 1 - i];
    }
    return rev;
  }
  public static int[] makeEqual() {
    int num = (int) (Math.random() * 10);
    int[] arr = new int[(int) (Math.random() * 10000000)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = num;
    }
    return arr;
  }
  public static int[] makeSorted() {
    int[] arr = makeRandom_0();
    Arrays.sort(arr);
    return arr;
  }
  public static int[] makeNeg() {
    int[] arr = new int[(int) (Math.random() * 10000000)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * -1000);
    }
    return arr;
  }
}
