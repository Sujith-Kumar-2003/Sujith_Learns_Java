package PPS_related_codes.LinkedList;
import java.util.Scanner;


class List{

    class Node{
        private int v;
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

    public void addToStart(int i){
        Node temp = new Node(i,head);
        temp.v = i;
        temp.next = head;
        head = temp;
    }

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

}

public class LinkedList1{

    


    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        List list = new List();
        list.addToStart(5);
        list.addToStart(4);
        list.display();

        
    }

}