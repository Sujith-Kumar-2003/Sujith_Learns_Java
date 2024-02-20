package PPS_related_codes;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Linkedlist {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next; // Move to the next node in list1
            } else {
                current.next = list2;
                list2 = list2.next; // Move to the next node in list2
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements for the first linked list (space-separated, enter 'q' to stop):");
        ListNode list1 = createLinkedList(scanner);

        System.out.println("Enter elements for the second linked list (space-separated, enter 'q' to stop):");
        ListNode list2 = createLinkedList(scanner);

        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.println("Merged Sorted Linked List:");
        printList(mergedList);

        scanner.close();
    }

    private static ListNode createLinkedList(Scanner scanner) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                current.next = new ListNode(value);
                current = current.next;
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter integers or 'q' to stop.");
                }
            }
        }

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
