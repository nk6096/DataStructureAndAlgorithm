package com.example.demo.prc.math;
/*Problem Statement-
        Given base and integer exponent, compute value of base raised to the power of exponent.

        Signature:
public static double power(double base, int exp) {
        }

        Test Cases:
        Input: 2.0
        4
        Output: 16.0*/

public class Exponent {
    public static void main(String[] args) {
        System.out.println(power(3.0,3));
    }

    private static double power(double base, int exp) {
        if (exp == 0)
            return 1.0;

        double result = base;
        for (int i = 0; i < exp - 1; i++) {
            result *= base;
        }
        return result;
    }

}
