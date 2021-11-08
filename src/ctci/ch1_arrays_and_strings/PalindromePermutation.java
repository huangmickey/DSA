package ctci.ch1_arrays_and_strings;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 *
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("Tact Cao"));
        System.out.println(checkPalindrome("abccbal"));
        System.out.println(checkPalindrome("Never Odd Or Even"));
    }

    /**
     *  O(n)
     *  O(128) --> O(1)
     */
    public static boolean checkPalindrome(String s) {

        if (s == null) return false;

        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        int[] charFreq = new int[128];

        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i)]++;
        }

        int numOddFreq = 0;

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] == 1) {
                numOddFreq++;
            }
        }

        return numOddFreq <= 1;
    }
}
