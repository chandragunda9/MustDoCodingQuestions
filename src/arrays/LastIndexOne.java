package arrays;

public class LastIndexOne {
    public static void main(String[] args) {
        String str = "00001";
        System.out.println(lastIndex(str));
    }

    public static int lastIndex(String s) {
        return s.lastIndexOf('1');
    }
}
