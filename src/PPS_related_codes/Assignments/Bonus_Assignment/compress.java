package PPS_related_codes.Assignments.Bonus_Assignment;

import java.util.*;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void compresser(int targetCount) {
        if (head == null) return;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;

        while (current != null) {
            Node runner = current;
            int count = 1;

            while (runner.next != null && runner.next.value == current.value) {
                runner = runner.next;
                count++;
            }

            if (count == targetCount) {
                // Compress this block to a single node
                Node compressed = new Node(current.value);
                prev.next = compressed;
                compressed.next = runner.next;

                current = runner.next;
            } else {
                prev = current;
                current = runner.next;
            }
        }

        head = dummy.next;
    }
}

public class compress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList sujith = new LinkedList();

        System.out.print("Enter number of elements: ");
        int total_size = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter the elements separated by space:");
        String[] inputs = sc.nextLine().split(" ");

        for (int i = 0; i < total_size; i++) {
            int value = Integer.parseInt(inputs[i]);
            sujith.addToEnd(value);
        }

        System.out.println("\nThe linked list before compression:");
        sujith.display();

        System.out.print("Enter compression target size: ");
        int comp = sc.nextInt();
        sujith.compresser(comp);

        System.out.println("\nThe linked list after compression:");
        sujith.display();
    }
}
