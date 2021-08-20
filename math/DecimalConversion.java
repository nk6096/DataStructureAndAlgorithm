package com.example.demo.prc.math;
/*Problem Statement:
        Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.
        Some fractions in decimal form have cyclic decimal points.
public static String vulgarToDecimal(Long numerator, Long denominator) {
        }
        Test Cases:
        vulgarToDecimal(1l, 2l).equals("0.5");
        vulgarToDecimal(1l, 3l).equals("0.(3)");
        vulgarToDecimal(1l, 30l).equals("0.0(3)");
        vulgarToDecimal(1l, 75l).equals("0.01(3)");
        vulgarToDecimal(4l, 7l).equals("0.(571428)");*/

import java.util.HashMap;

public class DecimalConversion {
    public static void main(String[] args) {
        System.out.println(vulgarToDecimal(4,7));
    }

    private static String vulgarToDecimal(final int num, final int den) {
        int q = num/den;
        int r = num%den;
        final StringBuilder ans = new StringBuilder();
        final HashMap<Integer, Integer> map = new HashMap<>();
        ans.append(q);
        if (r == 0) {
            return ans.toString();
        } else {
            ans.append(".");
            while (r != 0) {
                if (map.containsKey(r)) {
                    final int idx = map.get(r);
                    ans.insert(idx, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(r, ans.length());
                    r *= 10;
                    q = r/den;
                    r = r%den;
                    ans.append(q);
                }
            }
        }
        return ans.toString();
    }
}
