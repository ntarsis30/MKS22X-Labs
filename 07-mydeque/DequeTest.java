import java.util.*;

public class DequeTest {
  public static void main(String[] args) {
    AddLast15();
    AddFirst15();
    AddFirstLast15();
    AddRemove15();
    AddRemove15Add10();
    Add15RemoveFirst10();
    Add15RemoveLast10();
    EmptyDeque();
    EmptyDequeAddLast15();
    EmptyDequeAddFirst15();
    ErrorTest();
    DequeCompare();
    RemoveLastTesting();
    RemoveFirstTesting();
  }

  public static void AddLast15() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    System.out.println("Should print a deque of numbers 0 to 14 in linear order incrementing by 1");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void AddFirst15() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addFirst(i);
      real.addFirst(i);
    }
    System.out.println("Should print a deque of numbers 14 to 0 in reverse linear order deceremnting by 1");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void AddFirstLast15() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      test.addFirst(i);
      real.addLast(i);
      real.addFirst(i);
    }
    System.out.println("Should print a deque of numbers 14 to 0 and then 0 to 14 incrementing by 1");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }
  public static void AddRemove15() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      test.removeLast();
      real.addLast(i);
      real.removeLast();
    }
    System.out.println("Should print an empty deque");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }
  
  public static void AddRemove15Add10() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      test.removeLast();
      real.addLast(i);
      real.removeLast();
    }
    for (int i = 0; i < 10; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    System.out.println("Should print a deque of numbers from 0 to 9");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void Add15RemoveFirst10() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    for (int i = 0; i < 10; i++) {
      test.removeFirst();
      real.removeFirst();
    }
    System.out.println("Should print a deque of numbers from 10 to 14");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void Add15RemoveLast10() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    for (int i = 0; i < 10; i++) {
      test.removeLast();
      real.removeLast();
    }
    System.out.println("Should print a deque of numbers from 0 to 4");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void EmptyDeque() {
    System.out.println("Should print an empty deque");
    MyDeque test = new MyDeque<Integer>(0);
    Deque real = new LinkedList<Integer>();
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void EmptyDequeAddLast15() {
    System.out.println("Starts with a capacity of zero, should print a deque of numbers from 0 to 14 incrementing by 1");
    MyDeque test = new MyDeque<Integer>(0);
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void EmptyDequeAddFirst15() {
    System.out.println("Starts with a capacity of zero, should print a deque of numbers from 14 to 0 decrementing by 1");
    MyDeque test = new MyDeque<Integer>(0);
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addFirst(i);
      real.addFirst(i);
    }
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void RemoveLastTesting() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    test.addFirst(1);
    real.addFirst(1);
    for (int i = 0; i < 8; i++) {
      test.addLast(i);
      test.removeFirst();
      real.addLast(i);
      real.removeFirst();
    }
    for (int i = 0; i < 100; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    int length = test.size();
    for (int i = 0; i < length; i++) {
      if (!test.removeLast().equals(real.removeLast())) {
        System.out.println("After removing and adding 10 times, adding 100 values and removing from all from the last does not work as predicted");
        System.out.println();
        return;
      }
    }
    System.out.println("After removing and adding 10 times, adding 100 values and removing them all from the last does work as predicted");
    System.out.println();
  }

  public static void RemoveFirstTesting() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    test.addFirst(1);
    real.addFirst(1);
    for (int i = 0; i < 8; i++) {
      test.addLast(i);
      test.removeFirst();
      real.addLast(i);
      real.removeFirst();
    }
    for (int i = 0; i < 100; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    int length = test.size();
    for (int i = 0; i < length; i++) {
      if (!test.removeFirst().equals(real.removeFirst())) {
        System.out.println("After removing and adding 10 times, adding 100 values and removing them all from the first does not work as predicted");
        System.out.println();
        return;
      }
    }
    System.out.println("After removing and adding 10 times, adding 100 values and removing them all from the first does work as predicted");
    System.out.println();
  }

  public static void ErrorTest() {
    MyDeque test = new MyDeque<Integer>();
    try {
      test.addFirst(null);
      System.out.println("Does not catch null in addFirst");
    } catch (NullPointerException e) {
      System.out.println("Catches null in addFirst correctly");
    }
    try {
      test.addLast(null);
      System.out.println("Does not catch null in addLast");
    } catch (NullPointerException e) {
      System.out.println("Catches null in addLast correctly");
    }
    try {
      test.getFirst();
      System.out.println("Does not catch empty deque in getFirst");
    } catch (NoSuchElementException e) {
      System.out.println("Catches empty deque in getFirst correctly");
    }
    try {
      test.getLast();
      System.out.println("Does not catch empty deque in getLast");
    } catch (NoSuchElementException e) {
      System.out.println("Catches empty deque in getLast correctly");
    }
    System.out.println();
  }

  public static void DequeCompare() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    Random random = new Random();
    int next;
    for (int i = 0; i < 100000; i++) {
      next = random.nextInt();
      test.addFirst(next);
      real.addFirst(next);
      next = random.nextInt();
      test.addLast(next);
      real.addLast(next);
    }
    for (int i = 0; i < 99999; i++) {
      boolean getFirst = test.getFirst().equals(real.getFirst());
      boolean removeFirst = test.removeFirst().equals(real.removeFirst());
      boolean getLast = test.getLast().equals(real.getLast());
      boolean removeLast = test.removeLast().equals(real.removeLast());
      if (!(getFirst && removeFirst && getLast && removeLast)) {
        System.out.println("Does not function as a real deque would when adding and then removing many random values");
        return;
      }
    }
    System.out.println("Functions as a real deque would when adding and then removing many random values");
    System.out.println();
  }
}
