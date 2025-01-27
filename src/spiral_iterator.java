import java.util.Scanner;
import java.util.Random;
public class spiral_iterator {

    public static void spiral_maker(int[][] arr) {
        int size = arr.length;
        int top = 0, bottom = size - 1;
        int left = 0, right = size - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int size = sc.nextInt();
        int [][] arr = new int[size][size];

        for (int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                arr[i][j] = rand.nextInt(100);
            }
        }

        for (int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
        spiral_maker(arr);

    }
}
