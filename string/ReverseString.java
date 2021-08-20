package com.example.demo.prc.string;
/*Problem Statement :
        Takes String str and returns a new String
        such that the characters are in reversed order.
        Example: reverseStr(str) where str is “abcd " returns “dcba".

        Signature: public static String reverseStr( String str ){
        }

        Test Cases:
        Input : abcd
        Output: dcba*/

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcd"));
    }

    public static String reverseStr(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
