import java.util.Scanner;
import java.util.Random;

public class first_one {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter rows of numbers separated by spaces (e.g., 1 2 4). Enter an empty line to finish:");

        int[][] numArray = new int[10][];
        int rowCount = 0;

        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            String[] inputNums = input.split(" ");
            int[] numRow = new int[inputNums.length];

            for (int i = 0; i < inputNums.length; i++) {
                numRow[i] = Integer.parseInt(inputNums[i]);
            }

            numArray[rowCount] = numRow;
            rowCount++;

            if (rowCount == numArray.length) {
                numArray = java.util.Arrays.copyOf(numArray, numArray.length * 2);
            }
        }

        System.out.println("You entered the following 2D array:");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < numArray[i].length; j++) {
                System.out.print(numArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
