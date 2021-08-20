package com.example.demo.prc.dp;
/*Problem Statement:
        You are an avid rock collector who lives in southern California. Some rare
        and desirable rocks just became available in New York, so you are planning
        a cross-country road trip. There are several other rare rocks that you could
        pick up along the way.

        You have been given a grid filled with numbers, representing the number of
        rare rocks available in various cities across the country. Your objective
        is to find the optimal path from So_Cal to New_York that would allow you to
        accumulate the most rocks along the way.

        Note: 1) You can only travel either north (up) or east (right).
        2) Consider adding some additional tests in doTestsPass().
        3) Implement optimalPath() correctly.
        4) Here is an example:
        ^
        {{0, 0, 0, 0, 5}, New_York (finish)      N
        {0, 1, 1, 1, 0},                    < W   E >
 So_Cal (start)  {2, 0, 0, 0, 0}}                        S
         v
         The total for this example would be 10 (2 + 0 + 1 + 1 + 1 + 0 + 5).

         Signature:
public static Integer optimalPath(Integer[][] grid) {
        }

        Test Cases:
        Input :
        {{0, 0, 0, 0, 5},
        {0, 1, 1, 1, 0},
        {2, 0, 0, 0, 0}};
        Output: 10*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimalPath {
    static class Employee {
        private String name;
        private Integer salary;
        Employee(String name, Integer salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        final Integer[][] grid = new Integer[][]{{}};
        System.out.println(optimalPath(grid));
    }

    public static Integer optimalPath(Integer[][] grid) {
        int n = grid.length, m = grid[0].length;
        final int[][] dp = new int[n][m];
        return getPath(dp, grid, n - 1, 0, n, m);
    }

    private static Integer getPath(int[][] dp, Integer[][] grid, int x, int y, int n, int m) {
        if (x < 0 || y > m - 1) {
            return 0;
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        return dp[x][y] = grid[x][y] +
                Math.max(getPath(dp, grid, x - 1, y, n, m), getPath(dp, grid, x, y + 1, n, m));
    }
}
