package hu.leetcode.problems;

import java.util.Stack;

public class LongestValidParentheses32 {
    public static void main(String[] args) {

        String target = ")()())()((()()()()";
        int result = longestValidParentheses(target);
        System.out.println(result);

    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> parenthesisStack = new Stack<>();

        int result = 0;

        parenthesisStack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                parenthesisStack.push(i);
            } else {
                parenthesisStack.pop();
                if (parenthesisStack.empty()) {
                    parenthesisStack.push(i);
                } else {
                    result = Math.max(result, (i - parenthesisStack.peek()));
                }
            }
        }
        return result;
    }

}
