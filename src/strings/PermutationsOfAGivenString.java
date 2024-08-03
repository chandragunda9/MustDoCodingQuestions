package strings;

import java.util.*;

public class PermutationsOfAGivenString {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(find_permutation(s));
    }

    public static List<String> find_permutation(String S) {
        Set<String> se = new HashSet<>();
        char[] chars = S.toCharArray();
        recurPermute(0, chars, se);
        List<String> ans = new ArrayList<>(se);
        Collections.sort(ans);
        return ans;
    }

    static void recurPermute(int index, char[] chars, Set<String> se) {
        if (index == chars.length) {
            se.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            recurPermute(index + 1, chars, se);
            swap(chars, index, i);
        }
    }

    static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
