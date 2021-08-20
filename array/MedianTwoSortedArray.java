package com.example.demo.prc.array;
/*Problem Statement:
        Find the median of the two sorted arrays

        Signature:
public static double findMedianSortedArrays(int[] A, int[] B) {
        }

        Test Cases:
        Input:
        Arr1= [1,3];
        Arr2 = [2,4];
        Output:
        2.5

        Input:
        Arr1 = [1,3]
        Arr2= [2]
        Output:2.0*/

public class MedianTwoSortedArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2,4}));
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        final int n = A.length, m = B.length;
        int mid = 0, mid1 = 0;
        int i = 0, j = 0;

        if ((m + n) % 2 == 0) {
            for (int l = 0; l <= (n + m) / 2; l++) {
                mid1 = mid;
                if (n != i && m != j) {
                    mid = A[i] > B[j] ? B[j++] : A[i++];
                } else if (i < n) {
                    mid = A[i];
                    i++;
                } else {
                    mid = B[j];
                    j++;
                }
            }
            return (mid + mid1) / 2d;
        } else {
            for (int l = 0; l <= (n + m) / 2; l++) {
                if (n != i && m != j) {
                    mid = A[i] > B[j] ? B[j++] : A[i++];
                } else if (i < n) {
                    mid = A[i];
                    i++;
                } else {
                    mid = B[j];
                    j++;
                }
            }
            return mid;
        }
    }
}
