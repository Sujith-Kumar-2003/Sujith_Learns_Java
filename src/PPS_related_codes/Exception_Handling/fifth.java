package PPS_related_codes.Exception_Handling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class fifth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;

        while (true) {
            System.out.println("Enter a number between 1 and 10:");
            try {
                k = sc.nextInt();
                if (k >= 1 && k <= 10) {  // Valid range check
                    System.out.println("The code is good");
                    break;
                } else {
                    throw new InputMismatchException("The number is out of range. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: Only integers are allowed. Please try again.");
                sc.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }
        System.out.println("The code completed");
        sc.close();
    }
}
