/*Problem Statement –
        Given two words returns the shortest distance between their two midpoints in number of characters,
          words can appear multiple times in any order and should be case insensitive.
        Signature :
public static double shortestDistance(String document, String word1, String word2) {
        }
        Test Cases:
        String Document – “In publishing and graphic design,
        lorem ipsum is a filler text commonly used to demonstrate the graphic elements”.

        shortestDistance( document, "is", "a" ) == 2.5
*/

public class DistanceBetweenString {
    public static void main(String[] args) {
        final String document = "In publishing and graphic design,"
                + " lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        System.out.println(shortestDistance(document, "is", "a"));
    }

    public static double shortestDistance(String document, String word1, String word2) {
        String[] words = document.split(" ");
        double dist1 = 0, dist2 = 0;
        double dist = 0;
        double minDist = document.length() + 1;
        for (String word : words) {
            if (word.equals(word1)) {
                dist1 = dist + (word.length() / 2d);
            } else if (word.equals(word2)) {
                dist2 = dist + (word.length() / 2d);
            }
            if (dist1 > 0 && dist2 > 0) {
                double currDist = Math.abs(dist1 - dist2);
                if (currDist < minDist) {
                    minDist = currDist;
                }
            }
            dist += word.length() + 1;
        }
        return minDist;
    }
}
