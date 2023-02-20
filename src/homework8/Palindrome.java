package homework8;

public class Palindrome {
    private static final String CHAR_TO_KEEP = "[^A-Za-zА-Яа-я]";

    public boolean result(String s) {
        String formatted = s.toLowerCase().replaceAll(CHAR_TO_KEEP, "");
        String reversed = new StringBuilder(formatted).reverse().toString();
        return reversed.equals(formatted);
    }
}
