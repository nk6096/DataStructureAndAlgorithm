/*Problem Statement:
        Hermione is preparing a cheat-sheet for her final exam in Potions class.
        To create a potion, one must combine ingredients in a specific order, any of which may be repeated.
        As an example, consider the following potion which uses 4 distinct ingredients
        (A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D
        Hermione realizes she can save tremendous space on her cheat-sheet by introducing a
        special instruction, ‘*', which means “repeat from the beginning”.
        Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D
        Your job is to write a function that takes as input an un-encoded potion and returns the
        minimum number of characters required to encode the potion on Hermione’s Cheat Sheet.

        Signature:
private Integer minimalSteps(String ingredients) {
        }

        Test Case:
        Input: ABCDABCE
        Output:8

        Input: ABCABCE
        Output: 5*/

public class MagicPotion {
    public static void main(String[] args) {
        System.out.println(minimalSteps("ABCABCE"));
    }

    private static Integer minimalSteps(String ingredients) {
        int count = 1, left = 1;
        while (left < ingredients.length()) {
            if (ingredients.length() >= 2 * left && ingredients.charAt(0) == ingredients.charAt(left)) {
                if (ingredients.substring(0, left).equals(ingredients.substring(left, 2 * left))) {
                    left += left - 1;
                }
            }
            count++;
            left++;
        }
        return count;
    }
}
