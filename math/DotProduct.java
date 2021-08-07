package com.example.demo.gs.math;
/*
Problem Statement-
        Given two arrays of integers, returns the dot product of the arrays.
        Signature:
        long dotProduct( int[] array1, int array2[] ){
        }
        Test Cases:           INPUT:
        array1 = [1, 2];
        array2 = [2, 3];
        OUTPUT: hint {1*2+2*3}
        Result =[8]
*/
public class DotProduct {
    public static void main(String[] args) {
        int[] array1 = {1,2};
        int[] array2 = {2,3};
        System.out.println(dotProduct(array1, array2));
    }
    public static long dotProduct(int[] arr1, int[] arr2) {
        long product = 0;
        for(int i = 0; i < arr1.length; i++) {
            product += arr1[i]*arr2[i];
        }
        return product;
    }
}
