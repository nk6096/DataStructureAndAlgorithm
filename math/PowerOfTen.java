/*Problem Statement-
        Returns true if x is a power-of-10. Otherwise returns false.
        Signature:
        bool isPowerOf10(int x){
        }
        Test Cases:
        INPUT:
        Input1: 3
        Output1: false
        Input1: 10
        Output1: true
*/

public class PowerOfTen {
    public static void main(String[] args) {
        System.out.println(isPowerOf10(100000));
    }

    public static boolean isPowerOf10(int x) {
        return (x % 10 == 0);
    }
}
