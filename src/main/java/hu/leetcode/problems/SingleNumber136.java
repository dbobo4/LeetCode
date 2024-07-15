package hu.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {

        int result = 0;

        Map<Integer, Integer> m = new HashMap();

        for (int num : nums) {
            if (m.containsKey(num)) {
                int oldValue = m.get(num);
                m.put(num, oldValue + 1);
            } else {
                m.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
