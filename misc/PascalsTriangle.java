package com.example.demo.gs.misc;

/*Problem Statement:
        Pascals Triangle exhibits the following behaviour:

        The first and last numbers of each row in the triangle are 1
        Each number in the triangle is the sum of the two numbers above it.

        Example:
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
        1 6 15 20 15 6 1

        Please Complete the ‘pascal’ function below so that given a
        col and a row it will return the value in that position.

        Example, pascal(1,2) should return 2

        Signature:
public static int pascal(int col, int row){
        }

        Test Cases:

        Input : 0,0
        Output:1

        Input : 1,2
        Output:2

        Input : 4,8
        Output:70*/
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(pascal(4, 8));
    }

    public static int pascal(int col, int row) {
        final int n = Math.max(col, row);
        final int[][] pascals = new int[n + 1][n + 1];

        for (int i = 0; i < pascals.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == pascals[i].length - 1) {
                    pascals[i][j] = 1;
                } else {
                    pascals[i][j] = pascals[i - 1][j] + pascals[i - 1][j - 1];
                }
            }
        }

        return pascals[row][col];
    }
}
