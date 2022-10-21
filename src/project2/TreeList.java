/*
The TreeList class should be used to store all the Tree objects.

This class should be a simple version of a linked list. By simple we mean that 
you do not need to provide all the methods to make it a linked list, but the 
connectivity between elements should be done based on the linked list structure. 
(This is not a generic class. You will need to have an internal Node class that 
stores a Tree object as data and a reference to the next node. You will need to 
keep track of the head and, possibly tail references. )

The class needs to provide the default constructor that creates an empty list.
 */


package project2;

import java.util.Iterator;


public class TreeList{
	public int size;
	// Head of list
	Node head;
	Node tail;

	// Nested node class:
	static class Node {
		Tree data;
		Node next;

		// Node constructor:
		Node(Tree d){
			data = d;
			next = null;
		}
	}



	public TreeList() {

	}

	/*
	  Method that adds a given tree object to the current list; 
	  @throws IllegalArgumentException if the specified reference is null
	 */
	public void add(Tree tree) {
		Node newNode = new Node(tree);
		if(this.head == null) {
			this.head = newNode;
		}
		else {
			// Traverse to last node, insert
			Node last = this.head;
			while( last.next != null ) {
				last = last.next;
			}
			last.next = newNode;
		}
		size++;
	}

	/*
	  @returns the total number of Tree objects stored in the list
	 */
	public int getTotalNumberOfTrees() {
		return size; // TODO: implement this method
	}

	/*
	  @returns the total number of tree objects in the list whose common name is 
	  the same as the given speciesName. 
	  Case insensitive
	  @returns 0 if called with non-existent species
	 */
	public int getCountByCommonName( String speciesName ) {
		speciesName = speciesName.toLowerCase();

		Node n = this.head;
		int count = 0;

		while(n.next != null) {
			if( n.data.getSpc_common().equals(speciesName) ) {
				count++;
			}
			n = n.next;
		}
		if( n.data.getSpc_common().equals(speciesName) ){
			count++;
		}
		return count;
	}


	/*
	  @returns the total number of tree objects in the list whose common name is 
	  the same as the given speciesName. 
	  Case insensitive
	  @returns 0 if called with non-existent species
	 */
	public int getCountByLatinName(String speciesName ) {
		speciesName = speciesName.toLowerCase();

		Node n = this.head;
		int count = 0;

		while(n.next != null) {
			if( n.data.getSpc_latin().equals(speciesName) ) {
				count++;
			}
			n = n.next;
		}
		if( n.data.getSpc_latin().equals(speciesName) ){
			count++;
		}
		return count;
	}

	/*
	 @returns the number of Tree objects in the list that are located in the borough
	 equal to boroName
	 Case insensitive
	 @returns zero if called with non existent boro or species
	 */
	public int getCountByBorough( String boroName ) {
		boroName = boroName.toLowerCase();

		Node n = this.head;
		int count = 0;

		while(n.next != null) {
			if( n.data.getBoroname().equals(boroName) ) {
				count++;
			}
			n = n.next;
		}
		if( n.data.getBoroname().equals(boroName) ){
			count++;
		}
		return count;
	}

	/*
	 @returns the number of Tree objects in the list whose common name is the same 
	 as the given speciesName and which are located in the borough boroName.
	 Case insensitive
	 @returns 0 if called with non-existent boro name or species name
	 */
	public int getCountByCommonNameBorough( String speciesName, String boroName ) {
		boroName = boroName.toLowerCase();
		speciesName = speciesName.toLowerCase();

		Node n = this.head;
		int count = 0;

		while(n.next != null) {
			if( n.data.getBoroname().equals(boroName) ) {
				if( n.data.getSpc_common().equals(speciesName) ) {
					count++;
				}
			}
			n = n.next;
		}
		if( n.data.getBoroname().equals(boroName) ){
			if( n.data.getSpc_common().equals(speciesName) ) {
				count++;
			}
		}
		return count;
	}

	/*
	 @returns the number of Tree objects in the list whose Latin name is the same 
	 as the given speciesName and which are located in the borough boroName.
	 Case insensitive
	 @returns 0 if called with non-existent boro name or species name
	 */
	public int getCountByLatinNameBorough( String speciesName, String boroName ) {
		boroName = boroName.toLowerCase();
		speciesName = speciesName.toLowerCase();

		Node n = this.head;
		int count = 0;

		while(n.next != null) {
			if( n.data.getBoroname().equals(boroName) ) {
				if( n.data.getSpc_latin().equals(speciesName) ) {
					count++;
				}
			}
			n = n.next;
		}
		if( n.data.getBoroname().equals(boroName) ){
			if( n.data.getSpc_latin().equals(speciesName )) {
				count++;
			}
		}
		return count;
	}





}
