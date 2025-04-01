package PPS_related_codes.LinkedList;
import java.util.Scanner;


//ToDo 
//1. addToStart
//2. addToEnd
//3. showListContents
//4. replace
//5. insertAfter
//6. insertbefore
//7. reemove
//8. size
//9. contains


class List{

    class Node{
        public int v;
        private Node next;

        public Node(){

            v =  0;
            next = null;
        }
        public Node (int i , Node xt){
            v = i;
            next = xt;
        }


    }
    private Node head;
    public List (){
        head = null;
    }
//1. addToStart
    public void addToStart(int i){
        Node temp = new Node(i,head);
        temp.v = i;
        temp.next = head;
        head = temp;
    }
//2. addToEnd
public void addToEnd(int i) {
    Node newNode = new Node(i, null);
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

//3. DISPLAY
    public void display(){
        Node temp = head;
        if (temp == null){
            System.out.println("The linked list is empty");
        }
        else{
            System.out.println("Here are the list elements");
            while(temp != null){
                System.out.print(temp.v + "-->");
                 temp = temp.next;
            }
            System.out.println("X");
        }
    }
// 4, find 

public Node find(int x){
    if (head == null){
        return  null;
    }
    Node temp = head;
    while ( temp!= null){
        if (temp.v== x){
            return temp;
        }
        temp = temp.next;
    }
    return null;
}


    //5. replace
    public void replace(int i, int x){
        Node temp = head;

        if (head == null){
            System.out.println("There is no element in the linked list");
        }
        else{
            while (temp.next != null){
                if (temp.v == i){
                    temp.v = x;
                }
                temp = temp.next;

        }
        }
    }

    // 6. InsertAfter
    public void insertAfter(int i, int x){
        if (head == null){
            System.out.println("The linked list is empty");
        }
        Node temp = head;
        while ( temp.next != null && temp.next.v == i){
            temp = temp.next;
        }
        Node new1 = new Node(x,temp.next);
        temp.next = new1;
    }

    // 7 . insertBefore
    public void insertBefore(int i, int x) {
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
        if (head.v == i) {
            head = new Node(x, head);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.v != i) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value " + i + " not found in the list");
        } else {
            Node newNode = new Node(x, temp.next);
            temp.next = newNode;
        }
    }

    //  8 . Remove dUPLICATED

    public void removeDuplicates() {
        if (head == null) return;
    
        // First, count total number of nodes to size the array
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
    
        // Create array to store seen values
        int[] seen = new int[size];
        int seenCount = 0;
    
        Node current = head;
        Node prev = null;
    
        while (current != null) {
            boolean isDuplicate = false;
    
            // Linear search in seen[] to check for duplicates
            for (int i = 0; i < seenCount; i++) {
                if (seen[i] == current.v) {
                    isDuplicate = true;
                    break;
                }
            }
    
            if (isDuplicate) {
                // Remove duplicate
                prev.next = current.next;
            } else {
                seen[seenCount++] = current.v;
                prev = current;
            }
    
            current = current.next;
        }
    }public void removeDuplicates() {
        if (head == null) return;
    
        // First, count total number of nodes to size the array
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
    
        // Create array to store seen values
        int[] seen = new int[size];
        int seenCount = 0;
    
        Node current = head;
        Node prev = null;
    
        while (current != null) {
            boolean isDuplicate = false;
    
            // Linear search in seen[] to check for duplicates
            for (int i = 0; i < seenCount; i++) {
                if (seen[i] == current.v) {
                    isDuplicate = true;
                    break;
                }
            }
    
            if (isDuplicate) {
                // Remove duplicate
                prev.next = current.next;
            } else {
                seen[seenCount++] = current.v;
                prev = current;
            }
    
            current = current.next;
        }
    }

    public void traverseWithSkipPattern(int[] skipPattern) {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }
    
        Node current = head;
    
        for (int i = 0; i < skipPattern.length && current != null; i++) {
            if (skipPattern[i] == 1) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    // Can't skip, reached end
                    break;
                }
            }
            // if 0, we stay on the current node
        }
    
        if (current != null) {
            System.out.println("Final node value after pattern traversal: " + current.v);
        } else {
            System.out.println("Reached end of list before completing skip pattern.");
        }
    }

    public void printEvenAndOdd() {
        Node temp = head;
    
        System.out.print("Even elements: ");
        while (temp != null) {
            if (temp.v % 2 == 0) {
                System.out.print(temp.v + " ");
            }
            temp = temp.next;
        }
    
        temp = head;
        System.out.print("\nOdd elements: ");
        while (temp != null) {
            if (temp.v % 2 != 0) {
                System.out.print(temp.v + " ");
            }
            temp = temp.next;
        }
    
        System.out.println(); // newline at the end
    }
    

}


public class LinkedList1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List list = new List();

        System.out.print("How many numbers do you want to add? ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addToEnd(val);
        }

        System.out.println("Final list:");
        list.display();
        list.removeDuplicates();
        list.display();
        // System.out.print("Enter size of skip pattern: ");
        // int m = sc.nextInt();
        // int[] pattern = new int[m];
        // System.out.println("Enter skip pattern (0s and 1s):");
        // for (int i = 0; i < m; i++) {
        //     pattern[i] = sc.nextInt();
        // }
        // list.traverseWithSkipPattern(pattern);
        // list.display();
        list.printEvenAndOdd();
    }
}

// 
