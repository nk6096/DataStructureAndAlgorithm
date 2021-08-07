package com.example.demo.gs.string;
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
        List<String> newWords = words.stream()
                .map(String::toCharArray)
                .map(chars -> {Arrays.sort(chars); return new String(chars);})
                .collect(Collectors.toList());

        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < newWords.size(); i++) {
            map.putIfAbsent(newWords.get(i), new ArrayList<>());// act - 0, gdo - 1,2
            map.get(newWords.get(i)).add(i);
        }

        for (String key : map.keySet()) {
            ans.add(map.get(key).stream().map(words::get).collect(Collectors.toSet()));
        }// car, [dog,god]

        return ans;
    }
}
