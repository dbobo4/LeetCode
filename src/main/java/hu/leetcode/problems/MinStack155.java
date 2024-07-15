package hu.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

class MinStack155 {

    List<Integer> stack = new ArrayList<>();
    List<Integer> minimumNumberStack = new ArrayList<>();
    int top = -1;
    int minimumNumberTop = -1;
    int min = Integer.MAX_VALUE;

    public MinStack155() {
    }

    public void push(int val) {

        if (val <= min) {
            min = val;
            minimumNumberStack.add(val);
            minimumNumberTop++;
        }
        stack.add(val);
        top++;
    }

    public void pop() {
        if (stack.get(top).equals(minimumNumberStack.get(minimumNumberTop))) {
            minimumNumberStack.remove(minimumNumberTop);
            minimumNumberTop--;
            if (minimumNumberTop == -1) {
                min = Integer.MAX_VALUE;
            }else {
                min = minimumNumberStack.get(minimumNumberTop);
            }
        }
        stack.remove(top);
        top--;
        if (top == -1) {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        return minimumNumberStack.get(minimumNumberTop);
    }

    public void adatotKiir() {
        System.out.println();
        System.out.println("Stack: ");
        for (int num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Min stack: ");
        for (int num : minimumNumberStack) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}