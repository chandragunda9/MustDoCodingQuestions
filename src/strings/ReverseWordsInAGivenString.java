package strings;

public class ReverseWordsInAGivenString {
    public static void main(String[] args) {
        String st = "i.like.this.program.very.much";
        System.out.println(reverseWords(st));
    }

    static String reverseWords(String S) {
        String[] arr = S.split("\\.");
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            String temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return String.join(".", arr);
    }
}
