package strings;

public class RecursivelyRemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "geeksforgeek";
        System.out.println(rremove(s));
    }

    static String rremove(String s) {
        if (s.equals(""))
            return "";
        StringBuilder changedStr = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                while (i < n && s.charAt(i) == s.charAt(i - 1)) {
                    i++;
                }
            } else {
                changedStr.append(s.charAt(i));
                i++;
            }
        }
        if (s.length() == changedStr.length())
            return s;
        return rremove(changedStr.toString());
    }
}
