/*Problem Statement-
        For a string input the function returns output encoded as follows:

        "a" -> "a1"
        "aa" -> "a2"
        "aabbb" -> "a2b3"
        "aabbbaa" -> "a2b3a2"

        Signature :
        String rle(String input) {
        }

        Test Case:
        Input : aaabbbaad
        Output: a3b3a2d1*/

public class LengthEncoding {
    public static void main(String[] args) {
        System.out.println(rle("aaabbbaad"));
    }

    static String rle(String input) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            ans.append(input.charAt(i));
            ans.append(count);
        }
        return ans.toString();
    }
}
