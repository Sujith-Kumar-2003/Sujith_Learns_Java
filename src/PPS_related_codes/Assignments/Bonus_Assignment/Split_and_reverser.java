package PPS_related_codes.Assignments.Bonus_Assignment;
import java.util.*;

public class Split_and_reverser {

    public static void reverser(int[] arr, int splits) {
        int baseSize = arr.length / splits;
        int remainder = arr.length % splits;

        int startIndex = 0;

        for (int i = 0; i < splits; i++) {
            int currentSplitSize = baseSize;
            if (i < remainder) {
                currentSplitSize += 1;
            }

            int[] subArray = new int[currentSplitSize];
            for (int j = 0; j < currentSplitSize; j++) {
                subArray[j] = arr[startIndex + j];
            }


            // Reverse the split
            reverseArray(subArray);


            // Write reversed subarray back to original array
            for (int j = 0; j < currentSplitSize; j++) {
                arr[startIndex + j] = subArray[j];
            }


            startIndex += currentSplitSize;
        }

        System.out.print("Final full array after all splits reversed: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void reverseArray(int[] subArray) {
        int left = 0;
        int right = subArray.length - 1;

        while (left < right) {
            int temp = subArray[left];
            subArray[left] = subArray[right];
            subArray[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the array element: ");
        String[] line = sc.nextLine().split(" ");
        int[] arr = new int[line.length];

        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        System.out.print("Enter number of splits: ");
        int splits = sc.nextInt();

        if (splits <= 0 || splits > arr.length) {
            System.out.println("Invalid number of splits.");
            return;
        }

        reverser(arr, splits);
    }
}


// I had the diffculty on how to loop and print each, adn reverse in just a single loop reather than crearting new arrays and do it alone.
