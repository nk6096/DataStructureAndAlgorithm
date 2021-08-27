/*Problem Statement-
        Returns second smallest element in array x. If x has fewer than 2 elements returns 0.

        Signature:
        int secondSmallest(int[] x)

        Test Cases:
        Input:[ -1, 0, 1, -2, 2]
        Output: -1

        Input:[ 0, 1]
        Output: 1*/

public class SecondSmallestNumber {
    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{-1, 0, -2, 1, 2, 2}));
    }

    static int secondSmallest(int[] x) {
        if (x.length < 2) {
            return 0;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < first) {
                second = first;
                first = x[i];
            } else if (second > x[i] && x[i] != first) {
                second = x[i];
            }
        }
        return second;
    }
}
