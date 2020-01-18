import java.util.HashMap;

class Solution {
    public int romanToInt1(String s) {
        int integerSum = 0;
        for (int i = 0; i < s.length(); i++) {
           if(i != s.length() - 1 &&
                   ((s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                    || (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                    || (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')))) {
                integerSum += getCharVal(s.charAt(i + 1)) - getCharVal(s.charAt(i));
                i++;
            } else {
                integerSum += getCharVal(s.charAt(i));
            }
        }
        return integerSum;
    }

    public int romanToInt(String s) {
        // initially the integerSum is initialized to the last char.
        int integerSum = getCharVal(s.charAt(s.length() - 1));
        for(int i = s.length() - 1; i > 0; i--){

            int currChar = getCharVal(s.charAt(i));
            int prevChar = getCharVal(s.charAt(i - 1));

            if(currChar > prevChar){
                integerSum -= prevChar;
            }else{
                integerSum += prevChar;
            }

        }
        return integerSum;
    }

    private int getCharVal(char currentChar){
        switch(currentChar){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}