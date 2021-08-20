package com.example.demo.prc.string;
/*Problem Statement-
        The sentence “The quick brown fox jumps over the lazy dog" contains
        every single letter in the alphabet. Such sentences are called pangrams.
        write a function findMissingLetters, which takes a String “sentence,
        and returns all the letters it is missing (which prevent it from
        being a pangram). You should ignore the case of the letters in sentence,
        and your return should be all lower case letters, in alphabetical order.
        you should also ignore all non US-ASCII characters.

        Signature:

        String findMissingLetters(String sentence) {
        }

        Test Cases:
        Input: The slow purple oryx meanders past the quiescent canine
        Output: bfgjkvz*/

public class Pangrams {
    public static void main(String[] args) {
        System.out.println(findMissingLetters("The slow purple oryx meanders past the quiescent canine"));
    }

    static String findMissingLetters(String sentence) {
        int[] arr = new int[256];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            arr[sentence.charAt(i)]++;
        }

        for (int i = 65; i <= 90; i++) {
            if (arr[i] == 0 && arr[i + 32] == 0) {
                ans.append((char) (i + 32));
            }
        }

        return ans.toString();
    }
}
