package hu.leetcode.problems;

public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        String[] splittedString = s.trim().split(" ");
        return splittedString[splittedString.length - 1].length();
    }

}
