//package PPS_related_codes.Assignments.Bonus_Assignment;
//import java.util.*;
//
//class node {
//    int value;
//    node next;
//
//    public node(int value) {
//        this.value = value;
//        this.next = null;
//    }
//}
//
//class linkedlist {
//    private node head;
//
//    public linkedlist() {
//        this.head = null;
//    }
//
//    public void addToEnd(int value) {
//        node newNode = new node(value);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//
//        node temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = newNode;
//    }
//
//    public void display() {
//        if (head == null) {
//            System.out.println("The linked list is empty");
//            return;
//        }
//
//        node temp = head;
//        while (temp != null) {
//            System.out.print(temp.value);
//            if (temp.next != null) {
//                System.out.print("->");
//            }
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
//    public void w_parser(Node head){
//
//    }
//}
//
//public class W_parser {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        linkedlist sujith = new linkedlist();
//
//        System.out.print("Enter number of elements: ");
//        int total_size = sc.nextInt();
//        sc.nextLine(); // consume the leftover newline
//
//        System.out.println("Enter the elements separated by space:");
//        String[] inputs = sc.nextLine().split(" ");
//
//        for (int i = 0; i < total_size; i++) {
//            int value = Integer.parseInt(inputs[i]);
//            sujith.addToEnd(value);
//        }
//
//        System.out.println("The linked list is:");
//        sujith.display();
//    }
//}
