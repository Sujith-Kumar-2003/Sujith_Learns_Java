package Leetcode;//A 1, AE 3, AP 1 2, DH, DP 1, DE

import java.util.Scanner;

public class newest {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        Node head; // head of the list

        // Constructor for an empty list
        public LinkedList() {
            this.head = null;
        }

        // Adding a node at the start
        public void addAtStart(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Adding a node at the end
        public void addAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        // Adding a node at the nth position
        public void addAtPosition(int data, int position) {
            Node newNode = new Node(data);
            if (position == 0) {
                addAtStart(data);
                return;
            }
            Node temp = head;
            for (int i = 1; temp != null && i < position; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position exceeds list size");
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

        // Deleting the head node
        public void deleteHead() {
            if (head != null) {
                head = head.next;
            }
        }

        // Deleting a node at the nth position
        public void deleteAtPosition(int position) {
            if (head == null) {
                return;
            }
            Node temp = head;
            if (position == 0) {
                head = temp.next;
                return;
            }
            for (int i = 1; temp != null && i < position; i++) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) {
                System.out.println("Position exceeds list size or is the last element");
                return;
            }
            temp.next = temp.next.next;
        }

        // Deleting a node at the end
        public void deleteAtEnd() {
            if (head == null) {
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node secondLast = head;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }
            secondLast.next = null;
        }

        // Traversing the linked list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        newest outerClassInstance = new newest(); // Create an instance of the enclosing class
        LinkedList list = outerClassInstance.new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter commands:");
        String inputLine = scanner.nextLine(); // Read the entire line of input
        String[] commands = inputLine.split(", "); // Split commands by comma and space

        for (String command : commands) {
            String[] parts = command.split(" "); // Split each command into parts
            switch (parts[0]) {
                case "A": // Add at start
                    list.addAtStart(Integer.parseInt(parts[1]));
                    break;
                case "AE": // Add at end
                    list.addAtEnd(Integer.parseInt(parts[1]));
                    break;
                case "AP": // Add at position
                    list.addAtPosition(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]));
                    break;
                case "DH": // Delete head
                    list.deleteHead();
                    break;
                case "DP": // Delete at position
                    list.deleteAtPosition(Integer.parseInt(parts[1]));
                    break;
                case "DE": // Delete at end
                    list.deleteAtEnd();
                    break;
                default:
                    System.out.println("Invalid command: " + parts[0]);
                    break;
            }
        }

        System.out.println("Final list:");
        list.display();
    }
}