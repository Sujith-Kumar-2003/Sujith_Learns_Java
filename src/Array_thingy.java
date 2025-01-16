import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.lang.Math;

public class Array_thingy {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array in this format {row_size}  {column_size}:");
        int row_size = sc.nextInt();
        int col_size = sc.nextInt();
        int [][] arr = new int[row_size][col_size];

        Random rand = new Random();
        for (int i = 0; i < row_size;i++){
            for (int j = 0; j <col_size;j++){
                arr[i][j] = rand.nextInt(100);
            }
        }

        System.out.println("Array before swap:");
        for (int i = 0; i<row_size; i++){
            for (int j = 0; j < col_size; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i<row_size / 2; i++) {
            int [] temp = arr[i];
            arr[i] = arr[row_size-1 - i];
            arr[row_size - 1 -i] = temp;
        }

        System.out.println("Array after swap:");
        for (int i = 0; i<row_size; i++){
            for (int j = 0; j < col_size; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println(row_size + " " + col_size);
    }
}
