package PPS_related_codes.LinkedList;

import java.util.Scanner;

class CombinedStructure {

    // Singly Linked List Node
    static class SNode {
        int data;
        SNode next;
        DNode down; // Link to a doubly linked list

        SNode(int data) {
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }

    // Doubly Linked List Node
    static class DNode {
        int data;
        DNode prev, next;
        SNode up; // Link back to a singly node

        DNode(int data) {
            this.data = data;
            this.prev = this.next = null;
            this.up = null;
        }
    }

    private SNode sHead;

    public CombinedStructure() {
        sHead = null;
    }

    // Add to singly linked list
    public void addToSingly(int val) {
        SNode newNode = new SNode(val);
        if (sHead == null) {
            sHead = newNode;
        } else {
            SNode temp = sHead;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    public void zigZagTraversal() {
        System.out.println("Zig-Zag Traversal:");
        SNode sTemp = sHead;
    
        while (sTemp != null) {
            System.out.print(sTemp.data + " ");
    
            // If there's a linked doubly list, traverse it
            DNode dTemp = sTemp.down;
            while (dTemp != null) {
                System.out.print(dTemp.data + " ");
                dTemp = dTemp.next;
            }
    
            sTemp = sTemp.next;
        }
    
        System.out.println(); // For newline at end
    }

    // Attach doubly list to a singly node
    public void attachDoublyToSinglyNode(int sVal, int[] dValues) {
        SNode sTemp = sHead;
        while (sTemp != null && sTemp.data != sVal) {
            sTemp = sTemp.next;
        }

        if (sTemp == null) {
            System.out.println("Singly node with value " + sVal + " not found.");
            return;
        }

        DNode dHead = null, dTail = null;

        for (int val : dValues) {
            DNode newDNode = new DNode(val);
            newDNode.up = sTemp;

            if (dHead == null) {
                dHead = dTail = newDNode;
            } else {
                dTail.next = newDNode;
                newDNode.prev = dTail;
                dTail = newDNode;
            }
        }

        sTemp.down = dHead;
    }

    // Traverse all
    public void traverseStructure() {
        System.out.println("Traversing Combined Structure:");
        SNode sTemp = sHead;
        while (sTemp != null) {
            System.out.print("Singly Node: " + sTemp.data);
            if (sTemp.down != null) {
                System.out.print(" => Doubly: ");
                DNode dTemp = sTemp.down;
                while (dTemp != null) {
                    System.out.print(dTemp.data);
                    if (dTemp.next != null) System.out.print(" <-> ");
                    dTemp = dTemp.next;
                }
            }
            System.out.println();
            sTemp = sTemp.next;
        }
    }

    // Jump from DNode to its linked SNode
    public void jumpFromDoublyToSingly(int dVal) {
        SNode sTemp = sHead;
        while (sTemp != null) {
            DNode dTemp = sTemp.down;
            while (dTemp != null) {
                if (dTemp.data == dVal) {
                    System.out.println("Doubly node " + dVal + " is linked to singly node: " + dTemp.up.data);
                    return;
                }
                dTemp = dTemp.next;
            }
            sTemp = sTemp.next;
        }
        System.out.println("Doubly node with value " + dVal + " not found.");
    }
}

public class HybridLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CombinedStructure structure = new CombinedStructure();

        // Step 1: Create singly linked list
        System.out.print("Enter number of singly linked list nodes: ");
        int sCount = sc.nextInt();
        System.out.println("Enter " + sCount + " values:");
        for (int i = 0; i < sCount; i++) {
            structure.addToSingly(sc.nextInt());
        }

        // Step 2: Attach doubly linked lists to selected singly nodes
        System.out.print("Enter number of singly nodes to attach a doubly list to: ");
        int attachCount = sc.nextInt();
        for (int i = 0; i < attachCount; i++) {
            System.out.print("Enter the singly node value to attach doubly list to: ");
            int sVal = sc.nextInt();

            System.out.print("Enter number of nodes in the doubly list for " + sVal + ": ");
            int dSize = sc.nextInt();
            int[] dVals = new int[dSize];
            System.out.println("Enter " + dSize + " values:");
            for (int j = 0; j < dSize; j++) {
                dVals[j] = sc.nextInt();
            }

            structure.attachDoublyToSinglyNode(sVal, dVals);
        }

        // Step 3: Display entire structure
        structure.traverseStructure();

        // Step 4: Jump from doubly to singly
        System.out.print("Enter a doubly node value to find its linked singly node: ");
        int dFind = sc.nextInt();
        structure.jumpFromDoublyToSingly(dFind);
    }
}
