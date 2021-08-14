package com.example.demo.gs.misc;
/*Problem Statement:
        You are given an integer array of size N.
        Every element of the array is greater than or equal to 0.
        Starting from arr[startIndex], follow each element to the index it points to.
        Continue to do this until you find a cycle.
        Return the length of the cycle. If no cycle is found return -1
        Examples:
        Signature:
        Int countLengthOfCycle(arr, startIndex){
        }
        Test Cases:
        Input :
        arr: [1,0]
        startIndex: 0
        Output :2

        Input :
        arr: [1,2,0]
        startIndex: 0
        Output :2

        Input :
        arr: [1, 3, 0, 4, 1]
        startIndex: 0
        Output :3 */

public class CountLengthOfCycle {
    public static void main(String[] args) {
        System.out.print(countLengthOfCycle(new int[]{1, 3, 0, 4, 1}, 0));
    }

    public static int countLengthOfCycle(int[] arr, int startIndex) {
        int[] cycleElement = new int[arr.length];
        int idx = startIndex;
        while (cycleElement[idx] <= 1) {
            cycleElement[idx]++;
            idx = arr[idx];
        }
        int count = 0;
        for (int idxCount : cycleElement) {
            if (idxCount > 1) {
                count++;
            }
        }
        return count;

        //==================================================
        /*int index = startIndex, count = 0;

        int cycleCounter[] = new int[arr.length];

        while(cycleCounter[index] == 0){
            cycleCounter[index] = ++count;
            index = arr[index];
        }
        return count - cycleCounter[index];*/
    }
}
