package com.example.demo.gs.string;
/*Problem Statement –
        Finds the first character that does not repeat anywhere in the input string
        If all characters are repeated, return 0
        Given “apple”, the answer is “a”
        Given “racecars”, the answer is “e"

        Signature :
        char findFirst(String input){
        }

        Test Cases-
        Input: apple
        Output: a

        Input – xxyyzz
        Output - 0*/

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println(findFirst("apjepale"));
    }

    static char findFirst(String input){
        int[] arr = new int[256];
        for(int i = 0; i < input.length(); i++) {
            arr[input.charAt(i)]++;
        }

        for(int i = 0; i < input.length(); i++) {
           if (arr[input.charAt(i)] == 1) {
               return input.charAt(i);
           }
        }
        // TC : O(n)
        return '0';
    }
}
