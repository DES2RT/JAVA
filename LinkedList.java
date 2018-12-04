

/** 
 * 
 * 	@author Dale Stewart
 * 	023567902
 * 
 * 	this file contains methods and vars necessary to create and edit a linked list of mobile devices,
 *	 object type MobileDevice.  the linked list class contains an inner class Node.
 */

public class LinkedList<T> {

	/** @param head of the Node class (an inner class) */
	public Node head; // Head is first node in linked list
	private static int count = 0;
	
	/** linked list constructors, one with no parameters, one with the head parameter of the Node class */
	public LinkedList() { 
		this.head = new Node();
		count = 0;
	}
	public LinkedList(Node h) {
		this.head = new Node(h);
		count++; // increment count variable
	}
	
	/** getter and setter for variable count */
	/** @param - count, number of Node's in the list */
	public void setCount(int c) {
		LinkedList.count = c;
	}
	/** @return count */
	public int getCount() {
		return LinkedList.count;
	}
	
	/** @return - true if list is empty, false if not */
	public boolean isEmpty() {
		return length() == 0;
	}
	public int length() {
		return this.getCount();
	}
	
	public void insertAtEnd(LLMobileDevice md) {
		Node temp = new Node(md);
		Node current = this.head;
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null) {
			current = current.getNext();
		}
		// the last nodes next reference set to new node temp
		current.setNext(temp);
		count++; // increment the number of elements variable
	} 
	
	public void insertAtBeginning(LLMobileDevice md) {
		// if list is empty add Node to the list
		if(count == 0) {
			this.head = new Node(md);
			this.head.next = null;
			count++; 								// increment number of Nodes variable
			System.out.println("counting " + count);
		}
		// if list is not empty create temp Node to hold data passed into method
		else {
			Node temp = new Node(md);
			Node current = this.head;		// create current Node to hold data from 'head' Node
			this.head = temp;					// make 'head' Node equal to the temp Node (with data passed in)
			temp.next = current;				// make 'head' Node's next point to the next Node in the list
			count++; 								// increment number of Nodes variable
			System.out.println("counting " + count);
		}
	}

	void insertAtIndex(int index, LLMobileDevice md) throws NullPointerException {
		Node temp = new Node(md);
		Node current = this.head;
		try {
			// crawl to the requested index or the last element in the list, whichever comes first
			for(int i = 0; i < index && current.getNext() != null; i++) 	{
				current = current.getNext();
			} 
		} catch(NullPointerException e) {
				System.out.println("Index " + index + " is out of range ");
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		count++; // increment the number of elements variable
	}

	Node findAtIndex(int index) throws NullPointerException {
		Node current = this.head;
		try {
			for(int i=0; i<index; i++) {
				current = current.getNext();
				count = i + 1;
			} 
		} catch (NullPointerException e) {
			System.out.println("Index " + index + " is out of range ");				
		}
		return current;
	}

	void deleteAtIndex(int index) throws NullPointerException {
		// create new Node make it equal to the head
		Node current = this.head;
		// crawl through list to specified index
		try {
			for(int i=0; i<index; i++) {
			// set current to the node at index
				current = current.getNext();
			} 
			// set next node to current nodes next nodes next node
			current.setNext(current.getNext().getNext());
			count--; // decrement count variable
		} catch (NullPointerException e) {
			System.out.println("Index " + index + " is out of range ");
		}
	}
	
	// iterate through the list
	public boolean iterateList(LLMobileDevice md) {System.out.println("iterate list");
		Node current = this.head;
		boolean found = false;
		while(current.getNext() != null) {
			System.out.println(current + " : " + md);
			current = current.getNext();
			if(current.data.compareTo(md) == 0) { 
				System.out.println(current + " : " + md);
				found = true;
			}
		}
		return found;
	}
/*
	void deleteData(MobileDevice device) {
		// TODO to be implemented
	}
*/	
	// returns the last Node object in the list
	public Node tail() {
		Node current = this.head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}
	
	public void print(LinkedList list) {

		System.out.println(list);
	}
	

	// public Overrides
	@Override
	public String toString() {
		String output = "";		
		output += this.head.data;
		Node current = head.getNext();
		while(current != null)	{
			output += current.getData() ;
			current = current.getNext();
		}
		System.out.print("\n");
		return output;
	}
	
	@Override
	public int hashCode() {
		int result = (int)this.length();
		result = 88 * result + (int)this.length();
		return result;		
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(! (o instanceof LinkedList) ) return false;
		
	//	LinkedList l = (LinkedList) o;
		
		return true;
	}
	
	/** inner class Node only exists within a linked list */
	public static class Node {
		
		/** private variables of the Node class */
		private LLMobileDevice data;	// data held in the Node
		private Node next;	// reference to the next Node in list
		
		/**
		 * @param d = data, MobileDevice settings;
		 * @param n = next, the next Node in the list
		 */
		public Node() {
			this.data = null;
			this.next = null;
		}
		public Node(LLMobileDevice md) {
			this.data = md;
			this.next = null;
		}
		public Node(Node n) {
			this.data = n.data;
			this.next = n.next;
		}
		
		/** getters and setters */
		/** @param = data, MobileDevice settings */
		public void setData(LLMobileDevice device) {
			this.data = device;
		}
		/** @return - the mobile device in the current Node */
		public LLMobileDevice getData() {
			return this.data;
		}
		
		/** @param = next, the next Node in the list */
		public void setNext(Node n) {
			this.next = new Node();
			this.next = n;
		}
		/** @return - the next Node in the list */
		public Node getNext() {
			return this.next;
		}
		
		@Override
		public String toString() {
				return this.getData() + "";
		}
		
		@Override
		public int hashCode() {
			int result = data.hashCode();
			result = 88 * result + data.hashCode();
			result += result;
			return result;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if( !(o instanceof Node) ) return false;
			
			Node node = (Node) o;
			
			if(this.data != node.data) return false;
			if(this.next != node.next) return false;
			
			return true;
		}
	}
}

