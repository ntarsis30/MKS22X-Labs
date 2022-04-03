import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
    *Assume valid postfix notation, of ints doubles and operators separated by spaces.
    *Valid operators are + - / * and % (remainder not modulo)
    *All results are doubles even if the operands are both int.
    *@throws IllegalArgumentException when there are too many or too few operands.
    *        Use the string parameter of your exception to indicate what happened.
    *        Either "too many operands" or "too few operands"
    *        OR (optionally: "too few operands for operation _" replace _ with +,- etc.)
    */
    public static double eval(String s){
    Scanner in = new Scanner(s);
    Deque<Double> stack = new ArrayDeque<Double>();
    while(in.hasNext()){
        if(in.hasNextDouble()){
            double num = Double.parseDouble(in.next());
            stack.add(num);
        }
        else{
            if(stack.size()<2){
                throw new IllegalArgumentException("too few operands");
            }
            double operand1 = stack.removeLast();
            double operand2 = stack.removeLast();
            String operation = in.next();
            switch(operation){
                case "+":
                    stack.add(operand2+operand1);
                case "*":
                    stack.add(operand2*operand1);
                case "-":
                    stack.add(operand2-operand1);
                case "/":
                    stack.add(operand2/operand1);
                case "%":
                    stack.add(operand2%operand1); 
            }
        }
    }
    in.close();
    if(stack.size()>1){
        throw new IllegalArgumentException("too many operands");
    }
    else if(stack.size()<1){
        throw new IllegalArgumentException("too few operands");
    }
    return stack.removeLast();
    
    }
    public static void main(String[] args){
        
    }
}