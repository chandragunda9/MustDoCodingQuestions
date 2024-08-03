package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberToInteger {
    public static void main(String[] args) {
        System.out.println(getVal('I'));
        System.out.println(romanToDecimal("XIX"));
    }

    public static int romanToDecimal(String str) {
        int n = str.length();
        int romanValue = getVal(str.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            int val = getVal(str.charAt(i));
            int nextVal = getVal(str.charAt(i + 1));
            if (val < nextVal) {
                romanValue -= val;
            } else {
                romanValue += val;
            }
        }
        return romanValue;
    }

    static int getVal(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
