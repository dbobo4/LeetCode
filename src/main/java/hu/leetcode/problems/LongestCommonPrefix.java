package hu.leetcode.problems;

import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String result = "";

        List<String> listOfWords = new ArrayList<>(Arrays.asList(strs));

        listOfWords.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int minimumIterationNumber = listOfWords.get(0).length();

        HashSet<Character> characterHashSet = new HashSet<>();

        for (int i = 0; i < minimumIterationNumber; i++) {
            for (String word : strs) {
                characterHashSet.add(word.charAt(i));
            }
            if (characterHashSet.size() < 2) {
                result += strs[0].charAt(i);
            } else {
                return result;
            }
            characterHashSet.clear();
        }
        return result;
    }
}
