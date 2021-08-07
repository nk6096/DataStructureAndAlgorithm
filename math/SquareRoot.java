package com.example.demo.gs.math;
/*Problem Statement-
        Returns square root of the given double
        Signature:
        double squareRoot( double x ){
        }
        Test Cases:
        Input1: 4
        Ouput1:2
        Input2:2
        Output2: 1.41421*/

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(2.0, 0, 2));
    }

    private static double squareRoot(double x, int left, int right) {
        if (x < 2) {
            return x;
        }

        int mid = (left + right)/2;

        if (mid*mid == x) {
            return mid;
        }

        if (mid*mid < x && (mid+1)*(mid+1) > x) {
            return mid;
        }

        if (mid*mid > x){
            return squareRoot(x, left, mid);
        } else {
            return squareRoot(x, mid, right);
        }

    }
}
