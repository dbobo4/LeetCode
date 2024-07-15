package hu.leetcode.problems;

public class PalindromeNumber9 {

    public boolean isPalindrome(int x) {
        String target = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        sb.append(target);
        return target.contentEquals(sb.reverse());
    }

}
