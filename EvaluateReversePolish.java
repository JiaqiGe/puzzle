//
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

import java.util.*;

public class EvaluateReversePolish {
    public int evalRPN(String[] tokens){
      if(tokens.length == 0){
        return 0;
      }
      Set<String> operators = new HashSet<>();

      operators.add("+");
      operators.add("-");
      operators.add("*");
      operators.add("/");

      Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < tokens.length; i++){
        if(!operators.contains(tokens[i])){
          stack.push(Integer.parseInt(tokens[i]));
        }else{
          if(stack.size() >= 2){
            int o1 = stack.pop();
            int o2 = stack.pop();

            int v = calculate(o1, o2, tokens[i]);
            stack.push(v);
          }else{
            return 0;
          }
        }
      }
      return stack.pop();
    }

    private int calculate(int o1, int o2, String opt){
      int result = 0;
      switch (opt){
        case "+":
          result = o1 + o2;
          break;
        case "-":
          result = o1 - o2;
          break;
        case "*":
          result = o1*o2;
          break;
        case "/":
          result = o1 / o2;
          break;
        default:
          break;
        }
        return result;
      }
    }
}
