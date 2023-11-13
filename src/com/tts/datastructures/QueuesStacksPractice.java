package com.tts.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuesStacksPractice {

	public static void main(String[] args) {
		// Queue: is a data structure where elements are added at the back
		// and exit through the front. Think of a disneyland line -> you join the
		// back of the line, you wait until it's your turn, and then you exit (onto the ride)
		// from the front of the line 
		
		// To create a Queue in Java, we need the Queue interface:
		// This basically tells java to make a new linked list, but restrict to only
		// the methods that exist on the Queue interface
		Queue<String> supportTickets = new LinkedList<>();
		
		// Since this was the first ticket submitted, it will also be the first ticket
		// handled by a support staff:
		supportTickets.add("Ticket 1: My Minecraft Server Crashed");
		System.out.println(supportTickets);

		// We must first wait for ticket 1 to be removed before handling this 
		// support ticket
		supportTickets.add("Ticket 2: My Internet Crashed");
		System.out.println(supportTickets);

		supportTickets.add("Ticket 3: Eclipse is being eclipse");
 		System.out.println(supportTickets);
		
 		
 		// Poll method will remove the head of the queue (the one who has been
 		// waiting the longest) and returns it:
 		String currentTicket = supportTickets.poll();
 		System.out.println(currentTicket);
 		System.out.println(supportTickets);

 		// This behavior of being 'first in and first out' makes a Queue something
 		// called a FIFO structure
 		// supportTickets.remove();
 		
 		
 		// Stack -> In contrast to a queue being FIFO (first in first out), a Stack
 		// is a LIFO structure (Last In First Out). Think of a stack of plates: the last
 		// plate you put on top is the first one you would remove. We can see this
 		// all over the place in computers
 		// 1. One main thing that can be implemented using a stack is the CTRL+Z functionality
 		// (undoing stuff)
 		// 2. Back navigation in browsers -> I go to Google.com -> Youtube.com -> imgur 
 		// if I press the back button while on Titus, titus will be removed from my stack and I will
 		// be relocated to Youtube.com. If I press back again, Youtube will be removed and I will be
 		// sent back to Google.com
 		
 		// We will import the Stack
 		Stack<String> browserHistory = new Stack<>();
 		
 		// We can push a new string to the top of the stack
 		// We are now visiting 'Page 1'
 		browserHistory.push("Page 1");
 		
 		// Leave Page 1 behind and go to Page 2:
 		// If we were to try and remove an item from the
 		// stack at this point, WE CAN ONLY REMOVE Page 2
 		browserHistory.push("Page 2");
 		
 		
 		// Leave page 2 behind and go to page 3:
 		browserHistory.push("Page 3");
 		
 		System.out.println(browserHistory);
 		
 		// But let's say we wanted to go back a page
 		// we can now call the .pop() method which will
 		// remove the very top element in our Stack:
 		browserHistory.pop();
 		System.out.println(browserHistory);
 		browserHistory.pop();
 		System.out.println(browserHistory);
 		
 		
	}
	
}
