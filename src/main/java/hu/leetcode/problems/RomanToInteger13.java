package hu.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class RomanToInteger13 {
    public int romanToInt(String s) {

        String[] romanSymbols = {"I", "V", "X", "L", "C", "D", "M"};
        int[] arabIntegers = {1,5,10,50,100,500,1000};

        char[] target = s.toCharArray();

        List<Integer> tempResult = new ArrayList<>();
        int result = 0;



        boolean isAfterFirstElement = false;
        for (int i = 0; i < s.length(); i++){


            int lastElement = tempResult.size()-1;

            if (i>0){
                isAfterFirstElement = true;
            }

            switch (target[i]){
                case 'I':
                    tempResult.add(1);
                    break;
                case 'V':
                    if (isAfterFirstElement && target[i-1] == 'I'){
                        tempResult.remove(lastElement);
                        tempResult.add(4);
                        break;
                    }
                    tempResult.add(5);
                    break;
                case 'X':
                    if (isAfterFirstElement && target[i-1] == 'I'){
                        tempResult.remove(lastElement);
                        tempResult.add(9);
                        break;
                    }
                    tempResult.add(10);
                    break;
                case 'L':
                    if (isAfterFirstElement && target[i-1] == 'X'){
                        tempResult.remove(lastElement);
                        tempResult.add(40);
                        break;
                    }
                    tempResult.add(50);
                    break;
                case 'C':
                    if (isAfterFirstElement && target[i-1] == 'X'){
                        tempResult.remove(lastElement);
                        tempResult.add(90);
                        break;
                    }
                    tempResult.add(100);
                    break;
                case 'D':
                    if (isAfterFirstElement && target[i-1] == 'C'){
                        tempResult.remove(lastElement);
                        tempResult.add(400);
                        break;
                    }
                    tempResult.add(500);
                    break;
                case 'M':
                    if (isAfterFirstElement && target[i-1] == 'C'){
                        tempResult.remove(lastElement);
                        tempResult.add(900);
                        break;
                    }
                    tempResult.add(1000);
                    break;
            }
        }

        for (int number : tempResult){
            result += number;
        }

        return result;
    }
}
