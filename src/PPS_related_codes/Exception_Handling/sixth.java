package PPS_related_codes.Exception_Handling;

import java.util.Scanner;

public class sixth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            System.out.println("Please enter a valid integer:");
            String input = sc.nextLine();
            try {
                num = Integer.parseInt(input);
                System.out.println("You entered: " + num);
                break; // Exit loop when a valid integer is entered
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: '" + input + "' is not a valid integer. Please try again.");
            }
        }
        sc.close();
    }
}
