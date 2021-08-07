package com.example.demo.gs.math;
/*Problem Statement-
        Given two fractions passed in as int arrays,
        returns the fraction which is result of adding the two input fractions
        Fraction is represented as a two-element array - [ numerator, denominator ]
        The returned fraction has to be in its simplest form.
        Signature:
        int[] addFractions ( int[] fraction1, int[] fraction2 ){
        }
        Test Cases:
        INPUT:
        fraction1 - [2, 3];
        fraction2 - [1, 2];
        OUTPUT: Hint-  {2/3 +1/2}
        result = [7,6]*/

public class AddFraction {
    public static void main(String[] args) {
        final int[] fraction = addFraction(new int[]{7, 1}, new int[]{5, 2});
        System.out.print("[");
        for (int i = 0; i < fraction.length; i++) {
            if (i == fraction.length - 1)
                System.out.print(fraction[i]);
            else
                System.out.print(fraction[i] + ",");
        }
        System.out.print("]");
    }

    private static int[] addFraction(int[] fraction1, int[] fraction2) {
        int num = fraction1[0] * fraction2[1] + fraction1[1] * fraction2[0];
        int den = fraction2[1] * fraction1[1];

        for (int i = (num > den ? den : num); i >= 2; i--) {
            if (num % i == 0 && den % i == 0) {
                num = num / i;
                den = den / i;
            }
        }

        return new int[]{num, den};
    }
}
