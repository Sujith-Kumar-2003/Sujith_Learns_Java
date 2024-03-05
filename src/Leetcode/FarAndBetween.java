package Leetcode;

import java.util.Scanner;

import Leetcode.LinkedList.Node;

class LinkedList {
	class Node {
		int value;
		Node next;
		
		public Node(int value2, Node node) {
			value = value2;
			next = node;
		}
	}
	Node head = null;
	
	public void addAtStart(int data) {
        head = new Node(data, head);  
    }
	
	public void addToEnd(int data) {
		if(head == null) {
			head = new Node(data, null);
		}else {
			Node temp = head;
			while(temp!=null && temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data, null);
		}
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			if(temp.next == null) {
				System.out.print(temp.value);
			}else {
				System.out.print(temp.value+" ");
			}
			temp = temp.next;
		}
		System.out.println();
	}
}

public class FarAndBetween{
	
	public static boolean insertBetween(LinkedList list, int x, int y) {
		Node temp = list.head;
		boolean isVisited = false;
		while(temp!=null && temp.next != null) {
			if(temp.value==x && temp.next.value==x) {
				temp.next = list.new Node(y, temp.next);
				isVisited = true;
				break;
			}
			temp = temp.next;
		}
		return isVisited;
	}
	
	public static boolean insertFar(LinkedList list, int x, int y, int D) {
		Node temp = list.head;
		boolean isVisited = false, Changed = false;
		while(temp!=null && temp.next != null) {
			if(temp.value==x) {
				isVisited = true;
			}
			if(isVisited && D==1) {
				temp.next = list.new Node(y, temp.next);
				Changed = true;
				break;
			}
			if(isVisited) {
				D--;
			}
			temp = temp.next;
		}
		if(!Changed && isVisited && D==1) {
			temp.next = list.new Node(y, null);
			Changed = true;
		}
		return isVisited&&Changed;
	}
	
	public static void main(String[] args) {
			LinkedList list = new LinkedList();
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.nextLine();
			String str;
			String val[];
			if(n > 0) {
				str = sc.nextLine();
				val = str.split(" ");
				for(String st : val) {
					list.addAtStart(Integer.parseInt(st));
				}
			}
			int m = sc.nextInt();
			sc.nextLine();
			if(m > 0) {
				str = sc.nextLine();
				val = str.split(" ");
				for(String st : val) {
					list.addToEnd(Integer.parseInt(st));
				}
			}
			list.print();
			str = sc.nextLine();
			val = str.split(" ");
			int x = Integer.parseInt(val[0]);
			int y = Integer.parseInt(val[1]);
			System.out.println(insertBetween(list, x, y));
			list.print();
			str = sc.nextLine();
			val = str.split(" ");
			x = Integer.parseInt(val[0]);
			y = Integer.parseInt(val[1]);
			int D =  Integer.parseInt(val[2]);
			System.out.println(insertFar(list, x, y, D));
			list.print();
	}
}





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

