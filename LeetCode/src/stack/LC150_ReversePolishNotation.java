package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class LC150_ReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

        Set<String> operators = Set.of("+", "-", "*", "/");

        for(String s : tokens){

            if (operators.contains(s)) {

                if(stack.size() < 2) return 0;
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = execute(num1, num2, s);
                stack.push(result);
            }else{

                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    public int execute(int num1, int num2, String operand){

        int result = switch(operand){

            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operator : "+operand);
        };

        return result;
    }

    public int evalRPNI(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

        for(String token : tokens){

            switch(token){

                case "+":
                    int n2 = stack.pop();
                    int n1 = stack.pop();

                    stack.push(n2+n1);
                    break;
                case "-":
                    int n4 = stack.pop();
                    int n3 = stack.pop();

                    stack.push(n3 - n4);
                    break;
                case "*":

                    int n6 = stack.pop();
                    int n5 = stack.pop();

                    stack.push(n6 * n5);
                    break;
                case "/":

                    int n8 = stack.pop();
                    int n7 = stack.pop();

                    stack.push(n7 / n8);
                    break;
                default :
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public int evalRPN_1(String[] tokens) {

        List<String> op = Arrays.asList("+", "-", "/", "*");

        Stack<String> stack = new Stack<String>();

        for(String token : tokens){

            if(op.contains(token)){

                if(stack.size() < 2) return 0;

                int second = Integer.parseInt(stack.pop());

                int first = Integer.parseInt(stack.pop());

                int result = execute(token, first, second);

                stack.push(result+"");
            }else{
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public int execute(String op, int num1, int num2){

        if(op.equals("+")){

            return num1 + num2;
        }

        if(op.equals("*")){

            return num1 * num2;
        }

        if(op.equals("/")){

            return num1 / num2;
        }

        if(op.equals("-")){

            return num1 - num2;
        }

        return 0;
    }
}
