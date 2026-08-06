import java.util.Arrays;

public class Leetcode1710 {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int total = 0;
        for (int[] box : boxTypes) {

            int noBoxes = box[0];   
            int unitBox = box[1];   
            int boxesTaken = Math.min(noBoxes, truckSize);
            total += boxesTaken * unitBox;

            truckSize -= boxesTaken;

            if (truckSize == 0) {
                break;
            }
        }

        return total;
    }
}