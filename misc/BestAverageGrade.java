package com.example.demo.gs.misc;
/*Problem Statement:
        Given a list of student test scores, find the best average grade.
        Each student may have more than one test score in the list.

        Complete the bestAverageGrade function in the editor below.
        It has one parameter, scores, which is an array of student test scores.
        Each element in the array is a two-element array of the form [student name, test score]
        e.g. [ "Bobby", "87" ].
        Test scores may be positive or negative integers.

        If you end up with an average grade that is not an integer, you should
        use a floor function to return the largest integer less than or equal to the average.
        Return 0 for an empty input.

        Example:

        Input:
        [ [ "Bobby", "87" ],
        [ "Charles", "100" ],
        [ "Eric", "64" ],
        [ "Charles", "22" ] ].

        Expected output: 87
        Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
        respectively. 87 is the highest.

        Signatue:

public static Integer bestAverageGrade(String[][] scores) {
        }

        Test Cases:

        Input :
        {{"Sarah", "91"},
        {"Goldie", "92"},
        {"Elaine", "93"},
        {"Elaine", "95"},
        {"Goldie", "94"},
        {"Sarah", "93"}}
        Output: 94*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {
    public static void main(String[] args) {
        final String[][] scores = new String[][]{{"Sarah", "91"},
                {"Goldie", "92"},
                {"Elaine", "93"},
                {"Elaine", "95"},
                {"Goldie", "94"},
                {"Sarah", "93"}};
        System.out.println(bestAverageGrade(scores));
    }

    public static Integer bestAverageGrade(final String[][] scores) {
        final var gradeMap = new HashMap<String, ArrayList<Integer>>();
        for (String[] score : scores) {
            final var studentName = score[0];
            gradeMap.putIfAbsent(studentName, new ArrayList<>());
            final ArrayList<Integer> studentScore = gradeMap.get(studentName);
            studentScore.add(Integer.parseInt(score[1]));
            gradeMap.put(studentName, studentScore);
        }

        int bestGrade = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : gradeMap.entrySet()) {
            ArrayList<Integer> v = entry.getValue();
            final int currSGrade = v.stream().mapToInt(s -> s).sum() / v.size();
            if (currSGrade > bestGrade) {
                bestGrade = currSGrade;
            }
        }

        return bestGrade;
    }
}
