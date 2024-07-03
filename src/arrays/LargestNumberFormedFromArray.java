package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedFromArray {
    public static void main(String[] args) {
        String[] arr = {"3", "30", "34", "5", "9"};
        System.out.println(printLargest(arr.length, arr));
    }

    static String printLargest(int n, String[] arr) {
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        String res = sb.toString();
        return res.startsWith("0") ? "0" : res;
    }
}
