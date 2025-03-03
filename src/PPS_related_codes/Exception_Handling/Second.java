package PPS_related_codes.Exception_Handling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Second {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int k;

        while(true){
            try{
                System.out.println("Enter a number between 1 and 10:");
                k = sc.nextInt();
                if (k >= 1 && k <= 10){  // Using <= 10 to include 10 in the valid range.
                    System.out.println("The code is good");
                    break;
                }
                else{
                    System.out.println("The number is out of range. Please try again.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("The value you entered is not a valid number. Please try again.");
                sc.nextLine(); // Clear the invalid input from the scanner buffer.
            }
        }
        System.out.println("The code completed");
        sc.close();
    }
}
