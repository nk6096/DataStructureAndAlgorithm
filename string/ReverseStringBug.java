/*Problem Statement :
        Takes String str and returns a new String
        such that the characters are in reversed order.
        Example: reverseStr(str) where str is “abcd " returns “dcba".

        Signature: public static String reverseStr( String str ){
        }

        Test Cases:
        Input : abcd
        Output: dcba
        */

public class ReverseStringBug {
    public static void main(String[] args) {
        System.out.println(reverseStr("/gH?yZx"));
    }

    public static String reverseStr(String str) {
        char[] charArr = str.toCharArray();
        int l = 0, r = charArr.length - 1;

        while (l < r) {
            if (Character.isAlphabetic(charArr[l]) && Character.isAlphabetic(charArr[r])) {
                char temp = charArr[r];
                charArr[r] = charArr[l];
                charArr[l] = temp;
                l++;
                r--;
            } else if (Character.isAlphabetic(charArr[l])) {
                r--;
            } else if (Character.isAlphabetic(charArr[r])) {
                l++;
            } else {
                l++;
                r--;
            }
        }

        return new String(charArr);
    }
}
