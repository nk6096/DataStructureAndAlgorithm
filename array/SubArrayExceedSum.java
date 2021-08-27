/*Problem Statement:
        Your task is ultimately to implement a function that takes in an array and a integer.
        You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
        and -1 if no such sum exists.

        Signature:

public static int subArrayExceedsSum(int arr[], int target) {
        }

        Test Cases:
        Input:[1,2,3,4] , k=6
        Output :2

        Input:[1,2,3,4] , k=-1
        Output :12*/

public class SubArrayExceedSum {
    public static void main(String[] args) {
        System.out.println(subArrayExceedsSum(new int[]{1, 2, 3, 4}, 6));
    }

    public static int subArrayExceedsSum(int[] arr, int target) {
        int n = arr.length;
        int right = 0, left = 0;
        int curr_sum = 0;
        int min_length = Integer.MAX_VALUE;
        while (right < n) {
            while (curr_sum < target && right < n) {
                curr_sum += arr[right++];
            }
            while (curr_sum >= target && left < n) {
                if (curr_sum >= target) {
                    if (min_length > right - left) {
                        min_length = right - left;
                    }
                }
                curr_sum -= arr[left++];
            }
        }

        if (min_length == Integer.MAX_VALUE)
            return -1;
        return min_length;
    }
}
