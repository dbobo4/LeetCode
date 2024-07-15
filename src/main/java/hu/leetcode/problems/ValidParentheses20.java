package hu.leetcode.problems;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {

        String target = "([}}])";

        boolean result = isValid(target);

        System.out.println(result);

    }

    public static boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.empty();
    }
}