import java.util.Random;
import java.util.Scanner;

public class third {

    public static void SpiralIterator(int[][] arr) {
        int top = 0, bottom = arr.length - 1;
        int left = 0, right = arr[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int row_size = sc.nextInt();
        int col_size = sc.nextInt();

        int[][] arr = new int[row_size][col_size];

        // Fill the array with random numbers
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                arr[i][j] = rand.nextInt(100); // Random numbers between 0-99
            }
        }

        // Display the matrix
        System.out.println("Generated Matrix:");
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Print the matrix in spiral order
        System.out.println("Spiral Order:");
        SpiralIterator(arr);
    }
}
