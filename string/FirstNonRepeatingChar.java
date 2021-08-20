package com.example.demo.prc.string;
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
        int[] arr = new int[26];
        for(int i = 0; i < input.length(); i++) {
            arr[input.charAt(i)%97]++;
        }

        int k = 1;
        char ans = '0';
        for(int i = 0; i < input.length(); i++) {
           if (arr[input.charAt(i)%97] == 1 && k <= 3) {
               if (k == 3) {
                   ans = input.charAt(i);
                   break;
               }
               k++;
           }
        }
        // TC : O(n)
        return ans;
    }
}
