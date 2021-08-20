package com.example.demo.prc.string;

public class PossiblePalindrome {
    public static void main(String[] args) {
        System.out.println(checkPossiblePalindrome("abebea"));
    }

    public static String checkPossiblePalindrome(String input) {
        int lo = 0, hi = input.length() - 1;
        while (lo < hi) {
            if (input.charAt(lo) != input.charAt(hi)) {
                if (isPalindrome(input, lo, hi - 1)) {
                    return "Is Possible Palindrome";
                }

                if (isPalindrome(input, lo + 1, hi)) {
                    return "Is Possible Palindrome";
                }
                return "Not Possible Palindrome";
            }
            lo++;
            hi--;
        }
        return "Is Palindrome";
    }

    public static boolean isPalindrome(String input, int left, int right) {
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
