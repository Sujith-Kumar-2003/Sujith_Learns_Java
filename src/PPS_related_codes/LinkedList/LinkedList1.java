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
    public void addToEnd(int i){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        Node temp1 = new Node(i,null) ;
        temp.next = temp1; 
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

}

public class LinkedList1{
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        List list = new List();
        list.addToStart(5);
        list.addToStart(4);
        list.addToEnd(12);
        list.addToEnd(43);
        list.replace(12, 23);
        list.insertAfter(4, 6);
        list.insertBefore(5, 3);

        
        List.Node v = list.find(43);
        System.out.println(v.v);
        list.display();
    }

}

// 
