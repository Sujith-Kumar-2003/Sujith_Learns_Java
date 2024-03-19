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


// JUST EXTRA METHODS IN xSTACK.

import java.util.Scanner;
import java.util.Stack;

public class Main {
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

        // Search operation example
        System.out.println("Enter an element to search in the stack: ");
        int searchElement = scanner.nextInt();
        int position = stack.search(searchElement);
        if (position != -1) {
            System.out.println("Element found at position: " + position);
        } else {
            System.out.println("Element not found in the stack.");
        }

        // Size of the stack
        System.out.println("Size of the stack: " + stack.size());

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Printing the final stack
        System.out.println("Final Stack: " + stack);

        scanner.close();
    }
}

///Oops im not allowed to use Stack i shoukld only use primitive arrays
//
//
//Stack USING ARRAYS
import java.util.Scanner;

public class Main {
    private static final int MAX_SIZE = 100; // Maximum size of the stack
    private static int[] stack = new int[MAX_SIZE];
    private static int top = -1; // Top of the stack

    // Push operation
    private static void push(int value) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack overflow. Cannot push more elements.");
        } else {
            top++;
            stack[top] = value;
            System.out.println("Pushed element: " + value);
        }
    }

    // Pop operation
    private static void pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
        } else {
            System.out.println("Popped element: " + stack[top]);
            top--;
        }
    }

    // Peek operation
    private static void peek() {
        if (top == -1) {
            System.out.println("Stack is empty. No top element to peek.");
        } else {
            System.out.println("Top element of the stack: " + stack[top]);
        }
    }

    // Check if stack is empty
    private static boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    private static boolean isFull() {
        return (top == MAX_SIZE - 1);
    }

    // Size of the stack
    private static int size() {
        return top + 1;
    }

    // Search operation
    private static int search(int value) {
        for (int i = top; i >= 0; i--) {
            if (stack[i] == value) {
                return top - i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter space-separated integers to push onto the stack (e.g., 1 2 3): ");
        String inputLine = scanner.nextLine();
        String[] inputValues = inputLine.split(" ");

        // Pushing elements onto the stack
        for (String value : inputValues) {
            try {
                int intValue = Integer.parseInt(value);
                push(intValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers separated by spaces.");
                return;
            }
        }

        // Printing the initial stack
        System.out.print("Initial Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();

        // Pop operation example
        if (!isEmpty()) {
            pop();
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }

        // Peek operation example
        peek();

        // Search operation example
        System.out.println("Enter an element to search in the stack: ");
        int searchElement = scanner.nextInt();
        int position = search(searchElement);
        if (position != -1) {
            System.out.println("Element found at position: " + position);
        } else {
            System.out.println("Element not found in the stack.");
        }

        // Size of the stack
        System.out.println("Size of the stack: " + size());

        // Check if stack is empty
        System.out.println("Is stack empty? " + isEmpty());

        scanner.close();
    }
}


//STACK 1 - STACK WIUTH BOTH VAR AND INT - NORMAL PUSH POP SIZE

public class Main {

    String[] str;
    int top;
    Main() {
        str = new String[10];
        top = -1;
    }

    public void push(String val) {
        if(str.length -1 == top) {
            expand();
        }
        top++;
        str[top] = val;
    }

    public String pop() {
        if(top == -1) {
            return "Empty Stack";
        }

        return str[top--];
    }

    public String top() {
        if(top == -1) {
            return "Empty Stack";
        }
        return str[top];
    }

    public int size() {
        if(top == -1) return 0;
        return top+1;
    }

    private void expand() {
        String[] arr = new String[2*str.length];
        int i=0;
        for(String st : str) {
            arr[i++] = st;
        }
        str = arr;
    }

    public static void main(String[] args) {
        Main stack = new Main();
        for(int i=0; i<10; i++)
            stack.push("Hello"+(i+1));
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.size());
        for(int i=10; i<50; i++)
            stack.push("Hello"+(i+1));
        System.out.println(stack.top());
        System.out.println(stack.size());
    }

}

//OUTPUT = Hello10
//Hello9
//9
//Hello50
//49


 STACK _2 ASCENDIGN ORDER STAKC MAKER = Maybe take some from the real one
import java.util.Scanner;

public class Main {

    int[] str;
    int top;

    Main() {
        str = new int[10];
        top = -1;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(str[i] + " ");
        }
    }

    public void push(int val) {
        if (top == -1 || str[top] <= val) {
            top++;
            str[top] = val;
        }
    }

    public Integer pop() {
        if (top == -1) {
            return -1;
        }
        return str[top--];
    }

    public Integer top() {
        if (top == -1) {
            return -1;
        }
        return str[top];
    }

    public int size() {
        if (top == -1) return 0;
        return top + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String va[] = line.split(" ");
        int c = 0;
        Main st = new Main();
        for (String value : va) {
            st.push(Integer.parseInt(value));
        }
        st.print();
    }

}




//Postfix Codeign problem - STACK 3
import java.util.Scanner;

public class Main {
    String[] str;
    int top;
    Main() {
        str = new String[10];
        top = -1;
    }

    public void push(String val) {
        if(str.length -1 == top) {
            expand();
        }
        top++;
        str[top] = val;
    }

    public String pop() {
        if(top == -1) {
            return "Empty Stack";
        }

        return str[top--];
    }

    public String top() {
        if(top == -1) {
            return "Empty Stack";
        }
        return str[top];
    }

    public int size() {
        if(top == -1) return 0;
        return top+1;
    }

    private void expand() {
        String[] arr = new String[2*str.length];
        int i=0;
        for(String st : str) {
            arr[i++] = st;
        }
        str = arr;
    }
    public static void main(String args[]) {
        String str = "";
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        String arr[] = str.split(" ");
        Main st = new Main();
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("/") || arr[i].equals("*")) {
                int val1 = Integer.parseInt(st.pop());
                int val2 = Integer.parseInt(st.pop());
                if(arr[i].equals("+")) st.push(val1+val2+"");
                if(arr[i].equals("-")) st.push(val2-val1+"");
                if(arr[i].equals("/")) st.push((val2/val1)+"");
                if(arr[i].equals("*")) st.push((val1*val2)+"");
            }else {
                st.push(arr[i]);
            }
        }
        System.out.println(st.pop());
    }
}






