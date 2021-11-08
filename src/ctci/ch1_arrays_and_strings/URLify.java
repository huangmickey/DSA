package ctci.ch1_arrays_and_strings;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 */
public class URLify {
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith    ", 13));
        System.out.println(URLify("Ms Abigail T. May    ", 17));
    }

    public static String URLify(String s, int length) {

        char[] charArr = s.toCharArray();

        int spaceCount = 0, index, i;

        for (i = 0; i < length; i++) {
            if (charArr[i] == ' ') spaceCount++;
        }

        index = length + spaceCount * 2;

        for (i = length - 1; i >= 0; i--) {
            if (charArr[i] == ' ') {
                charArr[index - 1] = '0';
                charArr[index - 2] = '2';
                charArr[index - 3] = '%';
                index -= 3;
            } else {
                charArr[index - 1] = charArr[i];
                index--;
            }
        }

        return new String(charArr);

        /*StringBuilder sb = new StringBuilder();
        char[] stringContent = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (stringContent[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(stringContent[i]);
            }
        }
        return sb.toString();*/
    }
}
