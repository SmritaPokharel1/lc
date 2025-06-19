package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {

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
