package com.example.demo.gs.math;
/*
Problem Statement:
        Return an array containing prime numbers whose product is x
        Examples:
        primeFactorization( 6 ) == [2,3]
        primeFactorization( 5 ) == [5]
        primeFactorization( 12 ) == [2,2,3]
        Signature:
public static ArrayList<Integer> primeFactorization(int x) {
        }
        Test Cases- Input: 6
        Output:[2,3]
*/

import java.util.ArrayList;

public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println(primeFactorization(46));
    }

    private static ArrayList<Integer> primeFactorization(int x) {
        final ArrayList<Integer> list = new ArrayList<>();
        for (int div = 2; div*div <= x; div++) {
            while (x % div == 0) {
                x = x/div;
                list.add(div);
            }
        }
        if (x != 1) {
            list.add(x);
        }
        return list;
    }
}
