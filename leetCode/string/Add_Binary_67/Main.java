import java.util.Stack;

class Solution {
    public String addBinaryStack(String a, String b) {
        if(b.length() > a.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder sb = new StringBuilder();
        int carryBit = 0;
        Stack<String> textStack = new Stack<String>();
        for(int i = 0; i < a.length(); i++) {
            int numericalA = Character.getNumericValue(a.charAt(a.length() - 1 - i));
            int numbericalB = i < b.length()?Character.getNumericValue(b.charAt(b.length() - 1 - i)):0;
            int bitValue = (numericalA + numbericalB + carryBit) % 2;
            textStack.push(Integer.toString(bitValue));
            if(numericalA + numbericalB + carryBit > 1) carryBit = 1;
            else carryBit = 0;
        }
        if (carryBit == 1) {
            textStack.push(Integer.toString(carryBit));
        }

        var it = textStack.iterator();
        while(it.hasNext()) {
            sb.append(textStack.pop());
        }

        return sb.toString();
    }

    public String addBinaryNeat(String s1, String s2) {
        if (s1 == null) {
            return s2;
        } else if (s2 == null) {
            return s1;
        }

        int carry = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuffer sb = new StringBuffer();

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0 && s1.charAt(i) == '1') {
                sum++;
            }
            if (j >= 0 && s2.charAt(j) == '1') {
                sum++;
            }
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public String addBinary(String a, String b) {
        if(b.length() > a.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder sb = new StringBuilder();
        int carryBit = 0;
        for(int i = 0; i < a.length(); i++) {
            int numericalA = Character.getNumericValue(a.charAt(a.length() - 1 - i));
            int numbericalB = i < b.length()?Character.getNumericValue(b.charAt(b.length() - 1 - i)):0;
            int bitValue = (numericalA + numbericalB + carryBit) % 2;
            sb.append(Integer.toString(bitValue));
            if(numericalA + numbericalB + carryBit > 1) carryBit = 1;
            else carryBit = 0;
        }
        if (carryBit == 1) {
            sb.append(Integer.toString(carryBit));
        }
        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}