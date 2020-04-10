package com.lxl.linear.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 逆波兰表达式  后缀表达式，符号放在操作数后面
 * a+b   ab+
 * a+(b-c)  abc-+
 * a+(b-c)*d abc-d*+
 * a+[(b+c)+(d+e)*f]   abc+de+f*++
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0;i<tokens.length;i++){
            String token = tokens[i];
            switch (token){
                case "+":
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left + right);
                    break;
                case "-" :
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*" :
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;
                case  "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

}
