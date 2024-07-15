package hu.leetcode.problems;

public class FibonacciNumber509 {

    public static int fib(int n) {
        return fiboRec1(n);
    }

    public static int fiboRec1(int n) {
        if (n == 0) {
            return 0;
        }

        return fiboRec2(1, n-2, 0, 1);
    }

    public static int fiboRec2(int result, int counter, int a, int b) {
        if (counter < 0) {
            return result;
        } else {
            result = a + b;
            return fiboRec2(result, --counter, b, a + b);
        }
    }

}
