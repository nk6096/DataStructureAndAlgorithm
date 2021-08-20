package com.example.demo.prc.dp;
/*Problem Statement:
        There is a staircase with ‘n' number of steps. A child
        walks by and wants to climb up the stairs, starting at
        the bottom step and ascending to the top.
        Of course, the child wants to have fun, too, so instead
        of taking 1 step at a time, it will vary between taking
        either 1, 2 or 3 steps at a time.
        Please complete the ‘countSteps' method below so that
        given 'n' number of steps it will return the number of
        unique combinations the child could traverse.
        An example would be countSteps(3) == 4:

        Signature :
public static Integer countSteps(Integer n) {
        }

        Test Cases:
        Input : 3
        Output: 4

        Input : 1
        Output: 1

        Input : 2
        Output: 2

        Input : 10
        Output: 274

        Input : -5
        Output: 0*/

public class StairCase {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Rec " + countSteps(n));
        System.out.println("Mem " + countStepsMem(n, new int[n + 1]));
        System.out.println("Tab " + countStepsTab(n));
    }

    public static Integer countSteps(Integer n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        int x = countSteps(n - 1);
        int y = countSteps(n - 2);
        int z = countSteps(n - 3);

        return x + y + z;
    }

    public static Integer countStepsMem(Integer n, int[] dp) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        int x = countStepsMem(n - 1, dp);
        int y = countStepsMem(n - 2, dp);
        int z = countStepsMem(n - 3, dp);

        return dp[n] = x + y + z;
    }

    public static Integer countStepsTab(final Integer n) {
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 == 0) {
                dp[i] = dp[i - 1];
            } else if (i - 2 == 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
}
