package ctci.ch1;
/**
 * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(checkPermutation("abc","bca"));

        System.out.println(checkPermutation("ABC","CAB"));

        System.out.println(checkPermutation("ABcD", "BACd"));

        System.out.println(checkPermutation("a!2a", "2!aa"));

        System.out.println(checkPermutation("aaa", "aa"));

        System.out.println(checkPermutation("abcdefg", "bdaefhc"));


    }
    //Checks if both strings have identical character counts
    public static boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int[] letterValues = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            letterValues[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int charValue = s2.charAt(i);
            letterValues[charValue]--;
            if (letterValues[charValue] < 0) return false;
        }
        return true;
    }
}
