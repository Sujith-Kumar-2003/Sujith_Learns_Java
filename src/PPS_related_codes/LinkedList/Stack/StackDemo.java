package PPS_related_codes.LinkedList.Stack;
import java.util.Scanner;

class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Optional: Resize stack capacity
    public void resizeStack(int newCapacity) {
        if (newCapacity <= capacity) {
            System.out.println("New size must be greater than current capacity.");
            return;
        }

        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        capacity = newCapacity;
        System.out.println("Stack size increased to " + capacity);
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial size of the stack: ");
        int size = sc.nextInt();
        ArrayStack stack = new ArrayStack(size);

        System.out.println("Enter up to " + size + " space-separated values to push:");
        sc.nextLine(); // consume newline
        String[] input = sc.nextLine().split(" ");

        for (int i = 0; i < input.length && i < size; i++) {
            int val = Integer.parseInt(input[i]);
            stack.push(val);
        }

        stack.display();

    }
}