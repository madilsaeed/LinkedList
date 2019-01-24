package com.utils;

public class LinkedList {
	
	Node head;
	public static class Node {
		
		Object data;
		Node next;
		
		Node(Object obj) {
			data = obj;
			next = null;
		}
	}
	
	public Boolean add(Object obj)
	{
		if(obj == null)
			return false;
		Node newNode = new Node(obj);
		if(head == null) {
			head = newNode;
			return true;
		}
		
		// triverse up to end of the list
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		// last contains the last node of the list
		last.next = newNode;
		return true;
	}

	public Node get(int index)
	{
		if(head==null)
			return null; // no element added in the list.
		if(head.next == null && index > 0)
			return null; // asked index does not exist in the list.
		
		Node next = head; // triverse list starting from head and find the element
		int currentIndex = 0;
		Boolean found = false;
		while(next.next != null)
		{
			if(currentIndex == index) {
				
				found = true;
				break;
			}
			next = next.next;
		}
		if(found) {
			// next contains the
			return next;
		} else {
			return null; // asked index does not exist in the list.
		} 
	}
	
	public void Reverse()
	{
		if(head.next == null)
			return; // there is only one element in the list
		
		Node next = null;
		Node prev = null;
		Node current = head;
		
		while(current.next != null) {
			
			next = current.next;
			current.next = prev;
			prev = current.next;
			current = next;
		}
		// current contains the last node of the list
		// set last node next to point second last node
		current.next = prev;
		//change head of the list to the last node.
		head = current;
	}
	
	public void Print()
	{
		Node current = head;
		while(current.next != null)
		{
			System.out.println(current.data); // invokes Object.toString()
			//All Java objects have a toString() method, which is invoked when you try and print the object.
			//This method is defined in the Object class (the superclass of all Java objects). 
			//By default, toString() method output will be formated as ObjectType@HashCode.
			//default definition return getClass().getName() + "@" + Integer.toHexString(hashCode());
			//To print custom data when you call System.out.println(Object), you must override the toString() method in your class.
//			class animal {
//			    private String name;
//			   
//				@Override
//			    public String toString()
//			    {
//			        return name;
//			    }
//			}
//
//			class B {
//			    public static void main(String args[])
//			    {
//			        animal obj = new animal();
//			        System.out.println(obj);
//			    }
//			}
			
			current = current.next;
		}
	}
}
