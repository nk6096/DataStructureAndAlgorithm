package com.example.demo.gs.misc;
/*Problem Statement:
        Given an array of non-negative integers representing the elevations
        from the vertical cross-section of a range of hills, determine how
        many units of snow could be captured between the hills.

        See the example array and elevation map below.
        ___
        ___                |   |        ___
        |   |        ___    |   |___    |   |
        *        ___|   |    ___|   |   |   |   |   |   |
        ___|___|___|___|___|___|___|___|___|___|___|___
        { 0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0 }

        ___
        ___                |   |        ___
        |   | *   *  _*_  * |   |_*_  * |   |
        *        ___|   | *  _*_|   | * |   |   | * |   |
        ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
        { 0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0 }

        Solution: In this example 13 units of snow (*) could be captured.

        Signature: public static Integer computeSnowpack(Integer[] arr) {
        }
        Test Cases:
        Input : {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}
        Output: 13

        Input : {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        Output:10*/

public class Snowpack {
    public static void main(String[] args) {
        System.out.println(computeSnowpack(new Integer[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));
    }

    public static Integer computeSnowpack(final Integer[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        int currMax = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currMax) {
                currMax = arr[i];
            }
            leftMax[i] = currMax;
        }
        currMax = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > currMax) {
                currMax = arr[i];
            }
            rightMax[i] = currMax;
        }

        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return sum;
    }
}
