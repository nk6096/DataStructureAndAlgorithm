package com.example.demo.gs.string;
/*Problem Statement-
        This method should return an integer array with two elements that correctly identifies the location of the longest
        uniform substring within the input string. The first element of the array should be the starting index of the longest
        substring and the second element should be the length.

        input: “abbbccda" the longest uniform substring is “bbb” (which starts at index 1 and is 3 characters long.

        Signature :
        int[] longestUniformSubstring(String input) {
        }

        Test Cases –
        Input : aabbbbbCdAA
        Output – [2,5]*/

public class LongestUniformString {
    public static void main(String[] args) {
        int[] output = longestUniformSubstring("aabbbbbCdAA");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int num : output) {
            sb.append(num);
            sb.append(",");
        }
        sb.append("]");
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }

    static int[] longestUniformSubstring(String input) {
        int maxCount = 0;
        int s = 0, e = 0;
        for (int i = 0; i < input.length(); i++) {
            int start = i, end = i;
            int count = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                i++;
                count++;
            }
            end = i;
            if (count > maxCount) {
                maxCount = count;
                s = start;
                e = count;
            }
        }
        return new int[]{s, e};
    }
}
