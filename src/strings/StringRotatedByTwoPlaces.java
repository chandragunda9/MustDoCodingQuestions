package strings;

public class StringRotatedByTwoPlaces {
    public static void main(String[] args) {
        String a = "amazon", b = "azonam";
        System.out.println(isRotated(a, b));
    }

    public static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length() || str1.length() < 2)
            return false;
        return str2.equals(str1.substring(2) + str1.substring(0, 2)) ||
                str2.equals(str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2));
    }
}
