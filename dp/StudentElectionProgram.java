package com.example.demo.prc.dp;
/*Problem Statement:
        A group of student are sitting in a circle. The teacher is electing a new class president.
        The teacher does this by singing a song while walking around the circle. After the song is finished the student
        at which the teacher stopped is removed from the circle.
        Starting at the student next to the one that was just removed, the teacher resumes singing and walking around
        the circle.
        after the teacher is done singing, the next student is removed. The teacher repeats this until only one student
        is left.
        A song of length k will result in the teacher walking past k students on each round. The students are
        numbered 1 to n. The teacher starts at student 1.
        For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4).y
        The first student to go would be “2°, after that “4°, and after that ~3>.
        Student ~1° would be the next president in this example.

public static int whoIsElected(int n, int k) {
        }

        Test Cases:
        Input : 1, 1
        Output :1

        Input : 2, 2
        Output :1

        Input : 4, 2
        Output :1*/

public class StudentElectionProgram {
    public static void main(String[] args) {
        System.out.println(whoIsElected(4, 2));
    }

    public static int whoIsElected(final int n, final int k) {
        if (n == 1) {
            return 1;
        }

        final int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = i + 1;
        }
        int end = 0;
        int index = 0, count = 0;
        while (end != n - 1) {
            if (students[index] != 0) {
                count++;
                if (count == k) {
                    students[index] = -1;
                    count = 0;
                    end++;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }

        int president = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] != -1) {
                president = students[i];
                break;
            }
        }
        return president;
    }
}
