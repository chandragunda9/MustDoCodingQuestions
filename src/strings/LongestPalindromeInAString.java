package strings;

public class LongestPalindromeInAString {
    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println(longestPalin(s));
    }

    static String longestPalin(String S) {
        int n = S.length();
        //expanding around centre
        //for odd lengths
        int maxLen = 1, start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (S.charAt(l) != S.charAt(r))
                    break;
                l--;
                r++;
            }
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                start = l + 1;
                end = r - 1;
            }
            maxLen = Math.max(maxLen, r - l - 1);
        }

        //even lengths
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n) {
                if (S.charAt(l) != S.charAt(r))
                    break;
                l--;
                r++;
            }
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                start = l + 1;
                end = r - 1;
            }
            maxLen = Math.max(maxLen, r - l - 1);
        }
        return S.substring(start, end + 1);
    }
}
