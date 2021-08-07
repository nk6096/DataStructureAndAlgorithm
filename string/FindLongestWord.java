package com.example.demo.gs.string;
/*Problem Statement-
        Given a string of letters and a dictionary, the function longestWord should
        find the longest word or words in the dictionary that can be made from the letters
        Input: letters = "oet", dictionary = {"to","toe","toes"}
        Output: {"toe"}
        Only lowercase letters will occur in the dictionary and the letters
        The length of letters will be between 1 and 10 characters
        The solution should work well for a dictionary of over 100,000 words

        Signature- Set<String> longestWord(String letters, Dictionary dictionary) {
        }

        Test Cases-
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
        Input- toe
        Output- toe

        Input – oetdg
        Output- "doe", "toe", "dog", "god"*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestWord {
    public static void main(String[] args) {
        String[] dict = new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"};
        System.out.println(longestWord("oetdg", dict));
    }

    static Set<String> longestWord(String letters, String[] dictionary) {
        boolean[] arr = new boolean[256];
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            arr[letters.charAt(i)] = true;
        }
        int count = 0;

        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                if (!arr[word.charAt(i)]) {
                    break;
                } else if (word.length() == i + 1) {
                    if (count < word.length()) {
                        count = word.length();
                    }
                    map.putIfAbsent(word.length(), new HashSet<>());
                    map.get(word.length()).add(word);
                }
            }
        }

        return map.get(count);
    }
}
