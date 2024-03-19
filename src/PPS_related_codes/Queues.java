package PPS_related_codes;

//BASIC QUEUE IMPLEMENTTATION USING LINKED LIST

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    private Node front;
    private Node rear;

    public Main() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or throw an exception
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements separated by space to enqueue:");
        String inputLine = scanner.nextLine();
        String[] elements = inputLine.split(" ");

        Main queue = new Main();
        for (String element : elements) {
            queue.enqueue(Integer.parseInt(element));
        }

        System.out.println("Queue after enqueue:");
        queue.display();

        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Front element: " + queue.peek());

        System.out.println("Queue after dequeue:");
        queue.display();

        scanner.close();
    }
}

1 2 4 2 4 6


Circular queue IMPLEMENTATION USING LINKED LIST
import java.util.Scanner;

public class Main {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Main(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No elements to peek.");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int count = size;
        int i = front;
        while (count > 0) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
            count--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the circular queue: ");
        int capacity = scanner.nextInt();
        Main circularQueue = new Main(capacity);

        System.out.print("Enter elements separated by space to enqueue: ");
        String inputLine = scanner.nextLine(); // Consuming newline character
        inputLine = scanner.nextLine();
        String[] elements = inputLine.split(" ");

        for (String element : elements) {
            circularQueue.enqueue(Integer.parseInt(element));
        }

        System.out.print("Enter the number of elements to dequeue: ");
        int dequeueCount = scanner.nextInt();
        System.out.println("Dequeued elements:");
        for (int i = 0; i < dequeueCount; i++) {
            System.out.print(circularQueue.dequeue() + " ");
        }
        System.out.println();

        System.out.print("Front element: " + circularQueue.peek());

        System.out.println("\nQueue elements after dequeue:");
        circularQueue.display();

        scanner.close();
    }
}



Queue using arrays
import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Scanner scanner = new Scanner(System.in);

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedItem = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removedItem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    private void resize() {
        int newCapacity = queue.length * 2;
        queue = Arrays.copyOf(queue, newCapacity);
        if (rear < front) {
            System.arraycopy(queue, 0, queue, queue.length / 2, rear + 1);
            rear += queue.length / 2;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        ArrayQueue queue = new ArrayQueue(capacity);

        System.out.println("Enter elements to enqueue (one element per line, type 'done' when finished):");
        scanner.nextLine(); // Consume newline
        String input = scanner.nextLine();
        while (!input.equals("done")) {
            int item = Integer.parseInt(input);
            queue.enqueue(item);
            input = scanner.nextLine();
        }

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Peeked element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue elements:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
