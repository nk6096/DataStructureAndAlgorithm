package com.example.demo.prc.string;
/*Problem Statement:
        Given a list of words, group them by anagrams
        Input: List of "cat", "dog", "god"
        Output: A Set of Sets of anagrams: {{‘cat'}, {‘dog', ‘god'}}

        Signature : Set<Set<String>> group(List<String> words){
        }

        Test Cases –
        Input : ["cat", "dog", "god"]
        Output: [[“cat”],[“dog”,”god”]]*/

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(group(Arrays.asList("cat", "dog", "god")));
    }

    static Set<Set<String>> group(List<String> words){
        Set<Set<String>> ans = new HashSet<>();
        Map<String, HashSet<String>> map = new HashMap<>();
        for (String word : words) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            map.putIfAbsent(new String(charArr), new HashSet<>());// act - 0, gdo - 1,2
            map.get(new String(charArr)).add(word);
        }
        for (Map.Entry<String, HashSet<String>> key : map.entrySet()) {
            ans.add(key.getValue());
        }// car, [dog,god]
        return ans;
    }
}
