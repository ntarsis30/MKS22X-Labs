import java.util.NoSuchElementException;
//THIS IS NOT MY TESTER!!

public class CalcTest {
  
  public static void main(String[] args) {
    if (SingleOperationTest() & MultipleSameOperationsTest() & ExceptionChecking()) {
      // Uses single & to force evaluation of all values as per: https://stackoverflow.com/questions/20422793/is-there-a-way-to-disable-short-circuit-evaluation-in-java
      System.out.println("\nPasses all tests");
    } else {
      System.out.println("\nDoes not pass all tests");
    }
    // SingleOperationTest();
    // MultipleSameOperationsTest();
    // ExceptionChecking();
  }

  public static boolean SingleOperationTest() {
    boolean add = Calculator.eval("1 2 +") == (1 + 2) && Calculator.eval("-1 2 +") == (-1 + 2) && Calculator.eval("123456 2000 +") == (123456 + 2000);
    boolean subtract = Calculator.eval("1 2 -") == (1 - 2) && Calculator.eval("-1 2 -") == (-1 - 2) && Calculator.eval("123456 2000 -") == (123456 - 2000);;
    boolean divide = Calculator.eval("1 1 /") == (1 / 1) && Calculator.eval("65 42 /") == (65.0 / 42.0) && Calculator.eval("-79.2 46.13 /") == (-79.2 / 46.13);
    boolean multiply =  Calculator.eval("1 1 *") == (1 * 1) && Calculator.eval("65 42 *") == (65 * 42) && Calculator.eval("-79.2 46.13 *") == (-79.2 * 46.13);
    boolean modulo = Calculator.eval("1 1 %") == (1 % 1) && Calculator.eval("65 42 %") == (65 % 42) && Calculator.eval("-79.2 46.13 %") == (-79.2 % 46.13);;

    System.out.println("For a single operation on two numbers:");
    System.out.println("Add is " + add);
    System.out.println("Subtract is " + subtract);
    System.out.println("Divide is " + divide);
    System.out.println("Multiply is " + multiply);
    System.out.println("Modulo is " + modulo);
    System.out.println();
    return add && subtract && divide && multiply && modulo;
  }

  public static boolean MultipleSameOperationsTest() {
    boolean passes = true;
    System.out.println("\nUsing Mr.K's provided tests:");
    System.out.println("Testing: \"11 3 - 4 + 2.5 *\" \nExpected: 30.0 \nActual: " + Calculator.eval("11 3 - 4 + 2.5 *"));
    if (Calculator.eval("11 3 - 4 + 2.5 *") != 30.0) {
      passes = false;
    }
    System.out.println();
    System.out.println("Testing: \"10 2.0 +\" \nExpected: 12.0 \nActual: " + Calculator.eval("10 2.0 +"));
    if (Calculator.eval("10 2.0 +") != 12.0) {
      passes = false;
    }
    System.out.println();
    System.out.println("Testing: \"8 2 + 99 9 - * 2 + 9 -v \nExpected: 893.0 \nActual: " + Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
    if (Calculator.eval("8 2 + 99 9 - * 2 + 9 -") != 893.0) {
      passes = false;
    }
    System.out.println();
    System.out.println("Testing: \"1 2 3 4 5 + * - -\" \nExpected: 26.0 \nActual: " + Calculator.eval("1 2 3 4 5 + * - -"));
    if (Calculator.eval("1 2 3 4 5 + * - -") != 26.0) {
      passes = false;
    }
    System.out.println(); 
    return passes;
  }

  public static boolean ExceptionChecking() {
    System.out.println("\nAll error checking is done with the + operator, does not check others and assumes handling is identical");
    boolean passes = true;
    System.out.println();
    try {
      Calculator.eval("1 +");
      System.out.println("Does not error properly when provided 1 operand and 1 operator");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too few operands") && !e.getMessage().equals("too few operands for operation +")) {
        System.out.println("Throws properly when provided 1 operand and 1 operator, but invalid exception message given");
        passes = false;
      } else {
        System.out.println("Throws properly when provided 1 operand and 1 operator");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided 1 operand and 1 operator");
      passes = false;
    }
    try {
      Calculator.eval("+");
      System.out.println("Does not error properly when provided no operands and 1 operator");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too few operands") && !e.getMessage().equals("too few operands for operation +")) {
        System.out.println("Throws properly when provided no operands and 1 operator, but invalid exception message given");
        passes = false;
      } else {
        System.out.println("Throws properly when provided no operands and 1 operator");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided no operands and 1 operator");
      passes = false;
    }
    try {
      Calculator.eval("1");
      System.out.println("Does not error when provided 1 operands and no operator, this is correct");
    } catch (IllegalArgumentException e) {
      System.out.println("Throws when provided 1 operands and no operator, should not do this");
      passes = false;
    }

    System.out.println();
    try {
      Calculator.eval("1 1 + +");
      System.out.println("Does not error properly when provided 2 operands and 2 operator");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too few operands") && !e.getMessage().equals("too few operands for operation +")) {
        System.out.println("Throws properly when provided 2 operand and 2 operator, but invalid exception message given");
        passes = false;
      } else {
        System.out.println("Throws properly when provided 2 operands and 2 operator");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided 2 operands and 2 operator");
      passes = false;
    }
    try {
      Calculator.eval("1 1");
      System.out.println("Does not error properly when provided 2 operands and no operator");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too many operands")) {
        System.out.println("Throws properly when provided 2 operands and no operator, but invalid exception message given");
        passes = false;
      } else {
        System.out.println("Throws properly when provided 2 operands and no operator");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided 2 operand and no operator");
      passes = false;
    }
    try {
      Calculator.eval("+ 1 1");
      System.out.println("Does not error properly when provided 2 operand and 1 operator, operator too early");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too few operands") && !e.getMessage().equals("too few operands for operation +")) {
        System.out.println("Throws properly when provided 2 operand and 1 operator, but invalid exception message given, operator too early");
        passes = false;
      } else {
        System.out.println("Throws properly when provided 2 operands and 1 operator, operator too early");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided 2 operand and 1 operator, operator too early");
      passes = false;
    }

    System.out.println();
    try {
      Calculator.eval("1 1 + 1 + +");
      System.out.println("Does not error properly when provided 4 operands and 4 operators, initial operation is valid");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too few operands") && !e.getMessage().equals("too few operands for operation +")) {
        System.out.println("Throws properly when provided 4 operands and 4 operators, but invalid exception message given");
        passes = false;
      } else {
        System.out.println("Throws properly when provided 4 operands and 4 operators");
      }    
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided 4 operands and 4 operators, initial operation works");
      passes = false;
    }
    try {
      Calculator.eval("");
      System.out.println("Does not error properly when provided an empty string");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too few operands") && !e.getMessage().equals("too few operands for operation +")) {
        System.out.println("Throws properly when provided an empty string, but invalid exception message given");
        passes = false;
      } else {
        System.out.println("Throws properly when provided an empty string");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided an empty string");
      passes = false;
    }
    try {
      Calculator.eval("1 1 + 1 + 1");
      System.out.println("Does not error properly when provided 4 operand and 2 operator, trailing operand");
      passes = false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("too many operands")) {
        System.out.println("Throws properly when provided 4 operand and 2 operator, but invalid exception message given, operator too early");
        passes = false;
      } else {
        System.out.println("Throws properly when provided 4 operands and 2 operator, operator too early");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Does not error properly when provided 4 operand and 2 operator, trailing operand");
      passes = false;
    }
    return passes;
  }
}
