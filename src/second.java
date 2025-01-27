import java.util.Scanner;
import java.util.*;

public class second {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the numbers with space seperated ");

        int [][] numArray = new int [10][];
        int rowCount = 0;


        while(true){
            String input = sc.nextLine().trim();
            if (input.isEmpty()){
                break;
            }
            String [] nums = input.split(" ");
            int [] new_array  = new int[nums.length];

            for (int i = 0; i < new_array.length; i++){
                new_array[i] = Integer.parseInt(nums[i]);

            }
            numArray[rowCount] = new_array;
            rowCount++;

            if (rowCount == numArray.length){
                numArray = Arrays.copyOf(numArray, numArray.length * 2);
            }
        }
        System.out.println("The 2d array is ");
        for (int i = 0; i < rowCount; i ++){
            for ( int j =0; j < numArray.length;j++){
                System.out.print(numArray[i][j] + " ");

            }
            System.out.println();
        }

    }

}
