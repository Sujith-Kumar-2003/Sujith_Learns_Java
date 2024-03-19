package PPS_related_codes;

//Simple stack creation

import java.util.Scanner;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter space-separated integers to push onto the stack (e.g., 1 2 3): ");
        String inputLine = scanner.nextLine();
        String[] inputValues = inputLine.split(" ");

        // Pushing elements onto the stack
        for (String value : inputValues) {
            try {
                int intValue = Integer.parseInt(value);
                stack.push(intValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers separated by spaces.");
                return;
            }
        }

        // Printing the initial stack
        System.out.println("Initial Stack: " + stack);

        // Pop operation example
        if (!stack.isEmpty()) {
            System.out.println("Popping the top element: " + stack.pop());
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }

        // Peek operation example
        if (!stack.isEmpty()) {
            System.out.println("Top element of the stack: " + stack.peek());
        } else {
            System.out.println("Stack is empty. No top element to peek.");
        }

        // Printing the final stack
        System.out.println("Final Stack: " + stack);

        scanner.close();
    }
}
