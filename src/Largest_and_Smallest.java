import java.util.Scanner;
import java.util.Random;
public class Largest_and_Smallest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array[with rows and columns like 5 10]: ");
        int row = sc.nextInt();
        int column = sc.nextInt();

        int [][] arr = new int[row][column];
        int smallest = 0;
        int largest = 0;
        for (int i = 0; i<row; i++){
            for (int j = 0; j < column; j++){
                Random rand = new Random();
                arr[i][j] = rand.nextInt(100);

            }
        }

        for (int i = 0; i<row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] <= smallest){
                    smallest = arr[i][j];
                }
                if (arr[i][j] >= largest){
                    largest = arr[i][j];
                }

            System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The smallest number in the array is: " + smallest);
        System.out.print("The largest number in the array is: " + largest);
    }
}
