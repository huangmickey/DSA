package ctci.ch1_arrays_and_strings;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) {
        isUnique("abc");
        isUnique("aabc");
        isUnique("!@AaBb");
        isUnique("");
    }

    public static boolean isUnique(String s) {

        if (s.length() > 128) return false;

        int[] asciiValues = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (asciiValues[s.charAt(i)] != 0) {
                System.out.println(s + " is not unique");
                return false;
            }
            asciiValues[s.charAt(i)]++;
        }
        System.out.println(s + " is unique");
        return true;
    }

}
