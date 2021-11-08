package ctci.ch1_arrays_and_strings;

import java.util.Arrays;

/**
 * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println("checkPermutation Solution");
        System.out.println(checkPermutation("abc","bca"));
        System.out.println(checkPermutation("ABC","CAB"));
        System.out.println(checkPermutation("ABcD", "BACd"));
        System.out.println(checkPermutation("a!2a", "2!aa"));
        System.out.println(checkPermutation("aaa", "aa"));
        System.out.println("\ncheckPermutation2 Solution");
        System.out.println(checkPermutation2("abc","bca"));
        System.out.println(checkPermutation2("ABC","CAB"));
        System.out.println(checkPermutation2("ABcD", "BACd"));
        System.out.println(checkPermutation2("a!2a", "2!aa"));
        System.out.println(checkPermutation2("aaa", "aa"));
    }

    /**
     * Define permutation:
     * Permutation is when the two strings with the same characters but could possibly be in different order. If all characters are the same but in different order then
     * it is a permutation because it is the same exact string but in different order.  Going by this definition we know that both strings must be of same lengths to be
     * a permutation of each other.
     *
     * Time complexity: O(n) ; Space complexity: O(128) --> O(1)
     *
     */
    public static boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int[] letterValues = new int[128];      //Assume (Ask first) if using ASCII printable characters only possible which would mean there is 95 total characters in that range
                                                //which point to ascii codes from 32-127 therefore we use index 0-128 to represent each of these ascii codes

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

    /**
     * Second Solution:
     * Sort both strings which would put both strings in the same order. Then check for equality on both strings.
     * If equal then that means there is a permutation else there isn't
     *
     * Time complexity: O(nlogn) because sorting strings would be a (n log n) operation
     * Space complexity: O(1)
     */
    public static boolean checkPermutation2(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        //Convert both strings to char array
        char[] s1Content = s1.toCharArray();
        char[] s2Content = s2.toCharArray();
        //Sort both char arrays using Arrays.sort method
        Arrays.sort(s1Content);
        Arrays.sort(s2Content);
        //Convert both char arrays back to a string
        String s1Sorted = new String(s1Content);
        String s2Sorted = new String(s2Content);
        //Make a comparison between the newly sorted strings
        return s1Sorted.equals(s2Sorted);
    }
}
