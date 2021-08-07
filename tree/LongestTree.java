package com.example.demo.gs.tree;
/*Problem statement:
        Given a forest ( one or more disconnected trees ), find the root of largest tree
        and return its Id. If there are multiple such roots, return the smallest Id of them.

        Complete the largestTree function in the editor below.
        It has one parameter, immediateParent, which is a map containing key-value pair indicating
        child -> parent relationship. The key is child and value is the corresponding
        immediate parent.
        Constraints
        Child cannot have more than one immediate parent.
        Parent can have more than one immediate child.
        The given key-value pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )

        Example:

        Input:
        {{1->2}, {3 -> 4} }

        Expected output: 2
        Explanation: There are two trees one having root of Id 2 and another having root of Id 4.
        Both trees have size 2. The smaller number of 2 and 4 is 2. Hence the answer is 2.

        Signature :
public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        }*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestTree {
    public static void main(String[] args) {

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 2);
        mp.put(3, 1);
        mp.put(4, 2);
        mp.put(5, 6);
        mp.put(7, 6);
        mp.put(8, 9);
        largestTree(mp);
    }

    public static void largestTree(final Map<Integer, Integer> immediateParent) {

        Map<Integer, ArrayList<Integer>> trees = new HashMap<>();

        Map<Integer, Integer> vertexCount = new HashMap<>();

        for (Map.Entry<Integer, Integer> es : immediateParent.entrySet()) {
            if (trees.containsKey(es.getValue())) {
                trees.get(es.getValue()).add(es.getKey());
            } else {
                final ArrayList<Integer> arr = new ArrayList<>();
                arr.add(es.getKey());
                trees.put(es.getValue(), arr);
            }

            if (!immediateParent.containsKey(es.getValue())) {
                vertexCount.put(es.getValue(), 0);
            }
        }

        for (Map.Entry<Integer, Integer> es : vertexCount.entrySet()) {
            vertexCount.put(es.getKey(), es.getValue() + DFS(es.getKey(), trees));
        }

        for (Map.Entry<Integer, Integer> es : vertexCount.entrySet()) {
            System.out.println("Parent : " + es.getKey() + " Value : " + es.getValue());
        }

        for (Map.Entry<Integer, ArrayList<Integer>> es : trees.entrySet()) {
            System.out.println("Parent : " + es.getKey() + " Value : " + es.getValue());
        }
    }

    private static Integer DFS(Integer root, Map<Integer, ArrayList<Integer>> trees) {
        Integer count = 1;
        if (trees.get(root) != null) {
            for (int i = 0; i < trees.get(root).size(); i++) {
                count += DFS(trees.get(root).get(i), trees);
            }
        }
        return count;
    }
}
