package Leetcode;
import Leetcode.newest.Node;

import java.util.Scanner;

public class new1 {
    class Node {
        int data;
        newest.Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        newest.Node head; // head of the list

        // Constructor for an empty list
        public LinkedList() {
            this.head = null;
        }

        // Adding a node at the start
        public void addAtStart(int data) {
            newest.Node newNode = new newest.Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Adding a node at the end
        public void addAtEnd(int data) {
            newest.Node newNode = new newest.Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newest.Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        // Adding a node at the nth position
        public void addAtPosition(int data, int position) {
            newest.Node newNode = new newest.Node(data);
            if (position == 0) {
                addAtStart(data);
                return;
            }
            newest.Node temp = head;
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
            newest.Node temp = head;
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
            newest.Node secondLast = head;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }
            secondLast.next = null;
        }

        // Traversing the linked list
        public void display() {
            newest.Node temp = head;
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

        System.out.println("Enter commands (type 'exit' to stop):");

        while (true) {
            String inputLine = scanner.nextLine(); // Read the entire line of input
            if (inputLine.equalsIgnoreCase("exit")) {
                break; // Exit the loop if user types 'exit'
            }
            String[] parts = inputLine.split("[()]"); // Split the command and arguments
            String methodName = parts[0];
            String[] arguments = parts.length > 1 ? parts[1].split(", ") : new String[0]; // Handle methods without arguments

            switch (methodName) {
                case "addAtStart":
                    list.addAtStart(Integer.parseInt(arguments[0]));
                    break;
                case "addAtEnd":
                    list.addAtEnd(Integer.parseInt(arguments[0]));
                    break;
                case "addAtPosition":
                    if (arguments.length == 2) {
                        list.addAtPosition(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[0]));
                    }
                    break;
                case "deleteHead":
                    list.deleteHead();
                    break;
                case "deleteAtPosition":
                    list.deleteAtPosition(Integer.parseInt(arguments[0]));
                    break;
                case "deleteAtEnd":
                    list.deleteAtEnd();
                    break;
                default:
                    System.out.println("Invalid command: " + methodName);
                    break;
            }
        }

        System.out.println("Final list:");
        list.display();
    }
}

