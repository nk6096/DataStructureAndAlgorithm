package com.example.demo.gs.misc;
/*Problem Statement:
        Given a string and size of the tuples, extracts all unique tuples(substrings) of the given size.

        Signature:

        HashSet<String> uniqueTuples( String input, int len ){
        }

        Test Cases:
        Input : abbccde, 2
        Output :
        ["ab"
        "bb",
        "bc",
        "cc",
        "cd",
        "de"]*/

import java.util.HashSet;

public class UniqueTuples {
    public static void main(String[] args) {
        System.out.println(uniqueTuples("abbccde", 2));
    }

    public static HashSet<String> uniqueTuples(String input, int len) {
        final var ans = new HashSet<String>();
        for (int i = 0; i <= input.length() - len; i++) {
            ans.add(input.substring(i, len + i));
        }
        return ans;
    }
}
