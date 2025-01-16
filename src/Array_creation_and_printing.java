import java.util.Scanner;
import java.util.Random;
public class Array_creation_and_printing {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows and arrays: ");
        int row_size = sc.nextInt();
        int columns_size = sc.nextInt();

        System.out.println("Row size is: " + row_size + " " + "Row size is: " + columns_size);

        int[][] arr = new int[row_size][columns_size];
        Random rand = new Random();
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < columns_size; j++) {
                arr[i][j] = rand.nextInt(100) + 10; // 100 is the boundary from 0 to 99, +
                // 10 gives some more boundary + 10

            }
        }
        System.out.println("The generated array is:");
        for (int i=0; i<row_size;i++){
            for (int j =0; j<columns_size;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
