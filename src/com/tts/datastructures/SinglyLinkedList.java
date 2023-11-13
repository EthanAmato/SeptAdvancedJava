package com.tts.datastructures;

// To save time, we are NOT going to implement the Collections / List Interfaces
// because that would mean we would have to implement a BUNCH of different methods
// that we just don't have time for
public class SinglyLinkedList {

	// The thing that makes a LinkedList work is the inner class referred to as
	// A Node
	private static class Node {
		int data; // Data the node is keeping track of
		Node next; // Reference to the next node in the list

		Node(int data) {
			this.data = data;
			this.next = null; // Next is first initialized as null
		}
	}

	// Head of the list, which is initially null
	private Node head;

	// In our constructor, we will initialize the head as null
	public SinglyLinkedList() {
		this.head = null; // nothing in the list yet, so the head shouldn't point anywhere
	}

	public void add(int data) {
		// Create a new node to add to our linked list
		Node newNode = new Node(data);

		// if the list is already empty, we will make the new node we just made
		// the head of our list
		if (head == null) {
			head = newNode;
		} else {
			 // if there is something in the list, we will traverse to the end of the list
			// and add the node:
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}

			// Now that we know we are at the end of the list,
			// we can set the .next of current to the new node
			// we just made:

			current.next = newNode;
		}

	}
	
	
	public void remove(int data) {
		if(head == null) {
			return;
		}
		
		if (head.data == data) {
			head = head.next;
			return;
		}
		
		Node current = head;
		while (current.next != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		
		
		
		
	}
	
	
	
	
	
	public void display() {
		Node current = head;
		while(current!=null) {
			System.out.print(current.data + " -> ");
			current=current.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		
		myList.add(10);
		myList.add(20);
		myList.add(50);
		myList.add(70);

		myList.display();
		
		
		myList.remove(50);
		myList.display();

	}
	

}
