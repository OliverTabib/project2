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

public class TreeList {

	public TreeList() {

	}

	/*
	  Method that adds a given tree object to the current list; 
	  @throws IllegalArgumentException if the specified reference is null
	 */
	public void add(Tree tree) {
		// TODO: implement this method
	}

	/*
	  @returns the total number of Tree objects stored in the list
	 */
	public int getTotalNumberOfTrees() {
		return -1; // TODO: implement this method
	}

	/*
	  @returns the total number of tree objects in the list whose common name is 
	  the same as the given speciesName. 
	  Case insensitive
	  @returns 0 if called with non-existent species
	 */
	public int getCountByCommonName( String speciesName ) {
		return -1; // TODO: implement this method
	}


	/*
	  @returns the total number of tree objects in the list whose common name is 
	  the same as the given speciesName. 
	  Case insensitive
	  @returns 0 if called with non-existent species
	 */
	public int getCountByLatinName(String speciesName ) {
		return -1; // TODO: implement this method
	}

	/*
	 @returns the number of Tree objects in the list that are located in the borough
	 equal to boroName
	 Case insensitive
	 @returns zero if called with non existent boro or species
	 */
	public int getCountByBorough( String boroName ) {
		return -1; // TODO: implement
	}

	/*
	 @returns the number of Tree objects in the list whose common name is the same 
	 as the given speciesName and which are located in the borough boroName.
	 Case insensitive
	 @returns 0 if called with non-existent boro name or species name
	 */
	public int getCountByCommonNameBorough( String speciesName, String boroName ) {
		return -1; //TODO: implement
	}
	
	/*
	 @returns the number of Tree objects in the list whose Latin name is the same 
	 as the given speciesName and which are located in the borough boroName.
	 Case insensitive
	 @returns 0 if called with non-existent boro name or species name
	 */
	public int getCountByLatinNameBorough( String speciesName, String boroName ) {
		return -1; //TODO: implement
	}
	
	@Override
	public String toString() {
		return null; //TODO: implement
		
	}
	
	

}
