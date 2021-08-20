package com.example.demo.prc.dp;
/*Problem Statement:
        Implement the ‘walk" method. This method takes in a string, path,
        where each character in the string corresponds to a potential movement
        of the robot. The robot can move up, down, left, and right represented
        by the characters ‘U', 'D', "L', and 'R' respectively. All other
        characters may be ignored. Assume the robot's initial position
        is at (0,0). The output of this method is the robot's final x and y
        coordinates relative to the initial position
        Signature:
public static Integer[] walk(String path) {
        }

        Test Cases:

        Input: “”(Blank)
        Output: [0,0]


        Input: “L”
        Output: [-1,0]

        Input: “UUU”
        Output: [0,3]

        Input: “ULDR”
        Output: [0,0]*/

public class WalkingRobot {

    public static void main(String[] args) {
        final StringBuilder ans = new StringBuilder();
        ans.append("[");
        for (Integer idx : walk("LLLUUU")) {
            ans.append(idx).append(",");
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.append("]");
        System.out.print(ans.toString());
    }

    public static Integer[] walk(final String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'U':
                    y++;
                    break;
                case 'R':
                    x++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                default:
                    break;
            }
        }
        return new Integer[]{x, y};
    }
}
