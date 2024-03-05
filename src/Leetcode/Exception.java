////LinkedList
//
//
//import Leetcode.LinkedList;


// PRINTING THE LINKED LIST
//public void print() {
//    Leetcode.LinkedList.Node temp = head;
//    while(temp != null) {
//        if(temp.next == null) {
//            System.out.print(temp.value);
//        }else {
//            System.out.print(temp.value+" ");
//        }
//        temp = temp.next;
//    }
//    System.out.println();
//}
//
//
//


//// TRAVERSING THE LINKED LIST
//Node temp = head;
//		while(temp!=null && temp.next != null) {
//temp = temp.next;
//		}
//
//// CREATING A LINKED LIST
//class LinkedList {
//    class Node {
//        int value;
//        Node next;
//
//        public Node(int value2, Node node) {
//            value = value2;
//            next = node;
//        }
//    }
//    public LinkedList() {
//
//    }
//
//    Node head = null;
//



//// REVERSING A PALINDROME QUESTION.
//
//package Leetcode;
//
//import java.util.Scanner;
//
//import lab8.LinkedList.Node;
//
//class LinkedList {
//	class Node {
//		int value;
//		Node next;
//
//		public Node(int value2, Node node) {
//			value = value2;
//			next = node;
//		}
//	}
//	public LinkedList() {
//
//	}
//
//	Node head = null;
//
//	public void addAtStart(int data) {
//        head = new Node(data, head);
//    }
//
//	public void addToEnd(int data) {
//	if(head == null) {
//		head = new Node(data, null);
//	}else {
//		Node temp = head;
//		while(temp!=null && temp.next != null) {
//			temp = temp.next;
//		}
//		temp.next = new Node(data, null);
//	}
//}
//
//	public void print() {
//		Node temp = head;
//		while(temp != null) {
//			if(temp.next == null) {
//				System.out.print(temp.value);
//			}else {
//				System.out.print(temp.value+" ");
//			}
//			temp = temp.next;
//		}
//		System.out.println();
//	}
//
//}
//




//public class ReversePalindrome {
//	public static void reverse(LinkedList list) {
//		Node prev = null;
//		Node start = list.head;
//		while(start!= null && start.next != null) {
//			Node temp = start.next;
//			start.next = prev;
//			prev = start;
//			start = temp;
//		}
//		start.next = prev;
//		list.head = start;
//	}
//
//	public static boolean palindrome(LinkedList list) {
//
//		LinkedList dup = new LinkedList();
//		Node temp1 = list.head;
//		if(list != null) {
//			dup.head = dup.new Node(temp1.value, null);
//			temp1 = temp1.next;
//			Node temp = dup.head;
//			while(temp1 != null) {
//				temp.next = dup.new Node(temp1.value, temp.next);
//				temp = temp.next;
//				temp1 = temp1.next;
//			}
//		}
//		reverse(dup);
//		while(list.head != null) {
//			if(list.head.value != dup.head.value) return false;
//			list.head = list.head.next;
//			dup.head = dup.head.next;
//		}
//		return true;
//	}
//
//	public static void main(String[] args) {
//		LinkedList list = new LinkedList();
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		sc.nextLine();
//		String str;
//		if(n > 0) {
//			str = sc.nextLine();
//			String[] val = str.split(" ");
//			for(String st : val) {
//				list.addToEnd(Integer.parseInt(st));
//			}
//			list.print();
//			reverse(list);
//			list.print();
//			System.out.println(palindrome(list));
//		}
//	}
//
//}
//
//




//// SWAPPING A NODE
//
//
//public class SwapNode {
//
//    public static Node swap(Node swap) {
//        if(swap == null || swap.next == null) return swap;
//        Node first = swap;
//        Node second = swap.next;
//
//        first.next = second.next;
//        second.next = first;
//
//        first.next = swap(first.next);
//        return second;
//    }
//
//    public static void swapPairs(LinkedList list) {
//
//        list.head = swap(list.head);
//
//    }
//
//    public static void main(String[] args) {
//
//        LinkedList list = new LinkedList();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String str;
//        if(n > 0) {
//            str = sc.nextLine();
//            String[] val = str.split(" ");
//            for(String st : val) {
//                list.addToEnd(Integer.parseInt(st));
//            }
//            list.print();
//            swapPairs(list);
//            list.print();
//        }
//
//    }
//
//}
//




//// MERGING 2 SINGLT LINKED LIST
//public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
//    Node dummy = new Node(0); // Dummy node to start the merged list.
//    Node tail = dummy; // Tail points to the last node of the merged list.
//
//    Node l1 = list1.head, l2 = list2.head;
//    while (l1 != null && l2 != null) {
//        if (l1.value < l2.value) {
//            tail.next = l1;
//            l1 = l1.next;
//        } else {
//            tail.next = l2;
//            l2 = l2.next;
//        }
//        tail = tail.next; // Move the tail pointer forward.
//    }
//
//    // Attach the remaining elements from either list1 or list2.
//    if (l1 != null) {
//        tail.next = l1;
//    }
//    if (l2 != null) {
//        tail.next = l2;
//    }
//
//    // Create a new LinkedList to return.
//    LinkedList result = new LinkedList();
//    result.head = dummy.next; // Exclude the dummy node.
//    return result;
//}
//
//    public static void main(String[] args) {
//        LinkedList list1 = new LinkedList();
//        list1.addToEnd(1);
//        list1.addToEnd(2);
//        list1.addToEnd(4);
//
//        LinkedList list2 = new LinkedList();
//        list2.addToEnd(1);
//        list2.addToEnd(3);
//        list2.addToEnd(4);
//
//        LinkedList mergedList = mergeSortedLists(list1, list2);
//        System.out.print("Merged List: ");
//        mergedList.printList();
//    }
//}
//
//




//// ADDING AND REMOVING NTH ELEMENT IN LINKED LIST
//
////class LinkedList {
//    class Node {
//        int value;
//        Node next;
//
//        public Node(int value) {
//            this.value = value;
//            this.next = null;
//        }
//    }
//
//    Node head = null;
//
//    // Method to add a new node at the start of the linked list
//    public void addAtStart(int data) {
//        Node newNode = new Node(data);
//        newNode.next = head;
//        head = newNode;
//    }
//
//    // Method to add a new node at the nth position in the linked list
//    public void addNth(int data, int position) {
//        if (position <= 0) {
//            System.out.println("Position should be greater than 0");
//            return;
//        }
//
//        if (position == 1) {
//            addAtStart(data);
//            return;
//        }
//
//        Node newNode = new Node(data);
//        Node temp = head;
//        for (int i = 1; temp != null && i < position - 1; i++) {
//            temp = temp.next;
//        }
//
//        if (temp == null) {
//            System.out.println("The position exceeds the list size");
//            return;
//        }
//
//        newNode.next = temp.next;
//        temp.next = newNode;
//    }
//
//    // Method to remove the nth node from the linked list
//    public void removeNth(int position) {
//        if (head == null) {
//            System.out.println("List is empty");
//            return;
//        }
//
//        if (position <= 0) {
//            System.out.println("Position should be greater than 0");
//            return;
//        }
//
//        Node temp = head;
//
//        if (position == 1) {
//            head = temp.next;
//            return;
//        }
//
//        for (int i = 1; temp != null && i < position - 1; i++) {
//            temp = temp.next;
//        }
//
//        if (temp == null || temp.next == null) {
//            System.out.println("The position exceeds the list size");
//            return;
//        }
//
//        Node next = temp.next.next;
//        temp.next = next;
//    }
//
//    // Method to print the linked list
//    public void printList() {
//        Node tnode = head;
//        while (tnode != null) {
//            System.out.print(tnode.value + " ");
//            tnode = tnode.next;
//        }
//        System.out.println();
//    }
//}
//
//




//// CREATING AND REMOVING NODE FROM NTH LAST NODE
//class LinkedList {
//    class Node {
//        int value;
//        Node next;
//
//        public Node(int value) {
//            this.value = value;
//            this.next = null;
//        }
//    }
//
//    Node head = null;
//
//    // Method to add an element at the nth position from the end
//    public void addNthFromEnd(int data, int n) {
//        Node dummy = new Node(0); // Dummy node to handle edge cases
//        dummy.next = head;
//        Node first = dummy;
//        Node second = dummy;
//
//        // Advance first n+1 places ahead, to maintain a gap of n between first and second
//        for (int i = 1; i <= n + 1; i++) {
//            first = first.next;
//            if (first == null && i != n + 1) {
//                System.out.println("Position exceeds the list size");
//                return;
//            }
//        }
//
//        // Move first to the end, maintaining the gap
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//
//        // Now second points to the node after which we need to insert the new node
//        Node newNode = new Node(data);
//        newNode.next = second.next;
//        second.next = newNode;
//
//        head = dummy.next; // In case the head was updated
//    }
//
//    // Method to remove the nth element from the end of the list
//    public void removeNthFromEnd(int n) {
//        Node dummy = new Node(0); // Dummy node to simplify edge cases
//        dummy.next = head;
//        Node first = dummy;
//        Node second = dummy;
//
//        // Advance first n+1 places ahead, to maintain a gap of n between first and second
//        for (int i = 1; i <= n + 1; i++) {
//            first = first.next;
//            if (first == null && i != n + 1) {
//                System.out.println("Position exceeds the list size");
//                return;
//            }
//        }
//
//        // Move first to the end, maintaining the gap
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//
//        // Skip the nth node from the end
//        second.next = second.next.next;
//
//        head = dummy.next; // In case the head was updated
//    }
//
//    // Method to print the linked list
//    public void printList() {
//        Node tnode = head;
//        while (tnode != null) {
//            System.out.print(tnode.value + " ");
//            tnode = tnode.next;
//        }
//        System.out.println();
//    }
//}
//
//
//



//public class FarAndBetween{
//
//    public static boolean insertBetween(LinkedList list, int x, int y) {
//        Node temp = list.head;
//        boolean isVisited = false;
//        while(temp!=null && temp.next != null) {
//            if(temp.value==x && temp.next.value==x) {
//                temp.next = list.new Node(y, temp.next);
//                isVisited = true;
//                break;
//            }
//            temp = temp.next;
//        }
//        return isVisited;
//    }
//
//    public static boolean insertFar(LinkedList list, int x, int y, int D) {
//        Node temp = list.head;
//        boolean isVisited = false, Changed = false;
//        while(temp!=null && temp.next != null) {
//            if(temp.value==x) {
//                isVisited = true;
//            }
//            if(isVisited && D==1) {
//                temp.next = list.new Node(y, temp.next);
//                Changed = true;
//                break;
//            }
//            if(isVisited) {
//                D--;
//            }
//            temp = temp.next;
//        }
//        if(!Changed && isVisited && D==1) {
//            temp.next = list.new Node(y, null);
//            Changed = true;
//        }
//        return isVisited&&Changed;
//    }
//
//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String str;
//        String val[];
//        if(n > 0) {
//            str = sc.nextLine();
//            val = str.split(" ");
//            for(String st : val) {
//                list.addAtStart(Integer.parseInt(st));
//            }
//        }
//        int m = sc.nextInt();
//        sc.nextLine();
//        if(m > 0) {
//            str = sc.nextLine();
//            val = str.split(" ");
//            for(String st : val) {
//                list.addToEnd(Integer.parseInt(st));
//            }
//        }
//        list.print();
//        str = sc.nextLine();
//        val = str.split(" ");
//        int x = Integer.parseInt(val[0]);
//        int y = Integer.parseInt(val[1]);
//        System.out.println(insertBetween(list, x, y));
//        list.print();
//        str = sc.nextLine();
//        val = str.split(" ");
//        x = Integer.parseInt(val[0]);
//        y = Integer.parseInt(val[1]);
//        int D =  Integer.parseInt(val[2]);
//        System.out.println(insertFar(list, x, y, D));
//        list.print();
//    }
//}



//0
//3
//9 8 7
//9 8 7
//4 3
//false
//9 8 7
//9 12 1
//false
//9 12 8 7



//// CREATING A DOUBLY LINKED LIST
//
//import java.util.Scanner;
//
//    class DoublyLinkedList {
//        class Node {
//            int value;
//            Node next;
//            Node prev;
//
//            public Node(int value) {
//                this.value = value;
//                this.next = null;
//                this.prev = null;
//            }
//        }
//
//        Node head = null;
//        Node tail = null;
//
//        public void addAtStart(int data) {
//            Node newNode = new Node(data);
//            if (head == null) {
//                head = tail = newNode;
//            } else {
//                newNode.next = head;
//                head.prev = newNode;
//                head = newNode;
//            }
//        }
//
//        public void addToEnd(int data) {
//            Node newNode = new Node(data);
//            if (head == null) {
//                head = tail = newNode;
//            } else {
//                tail.next = newNode;
//                newNode.prev = tail;
//                tail = newNode;
//            }
//        }
//
//        public void print() {
//            Node temp = head;
//            while (temp != null) {
//                if (temp.next == null) {
//                    System.out.print(temp.value);
//                } else {
//                    System.out.print(temp.value + " ");
//                }
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//
//        public void printReverse() {
//            Node temp = tail;
//            while (temp != null) {
//                if (temp.prev == null) {
//                    System.out.print(temp.value);
//                } else {
//                    System.out.print(temp.value + " ");
//                }
//                temp = temp.prev;
//            }
//            System.out.println();
//        }
//    }
//
//





//package Leetcode;//// basic.java
//
////public class UnavailableTransactionException extends Exception {
////    public UnavailableTransactionException(String message) {
////        super(message);
////    }
////}
////
////public class InsufficientFundsException extends RuntimeException {
////    public InsufficientFundsException(String message) {
////        super(message);
////    }
////}
//
//public class BankAccount
//{
//
//    public static boolean transactions_available = true;
//
//    private double balance; // the account balance
//
//    private double threshold; // the overdraft limit / minimum balance
//
//
//
//    /** constructs a new, empty account */
//
//    public BankAccount ()
//    {
//
//        balance = 0;
//
//        threshold = 0;
//
//    }
//
//
//
//    /** constructs an account with the provided balance */
//
//    public BankAccount (double initialBalance)
//    {
//
//        balance = initialBalance;
//
//        threshold = 0;
//
//    }
//
//
//
//    /** adds the indicated amount to this account
//
//          * @throws UnavailableTransactionException at certain specified times, check the operating guide  */
//
//
//    public void deposit (double amount) throws UnavailableTransactionException
//    {
//
//        if (transactions_available)
//        {
//
//            double newBalance = balance + amount;
//
//            balance = newBalance;
//
//        }
//        else
//        {
////             throw UnavailableTransactionException
//
//            throw new UnavailableTransactionException ("deposits not available at this time");
//
//        }
//
//    }
//
//
//    /** withdraws the indicated amount from this account. Use getBalance first before
//
//     * withdrawing funds
//
//          * @throws InsufficientFundsException when there are insufficient funds for the transaction
//
//     */
//
//    public void withdraw (double amount)
//    {
//
//        double newBalance = balance - amount;
//
//        if (newBalance >= threshold)
//        {
//
//            balance = newBalance;
//
//        }
//        else
//        {
//
//            String message = "Check balance beforehand: balance = " + this.getBalance () +
//
//                    " amount requested: " + amount;
//
//            throw new InsufficientFundsException (message);
//
//        }
//
//    }
//
//    /** provides this account's current balance */
//
//    public double getBalance ()
//    {
//
//        return balance;
//
//    }
//
//
//
//    /** updates the minumum balance - a negative value is overdraft*/
//
//    public void setMinimumBalance (double minBalance)
//    {
//
//        threshold = minBalance;
//
//    }
//
//
//}
//////
////// Our "HelloWorld" exception example. In the bar() method we see the basic
////// try/catch mechanism. In the try block, we call the method foo(). The method foo()
////// "throws" an exception which is letter "caught" of trapped by the catch block in
////// bar(). Note that the exception type in the catch block matches the exception type thrown
////// by foo.
////
////
////class myException extends Exception{ }
////
////class Test{
////
////    // throw an exception in this method
////    public void foo() throws myException{
////        throw new myException();
////    }
////
////
////    public void bar(){
////        System.out.println("Calling the foo method...");
////
////        try{
////            foo();
////        }
////        catch (myException e) { // catch the exception generated in the try block
////            System.out.println("I caught myException");
////        }
////    }
////}
////
////
////
////public class Basic {
///
//
////? Bank Test exception Handling
////public class BankTest {
////
////    public static void main(String [] args) throws Exception{
////        try {
////            throw new RuntimeException();
////        }
////        catch (RuntimeException e) {
////            System.out.println ("1st catch");
////            throw e;
////        }
////        catch (Exception e) {
////            System.out.println ("2nd catch");
////            throw e;
////        }
////
////    }
////}
//
//




////Importing ArrayList
////To use ArrayList, you first need to import it:
////
//
////import java.util.ArrayList;
//
////Creating an ArrayList
////You can create an ArrayList object with or without specifying the type of elements it can contain. Specifying a type via generics provides type safety.
////
//
////ArrayList<String> list = new ArrayList<String>(); // Creating an ArrayList to store String objects
////Adding Elements
////You can add elements to an ArrayList using the add method:
////
//
////list.add("Hello");
////list.add("World");
////Accessing Elements
////Elements can be accessed by their index (position in the list), starting from 0:
////
//
////String element = list.get(0); // Accesses the first element of the list
////Updating Elements
////You can change the element of an ArrayList at a specified position using the set method:
////
//
////list.set(1, "Java"); // Replaces "World" with "Java" at index 1
////Removing Elements
////You can remove elements either by their index or by the element value itself:
////
//
////list.remove(0); // Removes the element at index 0
////list.remove("Java"); // Removes "Java" from the list
////Size of the ArrayList
////The size method returns the number of elements in the list:
////
//
////int size = list.size();
////Iterating Over an ArrayList
////You can iterate over elements using a simple for-loop, an enhanced for-loop, or an iterator:
////
//
////// Enhanced for-loop
////for (String str : list) {
////        System.out.println(str);
////}
////Converting ArrayList to Array
////You can convert an ArrayList to an array using the toArray method:
////
//
////String[] array = new String[list.size()];
////list.toArray(array); // Converts the ArrayList into an array
////Checking if an ArrayList is Empty
////The isEmpty method checks if the list is empty:
////
//
////boolean isEmpty = list.isEmpty();
////Clearing an ArrayList
////The clear method removes all elements from the list:
////
//
////list.clear();
////Checking for the Existence of an Element
////To check if an element exists in the list, use the contains method:
////
//
////boolean contains = list.contains("Java");
//
//




//// CODE FROM MR>B>
//package Leetcode;//A 1, AE 3, AP 1 2, DH, DP 1, DE
//
//import java.util.Scanner;
//
//public class newest {
//    class Node {
//        int data;
//        Node next;
//
//        Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    class LinkedList {
//        Node head; // head of the list
//
//        // Constructor for an empty list
//        public LinkedList() {
//            this.head = null;
//        }
//
//        // Adding a node at the start
//        public void addAtStart(int data) {
//            Node newNode = new Node(data);
//            newNode.next = head;
//            head = newNode;
//        }
//
//        // Adding a node at the end
//        public void addAtEnd(int data) {
//            Node newNode = new Node(data);
//            if (head == null) {
//                head = newNode;
//            } else {
//                Node temp = head;
//                while (temp.next != null) {
//                    temp = temp.next;
//                }
//                temp.next = newNode;
//            }
//        }
//
//        // Adding a node at the nth position
//        public void addAtPosition(int data, int position) {
//            Node newNode = new Node(data);
//            if (position == 0) {
//                addAtStart(data);
//                return;
//            }
//            Node temp = head;
//            for (int i = 1; temp != null && i < position; i++) {
//                temp = temp.next;
//            }
//            if (temp == null) {
//                System.out.println("Position exceeds list size");
//            } else {
//                newNode.next = temp.next;
//                temp.next = newNode;
//            }
//        }
//
//        // Deleting the head node
//        public void deleteHead() {
//            if (head != null) {
//                head = head.next;
//            }
//        }
//
//        // Deleting a node at the nth position
//        public void deleteAtPosition(int position) {
//            if (head == null) {
//                return;
//            }
//            Node temp = head;
//            if (position == 0) {
//                head = temp.next;
//                return;
//            }
//            for (int i = 1; temp != null && i < position; i++) {
//                temp = temp.next;
//            }
//            if (temp == null || temp.next == null) {
//                System.out.println("Position exceeds list size or is the last element");
//                return;
//            }
//            temp.next = temp.next.next;
//        }
//
//        // Deleting a node at the end
//        public void deleteAtEnd() {
//            if (head == null) {
//                return;
//            }
//            if (head.next == null) {
//                head = null;
//                return;
//            }
//            Node secondLast = head;
//            while (secondLast.next.next != null) {
//                secondLast = secondLast.next;
//            }
//            secondLast.next = null;
//        }
//
//        // Traversing the linked list
//        public void display() {
//            Node temp = head;
//            while (temp != null) {
//                System.out.print(temp.data + " -> ");
//                temp = temp.next;
//            }
//            System.out.println("null");
//        }
//    }
//    public static void main(String[] args) {
//        newest outerClassInstance = new newest(); // Create an instance of the enclosing class
//        LinkedList list = outerClassInstance.new LinkedList();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter commands:");
//        String inputLine = scanner.nextLine(); // Read the entire line of input
//        String[] commands = inputLine.split(", "); // Split commands by comma and space
//
//        for (String command : commands) {
//            String[] parts = command.split(" "); // Split each command into parts
//            switch (parts[0]) {
//                case "A": // Add at start
//                    list.addAtStart(Integer.parseInt(parts[1]));
//                    break;
//                case "AE": // Add at end
//                    list.addAtEnd(Integer.parseInt(parts[1]));
//                    break;
//                case "AP": // Add at position
//                    list.addAtPosition(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]));
//                    break;
//                case "DH": // Delete head
//                    list.deleteHead();
//                    break;
//                case "DP": // Delete at position
//                    list.deleteAtPosition(Integer.parseInt(parts[1]));
//                    break;
//                case "DE": // Delete at end
//                    list.deleteAtEnd();
//                    break;
//                default:
//                    System.out.println("Invalid command: " + parts[0]);
//                    break;
//            }
//        }
//
//        System.out.println("Final list:");
//        list.display();
//    }
//}